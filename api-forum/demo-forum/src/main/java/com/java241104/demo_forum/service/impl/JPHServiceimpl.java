package com.java241104.demo_forum.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.java241104.demo_forum.model.UserPlaceHolder;
import com.java241104.demo_forum.service.JPHService;
import com.java241104.demo_forum.util.UrlManager;

@Service
public class JPHServiceimpl implements JPHService {
  @Autowired
  private UrlManager urlManager;
  @Autowired
  private RestTemplate restTemplate;
  
  @Value("${api.jsonplaceholder.endpoint.users}")
  private String userEndpoint;

  @Value("${api.jsonplaceholder.endpoint.posts}")
  private String postEndpoint;

  @Value("${api.jsonplaceholder.endpoint.comments}")
  private String commentEndpoint;

  @Override
  public List<UserPlaceHolder> getUserRawdata() {
    return List.of(restTemplate.getForObject(urlManager.getUrl(userEndpoint),
        UserPlaceHolder[].class));
  }
}
