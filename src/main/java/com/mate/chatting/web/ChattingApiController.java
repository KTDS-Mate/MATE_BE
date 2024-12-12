package com.mate.chatting.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mate.chatting.service.ChattingService;
import com.mate.chatting.vo.ChattingRoomVO;
import com.mate.chatting.vo.MessageVO;
import com.mate.common.beans.security.jwt.JsonWebTokenProvider;
import com.mate.common.vo.ApiResponse;
import com.mate.user.vo.UserVO;

@RestController
@RequestMapping("/api/v1/chatting")
public class ChattingApiController {

    private static final Logger logger = LoggerFactory.getLogger(ChattingApiController.class);

    @Autowired
    private ChattingService chattingService;

    @Autowired
    private JsonWebTokenProvider jsonWebTokenProvider;

    /**
     * 채팅방 목록 조회
     */
    @GetMapping("/roomList")
    public ApiResponse getChattingRooms(Authentication authentication) {
        UserVO userVO = extractUserVO(authentication);
        List<ChattingRoomVO> roomList = chattingService.selectRoomList(userVO.getUsrId());
        return new ApiResponse(roomList);
    }

    /**
     * 채팅 상대 검색
     */
    @GetMapping("/selectTarget")
    public ApiResponse searchChatTarget(@RequestParam String query, Authentication authentication) {
        UserVO userVO = extractUserVO(authentication);

        Map<String, Object> param = new HashMap<>();
        param.put("userId", userVO.getUsrId());
        param.put("query", query);

        List<UserVO> targetList = chattingService.selectTarget(param);
        return new ApiResponse(targetList);
    }

    /**
     * 채팅방 입장 (없으면 생성)
     */
    @GetMapping("/enter")
    public ApiResponse enterChatRoom(@RequestParam String targetId, Authentication authentication) {
        UserVO userVO = extractUserVO(authentication);

        Map<String, String> param = new HashMap<>();
        param.put("targetId", targetId);
        param.put("loginUserVO", userVO.getUsrId());

        String chattingId = chattingService.checkChattingId(param);
        if (chattingId == null) {
            chattingId = chattingService.createChattingRoom(param);
        }

        return new ApiResponse(chattingId);
    }

    /**
     * 채팅 메시지 전송
     */
    @PostMapping("/sendMessage")
    public ApiResponse sendMessage(@RequestBody MessageVO messageVO, Authentication authentication) {
        UserVO userVO = extractUserVO(authentication);

        // 메시지 기본 정보 설정
        messageVO.setSenderId(userVO.getUsrId());
        messageVO.setSendTime(null); // 자동으로 SYSDATE 설정됨.

        int result = chattingService.insertMessage(messageVO);

        if (result > 0) {
            return new ApiResponse("메시지가 성공적으로 전송되었습니다.");
        } else {
            return new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, List.of("메시지 전송에 실패했습니다."));
        }
    }

    /**
     * 채팅 읽음 표시 (Post로 변경)
     */
    @PostMapping("/updateReadFlag")
    public ApiResponse updateReadFlag(@RequestBody Map<String, Object> paramMap, Authentication authentication) {
        UserVO userVO = extractUserVO(authentication);
        paramMap.put("memberNo", userVO.getUsrId());

        int result = chattingService.updateReadFlag(paramMap);
        return new ApiResponse(result);
    }

    /**
     * 채팅방 메시지 목록 조회
     */
    @GetMapping("/selectMessage")
    public ApiResponse getChatMessages(@RequestParam String chattingId, Authentication authentication) {
        UserVO userVO = extractUserVO(authentication);

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("chattingId", chattingId);
        paramMap.put("memberNo", userVO.getUsrId());

        List<MessageVO> messageList = chattingService.selectMessageList(paramMap);
        return new ApiResponse(messageList);
    }

    /**
     * Authentication에서 UserVO 추출
     */
    private UserVO extractUserVO(Authentication authentication) {
        if (authentication == null || authentication.getPrincipal() == null) {
            throw new IllegalStateException("인증 정보가 없습니다.");
        }
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserVO user) {
            return user;
        }
        throw new IllegalStateException("인증된 사용자 정보가 잘못되었습니다.");
    }
}
