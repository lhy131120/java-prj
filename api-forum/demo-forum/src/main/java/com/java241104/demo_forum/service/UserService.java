package com.java241104.demo_forum.service;

import java.util.List;
import com.java241104.demo_forum.entity.UserEntity;
import com.java241104.demo_forum.model.DTO.UserCommentDTO;
import com.java241104.demo_forum.model.DTO.UserDTO;

public interface UserService {

  /**
   * Get User Data from jsonplaceholder website - DTO
   * 
   * @return
   */


  /**
   * Get User Data from Database - Entity
   * 
   * @return
   */
  List<UserEntity> saveAll(List<UserEntity> userentities);

  List<UserEntity> getAll();

  UserEntity getUserByID(Long id);

  List<UserCommentDTO> getUserCommentByID(Long id);
}
