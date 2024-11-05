package com.java241104.demo_forum.controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.java241104.demo_forum.controller.UserController;
import com.java241104.demo_forum.entity.UserEntity;
import com.java241104.demo_forum.mapper.JPHMapper;
import com.java241104.demo_forum.model.DTO.UserCommentDTO;
import com.java241104.demo_forum.model.DTO.UserDTO;
import com.java241104.demo_forum.repository.UserRepository;
import com.java241104.demo_forum.service.UserService;

@RestController
public class UserOperation implements UserController {

  @Autowired
  private UserService userService;

  @Autowired
  private JPHMapper jphMapper;

  @Override
  public List<UserDTO> getAll() {
    return userService.getAll().stream()//
        .map(userEntity -> jphMapper.map(userEntity))//
        .collect(Collectors.toList());
  }

  @Override
  public List<UserDTO> getUserByID(String userID) {
    List<UserDTO> list = new ArrayList<>();
    list.add(jphMapper.map(userService.getUserByID(Long.parseLong(userID))));
    return list;
  }

  @Override
  public List<UserCommentDTO> getUserCommentByID(String userID) {
    return userService.getUserCommentByID(Long.parseLong(userID));
  }
}
