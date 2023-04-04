package com.min.blog.dto.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class BoardDto {
private String title;
private String content;
private String category;

}
