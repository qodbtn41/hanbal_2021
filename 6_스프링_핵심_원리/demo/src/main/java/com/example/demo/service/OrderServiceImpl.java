package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.domain.Order;
import com.example.demo.helper.order.DiscountPolicy;
import com.example.demo.helper.order.DiscountPolicyFixed;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemberRepositoryMemory;

public class OrderServiceImpl implements OrderService {
  private final MemberRepository memberRepository = new MemberRepositoryMemory();
  private final DiscountPolicy discountPolicy = new DiscountPolicyFixed();

  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);
    int discountPrice = discountPolicy.discount(member, itemPrice);

    return new Order(memberId, itemName, itemPrice, discountPrice);
  }

}
