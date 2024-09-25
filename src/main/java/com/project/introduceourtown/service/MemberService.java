package com.project.introduceourtown.service;

import com.project.introduceourtown.domain.Member;
import com.project.introduceourtown.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Member findByUsername(String userName){
        return memberRepository.findByUsername(userName);
    }


    @Transactional
    public Member findById(Long memberId){return memberRepository.findById(memberId).orElseThrow();}
}
