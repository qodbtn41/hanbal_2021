package com.example.demo.helper.order;

import com.example.demo.domain.Member;

public interface DiscountPolicy {

  /**
   * @return 할인대상금액
   */
  int discount(Member member, int price);
}
