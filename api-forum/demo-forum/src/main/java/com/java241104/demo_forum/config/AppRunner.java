package com.java241104.demo_forum.config;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import com.java241104.demo_forum.entity.AddressEntity;
import com.java241104.demo_forum.entity.CommentEntity;
import com.java241104.demo_forum.entity.CompanyEntity;
import com.java241104.demo_forum.entity.GeoEntity;
import com.java241104.demo_forum.entity.PostEntity;
import com.java241104.demo_forum.entity.UserEntity;
import com.java241104.demo_forum.mapper.JPHMapper;
import com.java241104.demo_forum.model.CommentPlaceHolder;
import com.java241104.demo_forum.model.PostPlaceHolder;
import com.java241104.demo_forum.model.UserPlaceHolder;
import com.java241104.demo_forum.service.JPHService;
import com.java241104.demo_forum.service.UserService;

@Configuration
public class AppRunner implements CommandLineRunner {

  @Autowired
  private UserService userService;

  @Autowired
  private JPHMapper mapper;

  @Autowired
  private JPHService jphService;

  @Override
  public void run(String... args) throws Exception {
    System.out.println("Start Server: App Runner!!!");
    System.out.println("Start saving  address, company ,geo, post and comment");
    List<UserPlaceHolder> users = jphService.getUserRawdata();
    List<PostPlaceHolder> posts = jphService.getPostRawdata();
    List<CommentPlaceHolder> comments = jphService.getCommentRawdata();

    List<UserEntity> userEntities = users.stream().map(uDto -> {
      UserEntity userEntity = this.mapper.map(uDto);

      AddressEntity addressEntity = this.mapper.mapAddressEntity(uDto);

      GeoEntity geoEntity = this.mapper.mapGeoEntity(uDto);
      geoEntity.setAddress(addressEntity);

      addressEntity.setGeoEntity(geoEntity);
      addressEntity.setUserEntity(userEntity);

      CompanyEntity companyEntity = this.mapper.mapCompanyEntity(uDto);
      companyEntity.setUserEntity(userEntity);

      List<PostEntity> postEntities = posts.stream()//
          .filter(pDto -> pDto.getUserId().equals(uDto.getId()))//
          .map(pDto -> {
            PostEntity postEntity = this.mapper.map(pDto);

            List<CommentEntity> commentEntities = comments.stream() //
                .filter(cDto -> cDto.getPostId().equals(pDto.getId())) //
                .map(cDto -> {
                  CommentEntity commentEntity = this.mapper.map(cDto);
                  commentEntity.setPostEntity(postEntity);
                  return commentEntity;
                }).collect(Collectors.toList());

            postEntity.setComments(commentEntities);
            postEntity.setUserEntity(userEntity);
            return postEntity;
          })//
          .collect(Collectors.toList());

      userEntity.setAddressEntity(addressEntity);
      userEntity.setCompanyEntity(companyEntity);
      userEntity.setPosts(postEntities);
      return userEntity;

    }).collect(Collectors.toList());

    userService.saveAll(userEntities);
  }


}
