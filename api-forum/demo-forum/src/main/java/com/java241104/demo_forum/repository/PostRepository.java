package com.java241104.demo_forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.java241104.demo_forum.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

}
