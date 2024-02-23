package com.Tree_dev.workout_done.post.controller;

import com.Tree_dev.workout_done.post.entity.Post;
import com.Tree_dev.workout_done.post.entity.PostBoardDto;
import com.Tree_dev.workout_done.post.entity.PostPatchDto;
import com.Tree_dev.workout_done.post.service.PostService;
import com.Tree_dev.workout_done.post.mapper.PostMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/posts")
public class PostViewController {
    private final PostService postService;
    private final PostMapper mapper;

    public PostViewController(PostService postService, PostMapper mapper) {
        this.postService = postService;
        this.mapper = mapper;
    }

    @GetMapping
    public String getPosts(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "9") int size) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<Post> postPage = postService.findPosts(pageable);
        model.addAttribute("postPage", postPage);
        return "posts";
    }

    @GetMapping("/sorted/asc")
    public String getPostsOrderedByTitleAsc(Model model,
                                               @RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "9") int size) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<Post> postPage = postService.findAllPostsOrderedByTitleAsc(pageable);
        model.addAttribute("postPage", postPage);
        return "posts";
    }

    @GetMapping("/sorted/desc")
    public String getPostsOrderedByTitleDesc(Model model,
                                                @RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "9") int size) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<Post> postPage = postService.findAllPostsOrderedByTitleDesc(pageable);
        model.addAttribute("postPage", postPage);
        return "posts";
    }

    @GetMapping("/add")
    public String addForm() {
        return "addPostForm";
    }

    @GetMapping("/{postId}")
    public String getPostDetail(@PathVariable long postId, Model model) {
        Post post = postService.findPost(postId);
        model.addAttribute("post", post);
        return "post";
    }

    @PostMapping("/add")
    public String addPost(@ModelAttribute PostBoardDto postBoardDto, RedirectAttributes redirectAttributes) {
        Post post = postBoardDto.toEntity();

        Post createdPost = postService.createPost(post);
        redirectAttributes.addAttribute("postId", createdPost.getPostId());
        return "redirect:/posts";
    }


    @GetMapping("/{postId}/edit")
    public String editForm(@PathVariable long postId, Model model) {
        Post post = postService.findPost(postId);
        model.addAttribute("post", post);
        return "editPostForm";
    }

    @PostMapping("/{postId}/edit")
    public String updatePost(@ModelAttribute PostPatchDto postPatchDto,
                                RedirectAttributes redirectAttributes) {
        Post post = mapper.postPatchDtoToPost(postPatchDto);
        Post updatedPost = postService.updatePost(post);

        redirectAttributes.addAttribute("postId", updatedPost.getPostId());
        redirectAttributes.addFlashAttribute("message", "게시글이 수정되었습니다.");
        return "redirect:/posts/{postId}";
    }


    @DeleteMapping("/{postId}")
    public String deletePost(@PathVariable long postId, RedirectAttributes redirectAttributes) {
        postService.deletePost(postId);
        redirectAttributes.addFlashAttribute("message", "게시글이 제거되었습니다.");
        return "redirect:/posts";
    }
}
