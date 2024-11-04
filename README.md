#### config
###### AppConfig.java
```
@Configuration
public class AppConfig {
  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
```

#### util 

* Scheme.java
* UrlManager.java
```
@Component
public class UrlManager {

}
```

#### model
* UserPlaceHolder.java
