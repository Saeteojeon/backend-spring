package com.project.introduceourtown.dto.kakaomapDto;

import lombok.Getter;

import java.util.List;

@Getter
public class KakaoMapResultDto {
    private KakaoMapMetaDto meta;
    private List<KakaoMapResponseDto> documents;
}
