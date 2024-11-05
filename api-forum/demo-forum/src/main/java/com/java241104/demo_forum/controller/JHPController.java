package com.java241104.demo_forum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.java241104.demo_forum.model.CommentPlaceHolder;
import com.java241104.demo_forum.model.PostPlaceHolder;
import com.java241104.demo_forum.model.UserPlaceHolder;

public interface JHPController {
  @GetMapping("/users")
  List<UserPlaceHolder> getUserRawdata();

  @GetMapping("/posts")
  List<PostPlaceHolder> getPostRawdata();

  @GetMapping("/comments")
  List<CommentPlaceHolder> getCommentRawdata();
}
