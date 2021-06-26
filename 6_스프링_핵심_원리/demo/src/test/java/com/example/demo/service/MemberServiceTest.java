package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.demo.domain.Member;
import com.example.demo.type.Grade;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberServiceTest {

  private MemberService memberService = new MemberServiceImpl();

  @Test
  public void memberJoin() {
    Member member = new Member(1L, "memberA", Grade.VIP);
    memberService.join(member);

    Member findMember = memberService.findMember(1L);
    assertEquals(member.getName(), findMember.getName());
  }
}
