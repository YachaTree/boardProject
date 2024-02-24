package com.Tree_dev.workout_done.post.repository;

import com.Tree_dev.workout_done.board.entity.Board;
import com.Tree_dev.workout_done.post.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {



    Page<Post> findAllByOrderByTitleAsc(Pageable pageable);

    Page<Post> findAllByOrderByTitleDesc(Pageable pageable);

    Page<Post> findAllByBoardOrderByCreatedAtDesc(Board board, Pageable pageable);

    Page<Post> findAllByBoardAndTitleContaining(Board board, String keyword, Pageable pageable);
}
