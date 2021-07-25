package com.example.demo.singleton;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SingletonService {
  @Test
  void testName() {
    
  }

  @BeforeAll
  static void beforeClass() {
    
  }

  @BeforeEach
  void setUp() {
    
  }

  @AfterEach
  void tearDown() {
    
  }

  @AfterAll
  static void afterClass() {
    
  }

  private static final SingletonService instance = new SingletonService();

  private SingletonService() {

  }

  public static SingletonService getInstance() {
    return instance;
  }
}
