**Folder: config**
###### AppConfig.java
```
/*
 * Remark: @Configuration, @Bean
 */

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
/*
 * Remark: @Component
 */
 
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
>數據傳輸：DataDTO用於在不同層之間傳遞數據。這樣可以避免直接暴露數據庫實體，增加系統的安全性和靈活性。

> 數據封裝：DataDTO通常包含需要傳遞的特定數據字段，可以根據需要增加或減少字段，從而控制傳遞數據的結構和內容。

>解耦合：DataDTO使得系統的各層次之間更加解耦，降低系統的耦合度。這樣的設計便於維護和擴展。

>數據格式轉換：在需要的情況下，DataDTO可以用來格式化或轉換數據，確保數據在不同層之間的傳遞格式一致。

> 驗證與校驗：有時可以在DTO中進行基本的數據驗證和校驗，確保數據的完整性和有效性。



#### repository

* UserRepository.java
```
public interface UserRepository extends JpaRepository<UserEntity,Long> {
  // default custom rule
}
```