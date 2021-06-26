package com.example.demo.helper.order;

import com.example.demo.domain.Member;
import com.example.demo.type.Grade;

public class DiscountPolicyFixed implements DiscountPolicy {
  private int discountFixAmount = 1000; // 1000원 할인

  @Override
  public int discount(Member member, int price) {
    if (member.getGrade() == Grade.VIP) {
      return discountFixAmount;
    } else {
      return 0;
    }
  }
}
