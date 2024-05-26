package com.project.introduceourtown.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@RedisHash(value = "refreshToken", timeToLive = 14440)
@Builder
public class RefreshEntity {
    @Id
    private String refresh;

    private String username;

    private String expiration;


}
