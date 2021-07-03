package com.example.demo.helper.order;

import com.example.demo.domain.Member;
import com.example.demo.type.Grade;

public class DiscountPolicyRate implements DiscountPolicy {

  private int discountPercent = 10;

  @Override
  public int discount(Member member, int price) {
    if (member.getGrade() == Grade.VIP) {
      return price * discountPercent / 100;
    } else {
      return 0;
    }
  }

}
