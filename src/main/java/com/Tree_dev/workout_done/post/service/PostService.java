package com.Tree_dev.workout_done.post.service;

import com.Tree_dev.workout_done.board.entity.Board;
import com.Tree_dev.workout_done.board.service.BoardService;
import com.Tree_dev.workout_done.comment.entity.Comment;
import com.Tree_dev.workout_done.comment.repository.CommentRepository;
import com.Tree_dev.workout_done.post.entity.Post;
import com.Tree_dev.workout_done.common.exception.ExceptionCode;
import com.Tree_dev.workout_done.common.exception.ServiceLogicException;
import com.Tree_dev.workout_done.post.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@Transactional
public class PostService {

    private final PostRepository postRepository;
    private final BoardService boardService;

    private final CommentRepository commentRepository;

    public PostService(PostRepository postRepository, BoardService boardService, CommentRepository commentRepository) {
        this.boardService = boardService;
        this.postRepository = postRepository;
        this. commentRepository = commentRepository;
    }

    public Page<Post> findPostsByBoardAndKeyword(Board board, String keyword, PageRequest pageRequest) {
        if (keyword != null && !keyword.isEmpty()) {
            return postRepository.findAllByBoardAndTitleContaining(board, keyword, pageRequest);
        } else {
            return postRepository.findAllByBoardOrderByCreatedAtDesc(board, pageRequest);
        }
    }

    public Post findPost(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new ServiceLogicException(ExceptionCode.POST_NOT_FOUND));
    }

    public Post createPost(Post post, Long boardId) {
        Board boardToCreate = boardService.findBoardById(boardId);
        post.setBoard(boardToCreate);
        Post savedPost = postRepository.save(post);

        return savedPost;
    }

    public Post updatePost(Post post, Long postId) {
        post.setId(postId);
        Post foundPost = postRepository.findById(post.getId())
                .orElseThrow(() -> new ServiceLogicException(ExceptionCode.POST_NOT_FOUND));

        Optional.ofNullable(post.getTitle())
                .ifPresent(title -> foundPost.setTitle(title));
        Optional.ofNullable(post.getContent())
                .ifPresent(content -> foundPost.setContent(content));

        return postRepository.save(foundPost);
    }

    public void deletePost(Long id) {
        Post foundPost = postRepository.findById(id)
                .orElseThrow(() -> new ServiceLogicException(ExceptionCode.POST_NOT_FOUND));

        postRepository.delete(foundPost);
    }
}
