package hello_spring.hello_spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello_spring.hello_spring.repository.MemberRepository;
import hello_spring.hello_spring.repository.MemoryMemberRepository;
import hello_spring.hello_spring.service.MemberService;

@Configuration
public class SpringConfig {

  @Bean
  public MemberService memberService() {
    return new MemberService(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository() {
    return new MemoryMemberRepository();
  }
}
