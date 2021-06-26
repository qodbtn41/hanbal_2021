package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemberRepositoryMemory;

public class MemberServiceImpl implements MemberService {
  private final MemberRepository memberRepository = new MemberRepositoryMemory();

  @Override
  public void join(Member member) {
    memberRepository.save(member);
  }

  @Override
  public Member findMember(Long memberId) {
    return memberRepository.findById(memberId);
  }

}
