package com.Tree_dev.workout_done.user.entity;

import com.Tree_dev.workout_done.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class UserBoardDto extends BaseEntity {
    private String name;
    private String email;
}
