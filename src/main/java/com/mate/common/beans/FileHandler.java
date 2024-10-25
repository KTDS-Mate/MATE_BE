//package com.mate.common.beans;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.io.UnsupportedEncodingException;
//import java.util.UUID;
//
//import org.apache.poi.ss.usermodel.Workbook;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.io.InputStreamResource;
//import org.springframework.core.io.Resource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.mate.common.vo.StoreResultVO;
//
//
///**
// * @Component Spring Bean 으로 생성해라
// */
//@Component
//public class FileHandler {
//	
//	// application.yml 파일에서 "app.multipart.base-dir" 설정 값을 가져옴
//	// @Value는 Spring Bean에서만 사용 가능
//	// Spring Bean : @Controller, @Service, @Repository
//	// Spring Bean을 만들어 주는 Annotation : @Component
//	@Value("${app.multipart.base-dir}")
//	private String baseDirectory;
//	
//	/**
//	 * 난독화 할 것인가?
//	 */
//	@Value("${app.multipart.obfuscation.enable}")
//	private boolean enableObfuscation;
//	
//	/**
//	 * 확장자를 지울것인가?
//	 */
//	@Value("${app.multipart.obfuscation.hide-ext.enable}")
//	private boolean enableHideExtention;
//	
//	/**
//	 * 파일을 업로드해주는 Helper
//	 * @param multipartFile
//	 */
//	public StoreResultVO storeFile(MultipartFile multipartFile) {
//		// 1. 클라이언트가 파일을 전송했는 지 확인
//		// 2. 클라이언트가 파일을 전송했다면
//		if (multipartFile != null && !multipartFile.isEmpty()) {
//			// 3. 파일을 서버 컴퓨터의 특정 폴더로 저장시킴
//			String obfuscatedFileName = multipartFile.getOriginalFilename();
//			if (this.enableObfuscation) { // enableObfuscation이 True 라면 난수를 넣어줌
//				String ext = obfuscatedFileName.substring(obfuscatedFileName.lastIndexOf(".")); // 확장자만 분리
//				obfuscatedFileName = UUID.randomUUID().toString();
//				if ( ! this.enableHideExtention) { // enableHideExtention이 False라면 확장자를 붙여라
//					obfuscatedFileName += ext;
//				}
//			}
//			
//			File uploadFile = new File(this.baseDirectory, obfuscatedFileName);
//			if (!uploadFile.getParentFile().exists()) {
//				uploadFile.getParentFile().mkdirs(); // 만약 폴더가 없다면 만들어라 -> 없으면 IOException 발생
//			}
//			try {
//				multipartFile.transferTo(uploadFile); // 서버 컴퓨터에 저장
//			} catch (IllegalStateException | IOException e) { // 용량이 가득 찼을 때 IOException이 발생
//				// C드라이브에 접근하려 하면 IllegalStateException 발생
//				e.printStackTrace();
//				throw new RuntimeException("예기치 못한 이유로 업로드에 실패했습니다. 잠시 후 다시 시도해주세요.");
//			}
//			return new StoreResultVO(multipartFile.getOriginalFilename(), obfuscatedFileName);
//		}
//		// 파일을 업로드 하지 않았을 때는 아무 것도 들어가지 않게 null 반환
//		return null;
//	}
//	
//	public String createXlsxFile(Workbook workbook){
//		String fileName = "temporary_file_"+ UUID.randomUUID().toString();
//		File xlsxFile = new File(this.baseDirectory, fileName);
//		
//		OutputStream os = null;
//		try {
//			os = new FileOutputStream(xlsxFile);
//				workbook.write(os);
//		} catch (IOException e) {
//			throw new IllegalArgumentException("엑셀파일을 만들 수 없습니다.");
//		} finally {
//			try {
//				workbook.close();
//			}catch (IOException e) {}
//			if (os != null) {
//				try {
//					os.close();
//				} catch (IOException e) {}
//			}
//		}
//		
//		return fileName;
//	}
//	
//	
//	/**
//	 * 난수로 바뀌어 있는 파일(fileName)을 originFileName로 바꿔서 반환
//	 * @param fileName
//	 * @param originFileName
//	 */
//	public ResponseEntity<Resource> downloadFile(String fileName, String originFileName) {
//		// 다운로드 할 파일의 정보를 가지고 있는 File 인스턴스를 생성
//		// import java.io.File;
//		File downloadFile = new File(this.baseDirectory, fileName);
//
//		// HTTP Header에 파일 다운로드 정보를 설정
//		// import org.springframework.http.HttpHeaders;
//		HttpHeaders header = new HttpHeaders();
//
//		// 다운로드시킬 파일의 이름의 인코딩을 변경
//		try {
//			// 다운로드에 대해서만 인코딩해주는 코드를 작성해야 함
//			originFileName = new String(originFileName.getBytes("UTF-8"), "ISO-8859-1");
//			// UTF-8 타입의 글자를 Byte 단위로 쪼개 ISO-8859-1 로 바꿔줌
//			// ISO-8859-1 : 인코딩 방식 중 하나로 문자집합을 숫자로 나타내고 전송할 수 있는 방법이 정의 됨
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//
//		// HTTP Response에 파일을 첨부해서 보낼건데 파일의 이름은 "~~~~"이다. (위에 인코딩 한 파일 이름으로 다운로드)
//		header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=" + originFileName);
//
//		// 4. 브라우저에게 파일을 전송
//		InputStreamResource resource = null;
//		try {
//			resource = new InputStreamResource(new FileInputStream(downloadFile));
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//			throw new IllegalArgumentException("파일이 존재하지 않습니다.");
//		}
//
//		// 브라우저에게 보낼 응답 데이터를 생성
//		return ResponseEntity.ok()
//				// 응답 데이터에 HTTP Header 정보를 Setting (파일 다운로드 정보)
//				.headers(header)
//				// 다운로드 시킬 파일의 크기를 전달 -> 브라우저가 파일 다운로드 진행상태를 관리하기 위해
//				.contentLength(downloadFile.length())
//				// 다운로드 시킬 파일의 타입을 지정
//				// 보통 png 파일이라면 image.png라고 지정하는데
//				// 타입과 관계없이 강제 다운로드를 시키려면 "application/octet-stream"을 이용
//				.contentType(MediaType.parseMediaType("application/octet-stream"))
//				// 파일을 응답 데이터에 전달
//				.body(resource);
//	}
//	
//	/**
//	 * 파라미터로 받아온 파일을 지워라
//	 * @param fileName 지워야 할 파일
//	 */
//	public void deleteFile(String fileName) {
//		
//		if(fileName == null) {
//			return;
//		}
//		
//		File file = new File(this.baseDirectory, fileName);
//		
//		if(file.exists() && file.isFile()) {
//			file.delete();
//		}
//		
//	}
//	
//}
