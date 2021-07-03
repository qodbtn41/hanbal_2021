package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.domain.Order;
import com.example.demo.helper.order.DiscountPolicy;
import com.example.demo.repository.MemberRepository;

public class OrderServiceImpl implements OrderService {
  private final MemberRepository memberRepository;
  private final DiscountPolicy discountPolicy;

  public OrderServiceImpl(MemberRepository memberRepository2, DiscountPolicy discountPolicy2) {
    this.memberRepository = memberRepository2;
    this.discountPolicy = discountPolicy2;
  }

  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);
    int discountPrice = discountPolicy.discount(member, itemPrice);

    return new Order(memberId, itemName, itemPrice, discountPrice);
  }

}
