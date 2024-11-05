package com.java241104.demo_forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.java241104.demo_forum.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
