package com.project.introduceourtown.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
//redis를 활용한 refreshToken
@Getter
@RedisHash(value = "refreshToken", timeToLive = 14440)
@Builder
public class RefreshEntity {
    @Id
    private String refresh;

    private String username;

    private String expiration;


}
