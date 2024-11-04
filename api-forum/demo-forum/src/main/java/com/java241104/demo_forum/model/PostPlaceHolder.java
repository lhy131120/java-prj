package com.java241104.demo_forum.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PostPlaceHolder {
  private Long userId;
  private Long id;
  private String title;
  private String body;
}
