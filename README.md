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
```
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserPlaceHolder {
  private Long id;
  private String name;
  private String username;
  private String email;
  private Address address;
  private String phone;
  private String website;
  private Company company;

  // innerClass Here
}
```

##### DTO Folder


#### repository

* UserRepository.java
```
public interface UserRepository extends JpaRepository<UserEntity,Long> {
  // default custom rule
}
```