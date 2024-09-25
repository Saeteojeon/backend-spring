package com.project.introduceourtown.dto.keywordDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class KeywordListResponseDto {
    List<String> keyword;
}
