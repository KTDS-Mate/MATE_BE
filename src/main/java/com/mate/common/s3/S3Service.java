package com.mate.common.s3;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import jakarta.annotation.PostConstruct;

@Service
public class S3Service {

    private final Logger log = LoggerFactory.getLogger(S3Service.class);

    private final AmazonS3 amazonS3;

    @Value("${cloud.aws.s3.bucket}")
    private String bucketName;

    public String getBucketName() {
        return this.bucketName;
    }
    
    public S3Service(AmazonS3 amazonS3) {
        this.amazonS3 = amazonS3;
    }
    
    @PostConstruct
    public void init() {
    }

    /**
     * S3로 파일 업로드 후 해당 파일의 S3 URL을 반환
     */
    public String uploadFile(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("업로드할 파일이 없습니다.");
        }

        // 파일명 난수화 처리
        String originalFilename = file.getOriginalFilename();
        String fileExtension = "";
        if (originalFilename != null && originalFilename.contains(".")) {
            fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
        }
        String s3FileName = UUID.randomUUID().toString() + fileExtension;

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        metadata.setContentType(file.getContentType());

        try {
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, s3FileName, file.getInputStream(), metadata)
                    .withCannedAcl(CannedAccessControlList.PublicRead); 
            // PublicRead로 설정하면 누구나 접근 가능한 URL
            amazonS3.putObject(putObjectRequest);
        } catch (IOException e) {
            throw new RuntimeException("S3 업로드 중 IOException 발생", e);
        }

        // 업로드한 파일의 접근 가능한 URL 반환
        String fileUrl = amazonS3.getUrl(bucketName, s3FileName).toString();
        return fileUrl;
    }

    /**
     * Pre-Signed URL 생성
     * @param originalFileName 원본 파일명
     * @param method           HTTP 메서드 (PUT: 업로드, GET: 다운로드)
     * @param expirationTimeMillis URL의 만료 시간 (밀리초 단위)
     * @return Pair of Pre-Signed URL and Sanitized File Name
     */
    public Pair<String, String> generatePresignedUrl(String originalFileName, HttpMethod method, long expirationTimeMillis, String contentType) {
        try {
            log.info("presigned URL 생성 - originalFileName: {}, method: {}, contentType: {}", 
                originalFileName, method, contentType);

            String fileExtension = "";
            if (originalFileName != null && originalFileName.contains(".")) {
                fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
            }
            
            String sanitizedFileName = UUID.randomUUID().toString() + fileExtension;

            Date expiration = new Date();
            expiration.setTime(System.currentTimeMillis() + expirationTimeMillis);

            GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(bucketName, sanitizedFileName)
                .withMethod(method)
                .withExpiration(expiration);

            // Content-Type 헤더 추가
            if (method == HttpMethod.PUT && contentType != null) {
                request.setContentType(contentType);
            }

            URL url = amazonS3.generatePresignedUrl(request);
            String presignedUrl = url.toString();
            
            return Pair.of(presignedUrl, sanitizedFileName);

        } catch (Exception e) {
            log.error("presigned URL 생성 실패", e);
            throw new RuntimeException("presigned URL 생성 실패", e);
        }
    }

    
    /**
     * 업로드용 Pre-Signed URL 생성
     */
    public Pair<String, String> generateUploadUrl(String originalFileName, String contentType) {
        return generatePresignedUrl(originalFileName, HttpMethod.PUT, 3600 * 1000, contentType); // 1시간
    }

    /**
     * 다운로드용 Pre-Signed URL 생성
     */
    public String generateDownloadUrl(String fileName) {
        try {
            // 다운로드는 이미 저장된 파일명을 사용
            GeneratePresignedUrlRequest generatePresignedUrlRequest =
                    new GeneratePresignedUrlRequest(bucketName, fileName)
                            .withMethod(HttpMethod.GET)
                            .withExpiration(new Date(System.currentTimeMillis() + 3600 * 1000));
                            // .withCannedAcl(CannedAccessControlList.PublicRead); // 제거

            URL url = amazonS3.generatePresignedUrl(generatePresignedUrlRequest);
            log.info("Generated presigned URL: {}", url.toString());  // 로깅 추가
            return url.toString();
        } catch (Exception e) {
            log.error("Presigned URL 생성 실패: {} - {}", fileName, e.getMessage(), e);
            return null;
        }
    }
    
    public String generatePresignedUrlForDownload(String existingFileName, HttpMethod method, long expirationTimeMillis) {
        try {
            Date expiration = new Date();
            expiration.setTime(System.currentTimeMillis() + expirationTimeMillis);

            GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(bucketName, existingFileName)
                .withMethod(method)
                .withExpiration(expiration);

            String fileExtension = existingFileName.substring(existingFileName.lastIndexOf(".") + 1).toLowerCase();
            String contentType = "image/" + (fileExtension.equals("jpg") ? "jpeg" : fileExtension);
            
            request.addRequestParameter("response-content-type", contentType);
            request.addRequestParameter("response-content-disposition", 
                String.format("inline; filename=\"%s\"", URLEncoder.encode(existingFileName, StandardCharsets.UTF_8)));
            
            URL url = amazonS3.generatePresignedUrl(request);
            log.info("생성된 프리사인드 URL: {}", url.toString());
            
            return url.toString();
            
        } catch (Exception e) {
            log.error("프리사인드 URL 생성 실패: {}", e.getMessage(), e);
            throw new RuntimeException("프리사인드 URL 생성 실패", e);
        }
    }

    /**
     * 파일 삭제
     * @param fileName S3에 저장된 파일명 (key)
     */
    public void deleteFile(String fileName) {
        amazonS3.deleteObject(bucketName, fileName);
    }
}
