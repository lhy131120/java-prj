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
public class CommentPlaceHolder {
  private Long postId;
  private Long id;
  private String name;
  private String email;
  private String body;
}
