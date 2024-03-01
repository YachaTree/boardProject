package com.Tree_dev.workout_done.service.member;



import com.Tree_dev.workout_done.dto.member.MemberPasswordUpdateDTO;
import com.Tree_dev.workout_done.dto.member.MemberResponseDTO;
import com.Tree_dev.workout_done.dto.member.MemberUsernameUpdateDTO;

import java.util.List;

public interface MemberService {

    /**
     * 회원 목록 조회
     * @return 회원 정보 목록
     */
    List<MemberResponseDTO> findMembers();

    /**
     * 회원 정보 조회
     * @return 회원 정보
     */
    MemberResponseDTO findMember(String email);

    /**
     * 회원 이름 변경
     * @param memberUsernameUpdateDTO
     * @return 회원 ID
     */
    Long updateMemberUsername(MemberUsernameUpdateDTO memberUsernameUpdateDTO);

    /**
     * 회원 비밀번호 변경
     * @param memberPasswordUpdateDTO
     * @return 회원 ID
     */
    Long updateMemberPassword(MemberPasswordUpdateDTO memberPasswordUpdateDTO, String email);

    /**
     * 회원 탈퇴
     * @param email
     * @param password
     * @return boolean
     */
    boolean withdrawal(String email, String password);
}
