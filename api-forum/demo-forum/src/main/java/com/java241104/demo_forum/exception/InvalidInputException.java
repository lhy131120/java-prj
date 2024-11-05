package com.java241104.demo_forum.exception;

public class InvalidInputException extends NumberFormatException {
  public InvalidInputException(String message) {
    super(message);
  }
}
