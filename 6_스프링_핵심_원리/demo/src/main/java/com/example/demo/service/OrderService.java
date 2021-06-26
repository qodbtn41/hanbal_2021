package com.example.demo.service;

import com.example.demo.domain.Order;

public interface OrderService {
  Order createOrder(Long memberid, String itemName, int itemPrice);
}
