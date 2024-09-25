package com.project.introduceourtown.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private Long passWord;

    private String pictureUrl;

    private String name;

    private String role;

    private String username;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Keyword> keyWordList = new ArrayList<>();
}
