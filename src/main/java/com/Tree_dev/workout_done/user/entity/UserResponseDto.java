package com.Tree_dev.workout_done.user.entity;

import com.Tree_dev.workout_done.audit.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class UserResponseDto extends BaseEntity {
    private long userId;
    private String name;
    private String email;
}
