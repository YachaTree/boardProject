package com.Tree_dev.workout_done.post.entity;

import com.Tree_dev.workout_done.board.entity.Board;
import com.Tree_dev.workout_done.comment.entity.Comment;
import com.Tree_dev.workout_done.common.entity.BaseEntity;
import com.Tree_dev.workout_done.registration.RegistrationPost;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    @Column(nullable = false, length = 30)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true) // 게시글 삭제시 연결된 자식 엔티티인 댓글 함께 삭제하기 위한 셋팅 설정
    private List<Comment> comments;

    public Post(Board board, String title, String content) {
        this.board = board;
        this.title = title;
        this.content = content;
    }

    public void setBoard(Board board) {
        this.board = board;
        if (!this.board.getPosts().contains(this)) {
            this.board.getPosts().add(this);
        }
    }
}