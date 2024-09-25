package com.project.introduceourtown.service;

import com.project.introduceourtown.dto.kakaomapDto.KakaoMapRequestDto;
import com.project.introduceourtown.dto.kakaomapDto.KakaoMapResponseDto;
import com.project.introduceourtown.dto.kakaomapDto.KakaoMapResultDto;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class KakaoMapService {

    @Value("${kakao.restapikey}")
    private String restApiKey;

    private HttpEntity<String> httpEntity;

    @PostConstruct
    protected void init() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(HttpHeaders.AUTHORIZATION, "KakaoAK " + restApiKey);
        httpEntity = new HttpEntity<>(headers);
    }

    // Kakao API 호출하여 키워드에 맞는 장소를 검색
    public List<KakaoMapResponseDto> getPlaceByKeywords(KakaoMapRequestDto request) {
        String baseUri = "https://dapi.kakao.com/v2/local/search/keyword.json"; // 카카오 API 경로
        List<String> keywordList = request.getKeywordList();
        List<KakaoMapResponseDto> responseList = new ArrayList<>();  // 결과를 저장할 리스트

        RestTemplate restTemplate = new RestTemplate();

        for (String keyword : keywordList) {
            URI uri = UriComponentsBuilder.fromHttpUrl(baseUri)
                    .queryParam("query", keyword)  // 검색 키워드 추가
                    .queryParam("radius", request.getRadius())   // 반경 설정
                    .encode(StandardCharsets.UTF_8)
                    .build()
                    .toUri();

            // API 호출
            ResponseEntity<KakaoMapResultDto> response = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    httpEntity,
                    KakaoMapResultDto.class
            );

            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                // 응답받은 데이터를 리스트에 추가
                KakaoMapResultDto result = response.getBody();
                List<KakaoMapResponseDto> places = result.getDocuments();
                responseList.addAll(places);
            }
        }
        // 결과 반환
        return responseList;
    }
}
