package com.project.introduceourtown.dto.flaskDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FlaskWithImageRequestDto {
    private String location;
    private MultipartFile imageFile;
}
