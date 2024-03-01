package com.Tree_dev.workout_done.repository;

import com.Tree_dev.workout_done.domain.Board;
import com.Tree_dev.workout_done.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    /**
     * Board로 Comment 조회
     * @param board 게시물 정보
     * @return 댓글 리스트
     */
    List<Comment> findByBoard(Board board);
}
