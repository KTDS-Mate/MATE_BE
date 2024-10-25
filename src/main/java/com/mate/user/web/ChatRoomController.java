<<<<<<< HEAD
package com.mate.user.web;

import org.springframework.stereotype.Controller;

@Controller
public class ChatRoomController {

   
    
}
=======
//package com.mate.member.web;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.mate.bbs.vo.ChatRoomListVO;
//import com.mate.bbs.vo.ChatRoomVO;
//import com.mate.bbs.vo.WriteChatRoomVO;
//
//import jakarta.validation.Valid;
//
//@Controller
//public class ChatRoomController {
//
//    @Autowired
//    private ChatRoomService chatRoomService;
//
//    @GetMapping("/chatroom/list")
//    public String viewChatRoomList(Model model){
//        ChatRoomListVO chatRoomListVO = this.chatRoomService.selectAllChatRooms();
//
//        model.addAttribute("chatRoomListVO", chatRoomListVO);
//
//        return "chatroom/chatroomlist";
//    }
//
//    @GetMapping("/chatroom/write")
//    public String viewChatRoomWritePage(){
//        return "chatroom/chatroomwrite";
//    }
//
//    @PostMapping("/chatroom/write")
//    public String doCreateNewChatRoom(@Valid WriteChatRoomVO writeChatRoomVO
//                                        , BindingResult bindingResult
//                                        , Model model){
//
//        boolean isCreate = this.chatRoomService.createNewChatRoom(writeChatRoomVO);
//
//        System.out.println("게시글 등록 결과: " + isCreate);
//
//        return "redirect:/chatroom/list";
//    }
//
//    @GetMapping("/chatroom/view/{id}")
//    public String viewChatRoomDetail(@PathVariable String id, Model model) {
//        ChatRoomVO chatRoomVO = this.chatRoomService.selectOneChatRoomById(id);
//
//        model.addAttribute("chatRoomVO", chatRoomVO);
//
//        return "chatroom/chatroomview";
//    }
//
//    @GetMapping("/chatroom/delete/{id}")
//    public String deleteChatRoom(@PathVariable String id) {
//        boolean isDeleted = this.chatRoomService.deleteOneChatRoom(id);
//        if(isDeleted){
//            return "redirect:/chatroom/list";
//        } else {
//            return "redirect:/chatroom/view/" + id;
//        }
//    }
//}
>>>>>>> main
