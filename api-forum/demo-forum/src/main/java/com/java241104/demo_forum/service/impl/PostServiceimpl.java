package com.java241104.demo_forum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java241104.demo_forum.mapper.JPHMapper;
import com.java241104.demo_forum.repository.PostRepository;
import com.java241104.demo_forum.service.JPHService;

@Service
public class PostServiceimpl {

  @Autowired
  private JPHService jphService;

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private JPHMapper jphMapper;
}
