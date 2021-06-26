package hello_spring.hello_spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import hello_spring.hello_spring.domain.Member;
import hello_spring.hello_spring.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceProxy extends MemberService {
  private MemberService 실제객체;

  /**
   * 회원 가입
   * 
   * @param member
   * @return
   */
  public long join(Member member) {
    
    long start = System.currentTimeMillis();
    System.out.println("Start: " + joinPoint.toString());
    
    
    실제객체.join(member);

    long finish = System.currentTimeMillis();
    long timeMs = finish - start;
    System.out.println("End: " + joinPoint.toString() + " " + timeMs + "ms");

  }

}
