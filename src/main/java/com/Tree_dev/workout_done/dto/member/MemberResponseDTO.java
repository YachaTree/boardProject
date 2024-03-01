package com.Tree_dev.workout_done.dto.member;

import com.Tree_dev.workout_done.domain.Member;
import com.Tree_dev.workout_done.domain.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberResponseDTO {

    private String email;
    private String username;
    private Role role;

    @Builder
    public MemberResponseDTO(Member member) {
        this.email = member.getEmail();
        this.username = member.getUsername();
        this.role = member.getRole();
    }
}
