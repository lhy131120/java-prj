package com.java241104.demo_forum.model.DTO;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class UserCommentDTO {
  private Long id;
  private String username;

  @Builder.Default
  private List<CommentDTO> comments = new ArrayList<>();
}
