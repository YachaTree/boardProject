package com.Tree_dev.workout_done.comment.entity;

import com.Tree_dev.workout_done.common.entity.BaseEntity;
import com.Tree_dev.workout_done.post.entity.Post;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    public Comment(Post post, String content) {
        this.post = post;
        this.content = content;
    }
}