package com.project.introduceourtown.dto.kakaomapDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class KakaoMapRequestDto {
    List<String> keywordList;

    int radius;
}
