package com.Tree_dev.workout_done.repository;

import com.Tree_dev.workout_done.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

    Page<Board> findByTitle(String keyword, Pageable pageable);
}
