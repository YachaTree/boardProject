package com.Tree_dev.workout_done.board.controller;

import com.Tree_dev.workout_done.board.entity.Board;
import com.Tree_dev.workout_done.board.entity.BoardPostDto;
import com.Tree_dev.workout_done.board.mapper.BoardMapper;
import com.Tree_dev.workout_done.board.service.BoardService;
import com.Tree_dev.workout_done.post.entity.Post;
import com.Tree_dev.workout_done.post.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;
    private final PostService postService;
    private final BoardMapper boardMapper;

    public BoardController(BoardService boardService, PostService postService, BoardMapper boardMapper) {
        this.boardService = boardService;
        this.postService = postService;
        this.boardMapper = boardMapper;
    }

    @GetMapping
    public String getBoards(@RequestParam(required = false) String keyword, Model model) {
        List<Board> boards;
        if (keyword != null && !keyword.isEmpty()) {   //게시판 키워드 검색 기능 추가
            boards = boardService.findBoardsByKeyword(keyword);
        } else {
            boards = boardService.findBoards();
        }
        model.addAttribute("boards", boards);
        model.addAttribute("keyword", keyword);
        return "board/boards";
    }

    @GetMapping("/{boardId}")
    public String getBoard(@PathVariable Long boardId,
                           @RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "10") int size,
                           @RequestParam(required = false) String keyword,
                           Model model) {
        Board board = boardService.findBoardById(boardId);//게시물 키워드 검색
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Post> postPage = postService.findPostsByBoardAndKeyword(board, keyword, pageRequest);

        model.addAttribute("board", board);
        model.addAttribute("keyword", keyword);
        model.addAttribute("postPage", postPage);
        return "board/board";
    }

    @GetMapping("/create")
    public String createBoard(Model model) {
        return "board/createBoard";
    }

    @PostMapping("/create")
    public String createBoardPost(@ModelAttribute BoardPostDto boardPostDto) {
        Board board = boardMapper.boardPostDtoToBoard(boardPostDto);
        boardService.createBoard(board);

        return "redirect:/boards";
    }

    @GetMapping("/{boardId}/edit")
    public String editBoard(@PathVariable Long boardId, Model model) {
        Board board = boardService.findBoardById(boardId);
        model.addAttribute("board", board);

        return "board/editBoard";
    }

    @PostMapping("/{boardId}/edit")
    public String editBoardPost(@PathVariable Long boardId, @ModelAttribute BoardPostDto boardPostDto) {
        Board board = boardMapper.boardPostDtoToBoard(boardPostDto).toBuilder().id(boardId).build();
        boardService.updateBoard(board);

        return "redirect:/boards";
    }

    @DeleteMapping("/{boardId}/delete")
    public String deleteBoard(@PathVariable Long boardId) {
        boardService.deleteBoard(boardId);

        return "redirect:/boards";
    }

}
