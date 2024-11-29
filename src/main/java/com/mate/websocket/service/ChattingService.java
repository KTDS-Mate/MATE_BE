package com.mate.websocket.service;

import java.util.List;
import java.util.Map;

import com.mate.user.vo.UserVO;
import com.mate.websocket.vo.ChattingRoomVO;
import com.mate.websocket.vo.MessageVO;

public interface ChattingService {

    /**
     * 유저의 채팅방 목록을 조회합니다.
     * @param usrId 사용자 ID
     * @return 채팅방 목록
     */
    List<ChattingRoomVO> selectRoomList(String usrId);

    /**
     * 채팅방 존재 여부를 확인합니다.
     * @param map 채팅 상대 ID와 로그인한 유저 ID
     * @return 채팅방 ID (없으면 0 반환)
     */
    int checkChattingId(Map<String, Object> map);

    /**
     * 새로운 채팅방을 생성합니다.
     * @param map 채팅 대상 정보
     * @return 생성된 채팅방 ID
     */
    int createChattingRoom(Map<String, Object> map);

    /**
     * 채팅 메시지를 저장합니다.
     * @param msg 메시지 VO 객체
     * @return 저장 결과 (성공 시 1)
     */
    int insertMessage(MessageVO msg);

    /**
     * 특정 채팅방의 메시지 읽음 상태를 업데이트합니다.
     * @param paramMap 채팅방 ID와 사용자 ID
     * @return 업데이트된 행 수
     */
    int updateReadFlag(Map<String, Object> paramMap);

    /**
     * 특정 채팅방의 메시지 목록을 조회합니다.
     * @param paramMap 채팅방 ID와 사용자 ID
     * @return 메시지 목록
     */
    List<MessageVO> selectMessageList(Map<String, Object> paramMap);

    /**
     * 채팅 상대를 검색합니다.
     * @param map 검색 조건 (로그인한 유저 ID와 검색어)
     * @return 검색된 유저 목록
     */
    List<UserVO> selectTarget(Map<String, Object> map);
}
