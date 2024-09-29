package com.project.introduceourtown.dto.flaskDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FlaskResponseListDto {
    private List<FlaskResponseDto> answer;

    private List<String> keywordList;
}
