package com.Tree_dev.workout_done.post.controller;

import com.Tree_dev.workout_done.board.service.BoardService;
import com.Tree_dev.workout_done.comment.entity.Comment;
import com.Tree_dev.workout_done.comment.service.CommentService;
import com.Tree_dev.workout_done.post.entity.Post;
import com.Tree_dev.workout_done.post.entity.PostPostDto;
import com.Tree_dev.workout_done.post.service.PostService;
import com.Tree_dev.workout_done.post.mapper.PostMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;
    private final BoardService boardService;
    private final PostMapper postMapper;
    private final CommentService commentService;

    @GetMapping("/{postId}")
    public String getPostDetail(@PathVariable Long postId, Model model) {
        Post post = postService.findPost(postId);
        model.addAttribute("post", post);
        List<Comment> comments = commentService.findCommentsByPostId(postId);
        model.addAttribute("comments", comments);
        return "post/post";
    }

    @GetMapping("/create")
    public String createPost(@RequestParam Long boardId, Model model) {
        model.addAttribute("boardId", boardId);
        return "post/createPost";
    }

    @PostMapping("/create")
    public String createPostPost(@ModelAttribute PostPostDto postPostDto, @RequestParam Long boardId) {
        Post post = postMapper.postPostDTOToPost(postPostDto);
        Post createdPost = postService.createPost(post, boardId);
        return "redirect:/boards/" + createdPost.getBoard().getId();
    }

    @GetMapping("/{postId}/edit")
    public String editPost(@PathVariable Long postId, Model model) {
        Post post = postService.findPost(postId);
        model.addAttribute("post", post);
        return "post/editPost";
    }

    @PostMapping("/{postId}/edit")
    public String editPost(@PathVariable Long postId, @ModelAttribute PostPostDto postPostDto, RedirectAttributes redirectAttributes) {
        Post post = postMapper.postPostDTOToPost(postPostDto);
        Post updatedPost = postService.updatePost(post, postId);

        redirectAttributes.addAttribute("postId", updatedPost.getId());
        redirectAttributes.addFlashAttribute("message", "게시글이 수정되었습니다.");
        return "redirect:/posts/{postId}";
    }

    @DeleteMapping("/{postId}")
    public String deletePost(@PathVariable Long postId, RedirectAttributes redirectAttributes) {
        postService.deletePost(postId);
        redirectAttributes.addFlashAttribute("message", "과목이 제거되었습니다.");
        return "redirect:/posts";
    }
}
