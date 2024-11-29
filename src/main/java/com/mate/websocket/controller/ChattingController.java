package com.mate.websocket.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.mate.user.vo.UserVO;
import com.mate.websocket.service.ChattingService;
import com.mate.websocket.vo.ChattingRoomVO;
import com.mate.websocket.vo.MessageVO;

@Controller
public class ChattingController {

    @Autowired
    private ChattingService service;

    // 채팅 메인 화면 이동
    @GetMapping("/chatting")
    public String chatting(@SessionAttribute(name = "_LOGIN_USER_", required=false) UserVO userVO, Model model) {
        List<ChattingRoomVO> roomList = service.selectRoomList(userVO.getUsrId());
        model.addAttribute("roomList", roomList);
        return "chatting/Chatting";
    }

    // 채팅 상대 검색
    @PostMapping(value = "/chatting/selectTarget", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<UserVO> selectTarget(@RequestBody Map<String, Object> paramMap, @SessionAttribute(name = "_LOGIN_USER_", required=false) UserVO userVO) {
        paramMap.put("usrId", userVO.getUsrId());
        return service.selectTarget(paramMap);
    }

    // 채팅방 입장 (기존 방 체크 또는 새로 생성)
    @PostMapping("/chatting/enter")
    @ResponseBody
    public int chattingEnter(@RequestBody Map<String, Object> paramMap, @SessionAttribute(name = "_LOGIN_USER_", required=false) UserVO userVO) {
        paramMap.put("loginUsrId", userVO.getUsrId());
        int chattingId = service.checkChattingId(paramMap);
        return chattingId == 0 ? service.createChattingRoom(paramMap) : chattingId;
    }

    // 채팅방 목록 조회
    @GetMapping(value = "/chatting/roomList", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<ChattingRoomVO> selectRoomList(@SessionAttribute(name = "_LOGIN_USER_", required=false) UserVO userVO) {
        return service.selectRoomList(userVO.getUsrId());
    }

    // 메시지 읽음 상태 업데이트
    @PostMapping("/chatting/updateReadFlag")
    @ResponseBody
    public int updateReadFlag(@RequestBody Map<String, Object> paramMap) {
        return service.updateReadFlag(paramMap);
    }

    // 메시지 목록 조회
    @PostMapping(value = "/chatting/selectMessageVO", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<MessageVO> selectMessageList(@RequestBody Map<String, Object> paramMap) {
        return service.selectMessageList(paramMap);
    }
}
