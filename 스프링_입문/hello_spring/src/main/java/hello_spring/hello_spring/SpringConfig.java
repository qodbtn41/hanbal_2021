package hello_spring.hello_spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello_spring.hello_spring.aop.TimeTraceAop;
import hello_spring.hello_spring.repository.MemberRepository;
import hello_spring.hello_spring.service.MemberService;

@Configuration
public class SpringConfig {

  private final MemberRepository memberRepository;

  public SpringConfig(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  @Bean
  public MemberService memberService() {
    return new MemberService(memberRepository);
  }

  @Bean
  public TimeTraceAop timeTraceAop() {
    return new TimeTraceAop();
  }
}
