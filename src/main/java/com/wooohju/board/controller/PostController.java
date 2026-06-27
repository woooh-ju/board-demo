package com.wooohju.board.controller;

import com.wooohju.board.domain.Post;
import com.wooohju.board.dto.post.PostListResponseDTO;
import com.wooohju.board.dto.post.PostRegisterDTO;
import com.wooohju.board.dto.post.PostResponseDTO;
import com.wooohju.board.global.PostNotFoundException;
import com.wooohju.board.dto.SuccessResponseDTO;
import com.wooohju.board.repository.PostRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/posts")
public class PostController {

    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    /*@GetMapping
    private PostResponseDTO getPost()
    {
        var dummyPost = new Post("title", "content");
        return PostResponseDTO.from(dummyPost);
    }*/

    @GetMapping
    private PostListResponseDTO getPostList()
    {
        return PostListResponseDTO.from(postRepository.findAll().stream().map(PostResponseDTO::from).toList());
    }

    @GetMapping("/{postId}")
    private PostResponseDTO getPost(@PathVariable Long postId)
    {
        return postRepository.findById(postId).map(PostResponseDTO::from).orElseThrow(PostNotFoundException::new);
    }

    @PostMapping
    private SuccessResponseDTO registerPost(@Valid @RequestBody PostRegisterDTO req)
    {
        postRepository.save(new Post(req.getTitle(), req.getContent()));
        return SuccessResponseDTO.created();
    }

}
