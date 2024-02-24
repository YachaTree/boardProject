package com.Tree_dev.workout_done.board.service;

import com.Tree_dev.workout_done.board.entity.Board;
import com.Tree_dev.workout_done.board.repository.BoardRepository;
import com.Tree_dev.workout_done.common.exception.ExceptionCode;
import com.Tree_dev.workout_done.common.exception.ServiceLogicException;
import com.Tree_dev.workout_done.post.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private Board foundBoard;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<Board> findBoards() {
        return boardRepository.findAll();
    }

    public Board findBoardById(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> new ServiceLogicException(ExceptionCode.BOARD_NOT_FOUND));
    }

    public Board createBoard(Board board) {
        return boardRepository.create(board);
    }

    public Board updateBoard(Board board) {
        foundBoard = boardRepository.findById(board.getId())
                .orElseThrow(() -> new ServiceLogicException(ExceptionCode.BOARD_NOT_FOUND));

        Optional.ofNullable(board.getName())
                .ifPresent(name -> { foundBoard = foundBoard.toBuilder().name(name).build(); });

        foundBoard = foundBoard.toBuilder().description(board.getDescription()).build();

        return boardRepository.update(foundBoard);
    }

    public void deleteBoard(Long id) {
        foundBoard = boardRepository.findById(id)
                .orElseThrow(() -> new ServiceLogicException(ExceptionCode.BOARD_NOT_FOUND));

        boardRepository.delete(foundBoard);
    }

    public List<Board> findBoardsByKeyword(String keyword) {
        return boardRepository.findByNameContaining(keyword);
    }


}
