package com.example.demo.singleton;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.demo.AppConfig;
import com.example.demo.service.MemberService;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

  @Test
  @DisplayName("싱글톤 패턴을 적용한 객체 사용")
  void singletonServiceTest() {
    SingletonService singletonService1 = SingletonService.getInstance();
    SingletonService singletonService2 = SingletonService.getInstance();

    System.out.println("singletonService1 : " + singletonService1);
    System.out.println("singletonService2 : " + singletonService2);

    Assertions.assertThat(singletonService1).isEqualTo(singletonService2);
  }

  @Test
  @DisplayName("싱글톤 패턴을 적용한 객체 사용")
  void springContainer() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    MemberService singletonService1 = ac.getBean(MemberService.class);
    MemberService singletonService2 = ac.getBean(MemberService.class);

    System.out.println("singletonService1 : " + singletonService1);
    System.out.println("singletonService2 : " + singletonService2);

    assertThat(singletonService1).isSameAs(singletonService2);
  }
}
