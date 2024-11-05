package com.java241104.demo_forum.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.java241104.demo_forum.controller.JHPController;
import com.java241104.demo_forum.model.CommentPlaceHolder;
import com.java241104.demo_forum.model.PostPlaceHolder;
import com.java241104.demo_forum.model.UserPlaceHolder;
import com.java241104.demo_forum.service.JPHService;

@RestController
public class JHPOperation implements JHPController {
  @Autowired
  private JPHService jphService;

  @Override
  public List<UserPlaceHolder> getUserRawdata() {
    return jphService.getUserRawdata();
  };

  @Override
  public List<PostPlaceHolder> getPostRawdata() {
    return jphService.getPostRawdata();
  };

  @Override
  public List<CommentPlaceHolder> getCommentRawdata() {
    return jphService.getCommentRawdata();
  };
}
