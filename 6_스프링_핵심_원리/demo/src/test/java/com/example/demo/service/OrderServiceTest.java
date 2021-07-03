package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.demo.domain.Member;
import com.example.demo.domain.Order;
import com.example.demo.type.Grade;

import org.junit.jupiter.api.Test;

// @SpringBootTest
public class OrderServiceTest {
  MemberService memberService = new MemberServiceImpl();
  OrderService orderService = new OrderServiceImpl();

  @Test
  public void createOrder() {
    Long memberId = 1L;
    Member member = new Member(1L, "memberA", Grade.VIP);
    memberService.join(member);

    Order order = orderService.createOrder(memberId, "itemA", 10000);
    assertEquals(order.getDiscountPrice(), 1000);

  }
}
