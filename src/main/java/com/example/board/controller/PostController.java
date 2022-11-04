package com.example.board.controller;

import com.example.board.domain.Post;
import com.example.board.dto.PostSaveRequestDto;
import com.example.board.dto.PostResponseDto;
import com.example.board.dto.PostUpdateRequestDto;
import com.example.board.repository.PostRepository;
import com.example.board.service.PostServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostServiceImpl postService;
    private final PostRepository postRepository;

    @PostMapping("/api/post/save")
    public Long savePost(@RequestBody PostSaveRequestDto postSaveRequestDto) {
        return postService.savePost(postSaveRequestDto);
    }

    @PutMapping("api/post/update/{id}")
    public Long updatePost(@PathVariable("id") Long id, @RequestBody PostUpdateRequestDto requestDto) {
        return postService.update(id, requestDto);
    }

    @GetMapping("api/post/posts")
    public List<PostSaveRequestDto> findPosts() {
        List<Post> findAll = postRepository.findAll();
        List<PostSaveRequestDto> allPost = new ArrayList<>();

        for (Post post : findAll) {
            PostSaveRequestDto postSaveRequestDto = PostSaveRequestDto.builder()
                    .writer(post.getWriter())
                    .title(post.getTitle())
                    .content(post.getContent())
                    .build();
            allPost.add(postSaveRequestDto);
        }

        return allPost;
    }

    @GetMapping("api/post/{id}")
    public PostResponseDto findById(@PathVariable Long id) {
        return postService.findById(id);
    }

    @DeleteMapping("api/post/{id}")
    public void delete(@PathVariable("id") Long id) {
        postService.deletePost(id);
    }
}
