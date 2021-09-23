# 스프링 MVC - HTTP 요청 - 기본, 헤더 조회

> 애노테이션 기반의 스프링 컨트롤러는 다양한 파라미터를 지원한다.
>
> HTTP 헤저 정보를 조회하는 방법을 알아보자.

```java
package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Slf4j
@RestController
public class RequestHeaderController {
 @RequestMapping("/headers")
  public String headers(HttpServletRequest request,
 											 	HttpServletResponse response,
                   		 	HttpMethod httpMethod,
                   	 	 	Locale locale,
                       	@RequestHeader MultiValueMap<String, String>
                      	headerMap,
                       	@RequestHeader("host") String host,
                       	@CookieValue(value = "myCookie", required = false)
											 	String cookie) {
    log.info("request={}", request);
   	log.info("response={}", response);
   	log.info("httpMethod={}", httpMethod);
   	log.info("locale={}", locale);
   	log.info("headerMap={}", headerMap);
   	log.info("header host={}", host);
   	log.info("myCookie={}", cookie);

   	return "ok";
   	}
}
```

* `HttpServletRequest`
* `HttpServletResponse`
* `HttpMethod` : HTTP 메서드를 조회한다. `org.springframework.http.HttpMethod`
* `Locale` : Locale 정보를 조회한다.
* `@RequestHeader MultiValueMap<String, String> headerMap`
  * 모든 HTTP 헤더를 MultiValueMap 형식으로 조회한다.
* `@RequestHeader("host") String host`
  * 특정 HTTP 헤더를 조회한다.
  * 속성
    * 필수 값 여부 : `required`
    * 기본 값 속성 : `defaultValue`
* `@CookieValue(value = "myCookie", required = false) String cookie`
  * 특정 쿠키를 조회한다.
  * 속성
    * 필수 값 여부 : `required`
    * 기본 값 : `defaultValue`



`MutiValueMap`

* MAP과 유사한데, 하나의 키에 여러 값을 받을 수 있다.
* HTTP header, HTTP 쿼리 파라미터와 같이 하나의 키에 여러 값을 받을 때 사용한다.
  * **keyA=value1&keyA=value2**

```java
MultiValueMap<String, String> map = new LinkedMultiValueMap();
map.add("keyA", "value1");
map.add("keyA", "value2");

//[value1,value2]
List<String> values = map.get("keyA");
```



**@Slf4j**

다음 코드를 자동으로 생성해서 로그를 선언해준다. 개발자는 편리하게 `log` 라고 사용하면 된다.

```java
private static final org.slf4j.Logger log = 
org.slf4j.LoggerFactory.getLogger(RequestHeaderController.class);
```

> 참고 자료 1
>
> `@Controller` 의 사용 가능한 파라미터 목록은 다음 공식 메뉴얼에서 확인할 수 있다.
>
> https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-ann-arguments



> 참고 자료 2
>
> `@Controller` 의 사용 가능한 응답 값 목록은 다음 공식 메뉴얼에서 확인할 수 있다.
>
> https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-ann-return-types

