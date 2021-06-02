package hello_spring.hello_spring.service;

import java.util.Optional;

import hello_spring.hello_spring.domain.Member;
import hello_spring.hello_spring.repository.MemberRepository;
import hello_spring.hello_spring.repository.MemoryMemberRepository;

public class MemberService {
  private final MemberRepository memberRepository = new MemoryMemberRepository();

  /**
   * 회원 가입
   * 
   * @param member
   * @return
   */
  public long join(Member member) {
    // 같은 이름이 있는 중복 회원은 안된다.
    memberRepository.findByName(member.getName()).ifPresent(m -> {
      throw new IllegalStateException("이미 존재하는 회원입니다.");
    });

    memberRepository.save(member);
    return member.getId();
  }
}
