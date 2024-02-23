package com.Tree_dev.workout_done.post.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostBoardDto {
    private String title;
    private String content;


    public Post toEntity() {
        return new Post(title, content);
    }
}
