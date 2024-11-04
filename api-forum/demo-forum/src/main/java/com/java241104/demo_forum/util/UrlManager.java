package com.java241104.demo_forum.util;

import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

/*
 * Method 1
 */
@Component
public class UrlManager {

  @Value("${api.jsonplaceholder.domain}")
  private String domain;

  public String getUrl(String endpoint) {
    return UriComponentsBuilder.newInstance()//
        .scheme(Scheme.HTTPS.name())//
        .host(domain)//
        .path(endpoint)//
        .toUriString();
  }

  // example
  // https://www.openrice.com/zh/hongkong/voting/top?_sUrl=https%3A%2F%2Fs.openrice.com%2FQrbXcQAAAA%3BBLfE9dWD2h1g0PBs5WFSL1exlTb1D4HWo96YBxWBtXBW-kmO2XBfq9Ecnxq_LZIk
  public String getUrl(String endpoint, Map<String, String> params) {
    return UriComponentsBuilder.newInstance()//
        .scheme(Scheme.HTTPS.name())//
        .host(domain)//
        .path(endpoint)//
        .queryParam("_sUrl",
            "https%3A%2F%2Fs.openrice.com%2FQrbXcQAAAA%3BBLfE9dWD2h1g0PBs5WFSL1exlTb1D4HWo96YBxWBtXBW-kmO2XBfq9Ecnxq_LZI")
        .toUriString();
  }
}

/*
 * Method 2
 */

// public class UrlManager {
// private Scheme scheme;
// private String domain;
// private String endpoint;

// private UrlManager(Builder builder) {
// this.scheme = builder.scheme;
// this.domain = builder.domain;
// this.endpoint = builder.endpoint;
// }

// public static UrlManager.Builder build() {
// return new Builder();
// }

// public String toUrlString() {
// return UriComponentsBuilder.newInstance()//
// .scheme(this.scheme.name().toLowerCase())//
// .host(this.domain)//
// .path(this.endpoint)//
// .toUriString();
// }

// public static class Builder {
// private Scheme scheme;
// private String domain;
// private String endpoint;

// public Builder scheme(Scheme scheme) {
// this.scheme = scheme;
// return this;
// }

// public Builder domain(String domain) {
// this.domain = domain;
// return this;
// }

// public Builder endpoint(String endpoint) {
// this.endpoint = endpoint;
// return this;
// }

// public UrlManager build() {
// return new UrlManager(this);
// }
// }
// }
