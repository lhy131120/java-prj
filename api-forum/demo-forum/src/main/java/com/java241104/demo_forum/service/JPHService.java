package com.java241104.demo_forum.service;

import java.util.List;
import com.java241104.demo_forum.model.CommentPlaceHolder;
import com.java241104.demo_forum.model.PostPlaceHolder;
import com.java241104.demo_forum.model.UserPlaceHolder;

public interface JPHService {
  List<UserPlaceHolder> getUserRawdata();

  List<PostPlaceHolder> getPostRawdata();

  List<CommentPlaceHolder> getCommentRawdata();
}
