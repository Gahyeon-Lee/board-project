package com.example.board.service;

import com.example.board.dto.PostSaveRequestDto;

import java.util.List;

public interface PostService {
    public void savePost(PostSaveRequestDto postSaveRequestDto);
    public List<PostSaveRequestDto> getPostList();
    public PostSaveRequestDto getPost(Long id);
    public void deletePost(Long id);
    public List<PostSaveRequestDto> searchPosts(String keyword);
    public void update(Long id, PostSaveRequestDto postSaveRequestDto);
}
