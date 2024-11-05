package com.java241104.demo_forum.mapper;

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

}
