package com.mate.bbs.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mate.bbs.service.GuideTourService;
import com.mate.bbs.vo.GuideTourVO;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class GuideTourApiController {
	
    @Autowired
    private GuideTourService guideTourService;

    @GetMapping("/guidetour/random")
    public ResponseEntity<?> getRandomGuideTours() {
        try {
            List<GuideTourVO> randomTours = guideTourService.getRandomGuideTours();
            return ResponseEntity.ok(randomTours); // JSON 형식으로 반환
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\": \"Server Error\", \"message\": \"" + e.getMessage() + "\"}");
        }
    }
}
