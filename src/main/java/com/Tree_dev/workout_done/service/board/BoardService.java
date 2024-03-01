package com.Tree_dev.workout_done.service.board;

import com.Tree_dev.workout_done.dto.board.BoardResponseDTO;
import com.Tree_dev.workout_done.dto.board.BoardWriteRequestDTO;
import com.Tree_dev.workout_done.dto.image.BoardImageUploadDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface BoardService {

    /**
     * 게시글 작성
     * @param boardWriteRequestDTO 게시글 정보
     * @param email 작성자
     * @return 게시글 ID
     */
    Long saveBoard(BoardWriteRequestDTO boardWriteRequestDTO,
                   BoardImageUploadDTO boardImageUploadDTO,
                   String email);

    /**
     * 게시글 상세조회
     * @param id 게시글 ID
     * @return 게시글 정보
     */
    BoardResponseDTO boardDetail(Long id);

    /**
     * 게시글 전체조회
     * @param pageable 페이징 처리
     * @return 게시글 목록 (페이징)
     */
    Page<BoardResponseDTO> boardList(Pageable pageable);

    /**
     * 게시글 검색
     * @param keyword 검색어
     * @param pageable 페이징 처리
     * @return 검색 된 게시글 목록 (페이징)
     */
    Page<BoardResponseDTO> searchingBoardList(String keyword, Pageable pageable);

    /**
     * 게시글 수정
     * @param id 게시글 ID
     * @param boardWriteRequestDTO 수정 정보
     * @return 게시글 ID
     */
    Long boardUpdate(Long id, BoardWriteRequestDTO boardWriteRequestDTO);

    /**
     * 게시글 삭제
     * @param id 게시글 ID
     */
    void boardRemove(Long id);
}
