package com.project.introduceourtown.dto.kakaomapDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class KakaoMapResponseDto {
    private String id;                // 장소 ID
    private String place_name;         // 장소명
    private String address_name;       // 지번 주소
    private String road_address_name;   // 도로명 주소
    private String x;                 // 경도
    private String y;                 // 위도
    private String place_url;          // 장소 상세페이지 URL
    private String phone;             // 전화번호
    private String category_group_name; // 카테고리 그룹명
}
