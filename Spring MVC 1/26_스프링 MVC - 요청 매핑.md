# 스프링 MVC - 기본기능 - 요청 매핑

#### MappingController

```java
package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {
private Logger log = LoggerFactory.getLogger(getClass());
 
 /**
 * 기본 요청
 * 둘다 허용 /hello-basic, /hello-basic/
 * HTTP 메서드 모두 허용 GET, HEAD, POST, PUT, PATCH, DELETE
 */
 @RequestMapping("/hello-basic")
 public String helloBasic() {
 log.info("helloBasic");
 return "ok";
 }
}
```

**매핑 정보**

* `@RestController`

  * `@Controller`는 반환 값이 `String`이면 뷰 이름으로 인식된다. 그래서 뷰를 찾고 뷰가 랜더링된다.

  * `@Restcontroller`는 반환 값으로 뷰를 찾는 것이 아니라, HTTP 메시지 바디에 바로 입력한다.

    따라서 실행결과로 ok 메시지를 받을 수 있다. `@ResponseBody`와 관련이 있는데, 뒤에서 더 자세히 설명한다.

* `@RequestMapping("/hello-basic")`

  * `/hello-basic` URL 호출이 오면 이 메서드가 실행되도록 매핑한다.
    * 대부분의 속성을 `배열[]` 로 공하므로 다중 설정이 가능하다. `{"/hello-basic", "/hello-go"}`



#### Postman으로 테스트

**둘다 허용**

다음 두 가지 요청은 다른 URL이지만, 스프링은 다음 URL 요청들을 같은 요청으로 매핑한다.

* 매핑: `/hello-basic`
* URL 요청: `/hello-basic`, `/hello-basic/`



**HTTP 메서드**

`@RequestMapping`에 `method` 속성으로 HTTP 메서드를 지정하지 않으면 HTTP 메서드와 무관하게 호출된다.

모두 허용 GET, HEAD, POST, PUT, PATCH, DELETE



**HTTP 메서드 매핑**

```java
/**
 * method 특정 HTTP 메서드 요청만 허용
 * GET, HEAD, POST, PUT, PATCH, DELETE
 */
@RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
public String mappingGetV1() {
 log.info("mappingGetV1");
 return "ok";
}
```

만약 여기에 POST  요청을 하면 스프링 MVC는 HTTP 405 상태코드(Method Not Allowed)를 반환한다.



**HTTP 메서드 매핑 축약** 

```java
/**
 * 편리한 축약 애노테이션 (코드보기)
 * @GetMapping
 * @PostMapping
 * @PutMapping
 * @DeleteMapping
 * @PatchMapping
 */
@GetMapping(value = "/mapping-get-v2")
public String mappingGetV2() {
 log.info("mapping-get-v2");
 return "ok";
}
```

HTTP 메서드를 축약한 애노테이션을 사용하는 것이 더 직관적이다. 코드를 보면 내부에서 `@RequestMapping`과 `method`를 지정해서 사용하는 것을 확인할 수 있다.



**PathVariable(경로 변수) 사용**

```java
/**
 * PathVariable 사용
 * 변수명이 같으면 생략 가능
 * @PathVariable("userId") String userId -> @PathVariable userId
 */
@GetMapping("/mapping/{userId}")
public String mappingPath(@PathVariable("userId") String data) {
 log.info("mappingPath userId={}", data);
 return "ok";
}
```

**실행**

* http://localgost:8080/mapping/userA

최근 HTTP API는 다음과 같이 리소스 경로에 식별자를 넣는 스타일을 선호한다.

* `/mapping/userA`
* `/users/1`
* `@RequestMapping` 은 URL 경로를 템플릿화 할 수 있는데, `@PathVariable`을 사용하면 매칭 되는 부분을 편리하게 조회할 수 있다.
* `@PathVariable`의 이름과 파라미터 이름이 같으면 생략할 수 있다.



**PathVariable 사용 - 다중**

```java
/**
 * PathVariable 사용 다중
 */
@GetMapping("/mapping/users/{userId}/orders/{orderId}")
public String mappingPath(@PathVariable String userId, @PathVariable Long 
orderId) {
 log.info("mappingPath userId={}, orderId={}", userId, orderId);
 return "ok";
}
```

**실행**

* http://localgost:8080/mapping/userA/orders/100



**특정 파라미터 조건 매핑**

```java
/**
 * 파라미터로 추가 매핑
 * params="mode",
 * params="!mode"
 * params="mode=debug"
 * params="mode!=debug" (! = )
 * params = {"mode=debug","data=good"}
 */
@GetMapping(value = "/mapping-param", params = "mode=debug")
public String mappingParam() {
 log.info("mappingParam");
 return "ok";
}
```

**실행**

* http://localgost:8080/mapping-param?mode=debug

특정 파라미터가 있거나 없는 조건을 추가할 수 있다. 잘 사용하지는 않는다.





**특정 헤더 조건 매핑**

```java
/**
 * 특정 헤더로 추가 매핑
 * headers="mode",
 * headers="!mode"
 * headers="mode=debug"
 * headers="mode!=debug" (! = )
 */
@GetMapping(value = "/mapping-header", headers = "mode=debug")
public String mappingHeader() {
 log.info("mappingHeader");
 return "ok";
}
```

프라미터 매핑과 비슷하지만, HTTP 헤더를 사용한다.

**Postman으로 테스트 해야한다.**



**미디어 타입 조건 매핑 - HTTP 요청 Contemt-Type, consume**

```java
/**
 * Content-Type 헤더 기반 추가 매핑 Media Type
 * consumes="application/json"
 * consumes="!application/json"
 * consumes="application/*"
 * consumes="*\/*"
 * MediaType.APPLICATION_JSON_VALUE
 */
@PostMapping(value = "/mapping-consume", consumes = "application/json")
public String mappingConsumes() {
 log.info("mappingConsumes");
 return "ok";
}
```

**Postman으로 테스트 해야한다.**



HTTP 요청의 Content-Type 헤더를 기반으로 미디어 타입으로 매핑한다.

만약 맞지 않으면 HTTP 415 상태코드(Unsupported Media Type)을 반환한다.

예시) consumes

```java
consumes = "text/plain"
consumes = {"text/plain", "application/*"}
consumes = MediaType.TEXT_PLAIN_VALUE
```





**미디어 타입 조건 매핑 - HTTP 요청 Accept, produce**

```java
/**
 * Accept 헤더 기반 Media Type
 * produces = "text/html"
 * produces = "!text/html"
 * produces = "text/*"
 * produces = "*\/*"
 */
@PostMapping(value = "/mapping-produce", produces = "text/html")
public String mappingProduces() {
 log.info("mappingProduces");
 return "ok";
}
```

HTTP 요청의 Accept 헤더를 기반으로 미디어 타입으로 매핑한다.

만약 맞지 않으면 HTTP 406 상태코드(Not Acceptable)을 반환한다.

예시)

```java
produces = "text/plain"
produces = {"text/plain", "application/*"}
produces = MediaType.TEXT_PLAIN_VALUE
produces = "text/plain;charset=UTF-8"
```













