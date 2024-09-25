package com.project.introduceourtown.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Keyword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String keyword;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}
