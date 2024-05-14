package com.project.introduceourtown.domain;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class mainController {

    @GetMapping("/")
    public String mainAPI(){
        return " maon route";
    }
}
