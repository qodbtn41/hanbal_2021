package hello_spring.hello_spring.service;

import java.util.List;
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
    validateDuplicateMember(member);
    memberRepository.save(member);
    return member.getId();
  }

  /**
   * 동일한 이름의 회원이 있는지 검증한다.
   * 
   * @param member
   */
  private void validateDuplicateMember(Member member) {
    memberRepository.findByName(member.getName()).ifPresent(m -> {
      throw new IllegalStateException("이미 존재하는 회원입니다.");
    });
  }

  /**
   * 전체 회원 조회
   * 
   * @return
   */
  public List<Member> findMembers() {
    return memberRepository.findAll();
  }

  public Optional<Member> findOne(Long memberId) {
    return memberRepository.findById(memberId);
  }
}
