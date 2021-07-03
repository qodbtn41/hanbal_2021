package com.example.demo;

import com.example.demo.helper.order.DiscountPolicy;
import com.example.demo.helper.order.DiscountPolicyFixed;
import com.example.demo.helper.order.DiscountPolicyRate;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemberRepositoryMemory;
import com.example.demo.service.MemberService;
import com.example.demo.service.MemberServiceImpl;
import com.example.demo.service.OrderService;
import com.example.demo.service.OrderServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean
  public MemberService memberService() {
    return new MemberServiceImpl(memberRepository());
  }

  @Bean
  public OrderService orderService() {
    return new OrderServiceImpl(memberRepository(), discountPolicy());
  }

  @Bean
  public MemberRepository memberRepository() {
    return new MemberRepositoryMemory();
  }

  @Bean
  public DiscountPolicy discountPolicy() {
    // return new DiscountPolicyFixed();
    return new DiscountPolicyRate();
  }
}
