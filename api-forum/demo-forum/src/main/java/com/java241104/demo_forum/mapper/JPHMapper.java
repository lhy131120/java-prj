package com.java241104.demo_forum.mapper;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.java241104.demo_forum.entity.AddressEntity;
import com.java241104.demo_forum.entity.CommentEntity;
import com.java241104.demo_forum.entity.CompanyEntity;
import com.java241104.demo_forum.entity.GeoEntity;
import com.java241104.demo_forum.entity.PostEntity;
import com.java241104.demo_forum.entity.UserEntity;
import com.java241104.demo_forum.model.CommentPlaceHolder;
import com.java241104.demo_forum.model.PostPlaceHolder;
import com.java241104.demo_forum.model.UserPlaceHolder;
import com.java241104.demo_forum.model.DTO.CommentDTO;
import com.java241104.demo_forum.model.DTO.UserDTO;
import com.java241104.demo_forum.model.DTO.UserDTO.AddressDTO;
import com.java241104.demo_forum.model.DTO.UserDTO.CompanyDTO;
import com.java241104.demo_forum.model.DTO.UserDTO.GeoDTO;
import com.java241104.demo_forum.model.DTO.UserDTO.PostDTO;

@Component
public class JPHMapper {

  public UserEntity map(UserPlaceHolder userPlaceHolder) {
    return UserEntity.builder()//
        .name(userPlaceHolder.getName())//
        .username(userPlaceHolder.getUsername())//
        .phone(userPlaceHolder.getPhone())//
        .email(userPlaceHolder.getEmail())//
        .website(userPlaceHolder.getWebsite())//
        .build();
  }

  public AddressEntity mapAddressEntity(UserPlaceHolder usePlaceHolder) {
    return AddressEntity.builder()//
        .street(usePlaceHolder.getAddress().getStreet())//
        .suite(usePlaceHolder.getAddress().getSuite())//
        .city(usePlaceHolder.getAddress().getCity())//
        .zipcode(usePlaceHolder.getAddress().getZipcode())//
        .build();
  }

  public CompanyEntity mapCompanyEntity(UserPlaceHolder userPlaceHolder) {
    return CompanyEntity.builder()//
        .name(userPlaceHolder.getCompany().getName())//
        .catchPhrase(userPlaceHolder.getCompany().getCatchPhrase())//
        .bs(userPlaceHolder.getCompany().getBs())//
        .build();
  }

  public GeoEntity mapGeoEntity(UserPlaceHolder userPlaceHolder) {
    return GeoEntity.builder()//
        .lat(userPlaceHolder.getAddress().getGeo().getLat())//
        .lng(userPlaceHolder.getAddress().getGeo().getLng())//
        .build();
  }

  public PostEntity map(PostPlaceHolder postPlaceHolder) {
    return PostEntity.builder()//
        .title(postPlaceHolder.getTitle())//
        .body(postPlaceHolder.getBody())//
        .build();
  }

  public CommentEntity map(CommentPlaceHolder commentPlaceHolder) {
    return CommentEntity.builder()//
        .name(commentPlaceHolder.getName())//
        .email(commentPlaceHolder.getEmail())//
        .body(commentPlaceHolder.getBody())//
        .build();
  }

  public UserDTO map(UserEntity userEntity) {
    GeoDTO geoDTO = GeoDTO.builder()//
        .lng(userEntity.getAddressEntity().getGeoEntity().getLng())//
        .lat(userEntity.getAddressEntity().getGeoEntity().getLat())//
        .build();

    AddressDTO addressDTO = AddressDTO.builder()//
        .street(userEntity.getAddressEntity().getStreet())//
        .suite(userEntity.getAddressEntity().getSuite())//
        .city(userEntity.getAddressEntity().getCity())//
        .zipcode(userEntity.getAddressEntity().getZipcode())//
        .geoDTO(geoDTO)//
        .build();

    CompanyDTO companyDTO = CompanyDTO.builder()//
        .name(userEntity.getCompanyEntity().getName())//
        .catchPhrase(userEntity.getCompanyEntity().getCatchPhrase())//
        .bs(userEntity.getCompanyEntity().getBs())//
        .build();

    List<CommentDTO> commentDTOs = userEntity.getPosts().stream()//
        .map(post -> {
          CommentDTO commentDTO = post.getComments().stream()//
              .map(commentEntity -> this.map(commentEntity))//
              .findFirst()//
              .get();
          return commentDTO;
        })//
        .collect(Collectors.toList());


    List<PostDTO> postDTOs = userEntity.getPosts().stream()//
        .map(postEntity -> {
          PostDTO postDTO = this.map(postEntity);
          postDTO.setComments(commentDTOs);
          return postDTO;
        })//
        .collect(Collectors.toList());


    return UserDTO.builder()//
        .id(userEntity.getId())//
        .name(userEntity.getName())//
        .username(userEntity.getUsername())//
        .email(userEntity.getEmail())//
        .phone(userEntity.getPhone())//
        .website(userEntity.getWebsite())//
        .company(companyDTO)//
        .address(addressDTO)//
        .posts(postDTOs)//
        .build();

  }

  public PostDTO map(PostEntity postEntity) {
    return PostDTO.builder()//
        .id(postEntity.getId())//
        .body(postEntity.getBody())//
        .title(postEntity.getTitle())//
        .build();
  }

  public CommentDTO map(CommentEntity commentEntity) {
    return CommentDTO.builder()//
        .id(commentEntity.getId()).postId(commentEntity.getPostEntity().getId())//
        .name(commentEntity.getName())//
        .body(commentEntity.getBody())//
        .email(commentEntity.getEmail()).build();
  }

}
