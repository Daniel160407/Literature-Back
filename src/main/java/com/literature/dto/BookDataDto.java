package com.literature.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BookDataDto {
    private Integer bookId;
    private String text;
}
