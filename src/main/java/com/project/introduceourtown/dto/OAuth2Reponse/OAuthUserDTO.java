package com.project.introduceourtown.dto.OAuth2Reponse;

import com.project.introduceourtown.domain.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OAuthUserDTO {

    private Member member;

    private String role;

    private String name;

    private String username;
}
