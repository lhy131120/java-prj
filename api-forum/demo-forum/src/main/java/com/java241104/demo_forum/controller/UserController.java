package com.java241104.demo_forum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.java241104.demo_forum.model.DTO.UserCommentDTO;
import com.java241104.demo_forum.model.DTO.UserDTO;

public interface UserController {
  @GetMapping("allUserPostComment")
  public List<UserDTO> getAll();

  @GetMapping()
  public List<UserDTO> getUserByID(@RequestParam String userID);

  @GetMapping("getUserCommentByID") // ?userID=1
  public List<UserCommentDTO> getUserCommentByID(@RequestParam String userID);

}
