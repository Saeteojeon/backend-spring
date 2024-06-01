package com.project.introduceourtown.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class FlaskController {

    RestTemplate restTemplate = new RestTemplate();
}
