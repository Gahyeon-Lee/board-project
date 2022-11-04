package com.example.board.service;

import com.example.board.domain.Post;
import com.example.board.dto.PostResponseDto;
import com.example.board.dto.PostSaveRequestDto;
import com.example.board.dto.PostUpdateRequestDto;
import com.example.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl {
    private final PostRepository postRepository;

    @Transactional
    public Long savePost(PostSaveRequestDto postSaveRequestDto) {
        return postRepository.save(postSaveRequestDto.ToEntity()).getId();
    }

    @Transactional
    public List<PostSaveRequestDto> getPostList() {
        List<Post> all = postRepository.findAll();
        List<PostSaveRequestDto> postDtoList = new ArrayList<>();

        for (Post post : all) {
            PostSaveRequestDto postSaveRequestDto = PostSaveRequestDto.builder()
                    .title(post.getTitle())
                    .content(post.getContent())
                    .writer(post.getWriter())
                    .build();
            postDtoList.add(postSaveRequestDto);
        }

        return postDtoList;
    }

    @Transactional
    public PostResponseDto findById(Long id) {
        Post entity = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        return new PostResponseDto(entity);
    }

    @Transactional
    public void deletePost(Long id) {
        Post post = postRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        postRepository.delete(post);
    }

    @Transactional
    public Long update(Long id, PostUpdateRequestDto postUpdateRequestDto) {
       Post post = postRepository.findById(id)
               .orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다. id = " + id));
       post.update(postUpdateRequestDto.getTitle(), postUpdateRequestDto.getContent());

       return id;
    }
}


