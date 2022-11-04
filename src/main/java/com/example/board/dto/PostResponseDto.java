package com.example.board.dto;

import com.example.board.domain.Post;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostResponseDto {
    private Long id;
    private String writer;
    private String title;
    private String content;

    @Builder
    public PostResponseDto(Post entity) {
        this.id = entity.getId();
        this.writer = entity.getWriter();
        this.title = entity.getTitle();
        this.content = entity.getContent();
    }
}
