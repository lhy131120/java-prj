package com.java241104.demo_forum.util;

import lombok.Getter;

@Getter
public enum Scheme {
  /*
   * Method 1
   */
  // HTTP, HTTPS,;

  /*
   * Method2
   */
  HTTPS("https"), HTTP("http"),;

  private String scheme;

  private Scheme(String scheme) {
    this.scheme = scheme;
  }
}
