package com.project.introduceourtown.dto.OAuth2Reponse;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@RequiredArgsConstructor
public class CustomOAuth2User implements OAuth2User {

    private final OAuthUserDTO oAuthUserDTO;

    @Override
    public Map<String, Object> getAttributes() {

        return null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> collection = new ArrayList<>();

        collection.add(new GrantedAuthority() {

            @Override
            public String getAuthority() {

                return oAuthUserDTO.getRole();
            }
        });

        return collection;
    }

    @Override
    public String getName() {

        return oAuthUserDTO.getName();
    }

    public String getUsername() {

        return oAuthUserDTO.getUsername();
    }

    public Long getMemberId(){
        return oAuthUserDTO.getMember().getId();
    }
}
