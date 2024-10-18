package com.mate.chat2.web;

import com.mate.chat2.service.Chat2Service;
import com.mate.chat2.vo.Chat2Room;
import com.mate.user.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/chat")
@SessionAttribute({"_LOGIN_USER_"})
public class Chat2Controller {

    @Autowired
    private Chat2Service chat2Service;

    // 채팅방 목록
    @GetMapping("/mate/chat/chatRoomList")
    public String selectChatRoomList(Model model){

        List<Chat2Room> chat2RoomList = chat2Service.selectChat2RoomList();

        model.addAttribute("chat2RoomList",chat2RoomList);

        return "all/Chat2Room";
    }

    // 채팅방 생성
    @PostMapping("/openChatRoom")
    public String openChatRoom(Chat2Room chat2Room,
                               RedirectAttributes redirectAttributes,
                               @ModelAttribute("_LOGIN_USER_") UserVO loginUser){
        chat2Room.setUserNo(loginUser.getUsrId());
    }
}
