# 스프링 MVC - 요청매핑 - API 예시

> 회원 관리 HTTP API로 만든다 생각하고 매핑을 어떻게 하는지 알아보자.
>
> (URL 매핑만 다뤄봄)



#### 회원관리 API

* 회원 목록 조회 : GET  `/users`
* 회원 등록 :  POST `/users`
* 회원 조회 : GET `/users/{userId}`
* 회원 수정 :  PATCH `/users/{userId}`
* 회원 삭제 : DELETE `/users/{userId}`

**MappingClassController**

```java
package hello.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {
   /**
   * GET /mapping/users
   */
   @GetMapping
   public String users() {
   return "get users";
   }
  
   /**
   * POST /mapping/users
   */
   @PostMapping
   public String addUser() {
   return "post user";
   }
  
   /**
   * GET /mapping/users/{userId}
   */
   @GetMapping("/{userId}")
   public String findUser(@PathVariable String userId) {
   return "get userId=" + userId;
   }
  
   /**
   * PATCH /mapping/users/{userId}
   */
   @PatchMapping("/{userId}")
   public String updateUser(@PathVariable String userId) {
   return "update userId=" + userId;
   }
  
   /**
   * DELETE /mapping/users/{userId}
   */
   @DeleteMapping("/{userId}")
   public String deleteUser(@PathVariable String userId) {
   return "delete userId=" + userId;
   }
}
```

* `/mapping` 는 다른 예제들과 구분하기 위해 사용
* `@RequestMapping("/mapping/users")`
  * 클래스 레벨에 매핑정보를 두면 메서드 레벨에서 해당 정보를 조합해서 사용한다.



**Postman으로 테스트**

* 회원 목록 조회 : GET `/mapping/users`
* 회원 등록 : POST `/mapping/users `
* 회원 조회 : GET `/mapping/users/id1` 
* 회원 수정 : PATCH `/mapping/users/id1` 
* 회원 삭제 : DELETE `/mapping/users/id1`