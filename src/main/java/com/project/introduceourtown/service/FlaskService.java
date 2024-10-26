package com.project.introduceourtown.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.introduceourtown.dto.flaskDto.FlaskRequestDto;
import com.project.introduceourtown.dto.flaskDto.FlaskResponseListDto;
import com.project.introduceourtown.dto.flaskDto.FlaskWithImageRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class FlaskService {

    //데이터를 JSON 객체로 변환하기 위해서 사용
    private final ObjectMapper objectMapper;

    @Transactional
    public FlaskResponseListDto sendToFlask(FlaskRequestDto dto) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();

        //헤더를 JSON으로 설정함
        HttpHeaders headers = new HttpHeaders();

        //파라미터로 들어온 dto를 JSON 객체로 변환
        headers.setContentType(MediaType.APPLICATION_JSON);

        String param = objectMapper.writeValueAsString(dto);
        System.out.println("DTP: " + dto.getQuestion());

        HttpEntity<String> entity = new HttpEntity<String>(param , headers);

        //실제 Flask 서버랑 연결하기 위한 URL
        String url = "http://3.36.50.204:5000/api/recommend-neighborhoods";

        //Flask 서버로 데이터를 전송하고 받은 응답 값을 return
        return restTemplate.postForObject(url, entity, FlaskResponseListDto.class);
    }

    @Transactional
    public FlaskResponseListDto sendToFlaskWithImage(MultipartFile imageFile, String location) {
        RestTemplate restTemplate = new RestTemplate();

        try {
            if (imageFile == null) {
                log.error("Image file is null. Please check the request payload.");
                throw new IllegalArgumentException("Image file cannot be null.");
            }
            // 헤더 설정: multipart/form-data
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);

            // MultiValueMap을 사용해 multipart/form-data 형식의 데이터를 준비
            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            body.add("location", location);  // 문자열 필드 추가
            body.add("imageFile", new ByteArrayResource(imageFile.getBytes()) {
                @Override
                public String getFilename() {
                    return imageFile.getOriginalFilename();  // 파일 이름 제공
                }
            });

            // 요청 엔티티 생성
            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

            // Flask 서버로 요청을 전송할 URL
            String url = "http://13.125.167.244:8000/api/image-analysis/recommend-neighborhoods";
            log.info("Start of process method");
            // Flask 서버로 데이터를 전송하고 받은 응답 값을 반환
            ResponseEntity<FlaskResponseListDto> response = restTemplate.postForEntity(url, requestEntity,
                    FlaskResponseListDto.class);
            return response.getBody();

        } catch (IOException e) {
            throw new RuntimeException("Flask 서버로 데이터를 전송하는 중 에러 발생", e);
        }
    }
}