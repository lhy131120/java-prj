package com.java241104.demo_forum.exception;

public class UserNotFindException extends RuntimeException {
  public UserNotFindException(String message) {
    super(message);
  }
}
