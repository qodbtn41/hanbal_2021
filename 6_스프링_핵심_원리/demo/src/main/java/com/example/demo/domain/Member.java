package com.example.demo.domain;

import com.example.demo.type.Grade;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Member {
  private Long id;
  private String name;
  private Grade grade;
}
