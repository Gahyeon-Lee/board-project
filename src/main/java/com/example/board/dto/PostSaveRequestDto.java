package com.example.board.dto;

import com.example.board.domain.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@Getter
public class PostSaveRequestDto {
    private Long id;
    private String writer;
    private String title;
    private String content;

    @Builder
    public PostSaveRequestDto(String writer, String title, String content) {
        this.writer = writer;
        this.title = title;
        this.content = content;
    }

    public Post ToEntity() {
        return Post.builder()
                .writer(writer)
                .title(title)
                .content(content)
                .build();
    }
}
