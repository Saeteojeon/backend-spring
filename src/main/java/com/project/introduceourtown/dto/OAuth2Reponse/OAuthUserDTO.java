package com.project.introduceourtown.dto.OAuth2Reponse;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OAuthUserDTO {

    private String role;

    private String name;

    private String username;
}
