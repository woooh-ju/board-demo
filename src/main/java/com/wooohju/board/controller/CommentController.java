package com.wooohju.board.controller;

import com.wooohju.board.domain.Comment;
import com.wooohju.board.dto.comment.CommentListResponseDTO;
import com.wooohju.board.dto.comment.CommentRegisterDTO;
import com.wooohju.board.dto.SuccessResponseDTO;
import com.wooohju.board.dto.comment.CommentResponseDTO;
import com.wooohju.board.global.PostNotFoundException;
import com.wooohju.board.repository.CommentRepository;
import com.wooohju.board.repository.PostRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/posts/{post_id}/comment")
public class CommentController {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentController(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @GetMapping
    private CommentListResponseDTO getComment(@PathVariable Long post_id)
    {
        if (!postRepository.existsById(post_id)) {
            throw new PostNotFoundException();
        }
        var post = postRepository.findById(post_id).orElseThrow(PostNotFoundException::new);
        return CommentListResponseDTO.from(commentRepository.findByPostId(post.getId()).stream().map(CommentResponseDTO::from).toList());
    }

    @PostMapping
    private SuccessResponseDTO registerComment(@PathVariable Long post_id, @Valid @RequestBody CommentRegisterDTO req)
    {
        var post = postRepository.findById(post_id).orElseThrow(PostNotFoundException::new);
        commentRepository.save(new Comment(req.getContent(), post));
        return SuccessResponseDTO.created();
    }
}
