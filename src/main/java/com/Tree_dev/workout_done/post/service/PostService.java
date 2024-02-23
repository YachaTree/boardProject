package com.Tree_dev.workout_done.post.service;

import com.Tree_dev.workout_done.post.entity.Post;
import com.Tree_dev.workout_done.post.exception.ExceptionCode;
import com.Tree_dev.workout_done.post.exception.ServiceLogicException;
import com.Tree_dev.workout_done.post.repository.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional
    public Post updatePost(Post post) {

        Post findPost = postRepository.findById(post.getPostId())
                .orElseThrow(() -> new ServiceLogicException(ExceptionCode.POST_NOT_FOUND));

        Optional.ofNullable(post.getTitle())
                .ifPresent(title -> findPost.setTitle(title));
        Optional.ofNullable(post.getContent())
                .ifPresent(content -> findPost.setContent(content));

        // if (true) {
        //     throw new RuntimeException("롤백 발생!");
        // }

        return postRepository.save(findPost);
    }

    public List<Post> findPosts() {
        return postRepository.findAll();
    }

    public Page<Post> findPosts(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    public Page<Post> findAllPostsOrderedByTitleAsc(Pageable pageable) {
        return postRepository.findAllByOrderByTitleAsc(pageable);
    }

    public Page<Post> findAllPostsOrderedByTitleDesc(Pageable pageable) {
        return postRepository.findAllByOrderByTitleDesc(pageable);
    }
    public Post findPost(long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new ServiceLogicException(ExceptionCode.POST_NOT_FOUND));
    }

    public Post createPost(Post post) {
        Post savedPost = postRepository.save(post);

        return savedPost;
    }

    public void deletePost(long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ServiceLogicException(ExceptionCode.POST_NOT_FOUND)
        );

        postRepository.delete(post);
    }


}
