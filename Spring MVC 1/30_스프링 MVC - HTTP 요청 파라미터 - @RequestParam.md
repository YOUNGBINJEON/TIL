# 스프링 MVC - HTTP 요청 파라미터 - 쿼리 파라미터, HTML Form



## HTTP 요청 데이터 조회 - 개요

> 서블릿에서 학습했던 HTTP 요청 데이터를 조회 하는 방법을 다시 떠올려보자. 그리고 서블릿으로 학습했던 내용을 스프링이 얼마나 깔끔하고 효율적으로 바꾸어주는지 알아보자.
>
> HTTP 요청 메시지를 통해 클라이언트에서 서버로 데이터를 전달하는 방법을 알아보자.

**클라이언트에서 서버로 요청 데이터를 전달할 때는 주로 다음 3가지 방법을 사용한다.**

* **GET - 쿼리 파라미터**
  * /url?username=hello&age=20
  * 메시지 바디 없이, URL의 쿼리 파라미터에 데이터를 포함해서 전달
  * 예) 검색, 필터, 페이징 등에서 많이 사용하는 방식
* **POST - HTML Form**
  * content-type: application/x-www-form-urlencoded
  * 예) 회원가입, 상품주문, HTML Form 사용
* **HTTP message body**
  * HTTP API에서 주료 사용, JSON, XML, TEXT
  * 데이터 형식은 주로 JSON 사용
  * POST, PUT, PATCH



## 요청 파리미터 - 쿼리파라미터, HTML Form

> `HttpServletRequest`의 `request.getParameter()`를 사용하면 다음 두가지 요청 파라미터를 조회할 수 있다.



#### GET, 쿼리 파라미터 전송

예시

`http://localhost:8080/request-param?username=hello&age=20`



#### POST, HTML Form 전송

예시

```java
	POST /request-param ...
  content-type: application/x-www-form-urlencoded

  username=hello&age=20
```

GET 쿼리 파라미터 전송 방식이든, POST HTML Form 전송 방식이든 둘다 형식이 같으므로 구분없이 조회할 수 있다.

이것을 간단히 **요청 파라미터(request parameter)조회**라 한다. 

지금부터 스프링으로 요청 파라미터를 조회하는 방법을 단계적으로 알아보자.



**RequestParamController**

```java
package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {
  /**
 	* 반환 타입이 없으면서 이렇게 응답에 값을 직접 집어넣으면, view 조회X
 	*/
 	@RequestMapping("/request-param-v1")
 	public void requestParamV1(HttpServletRequest request, HttpServletResponse 
response) throws IOException {
    
    String username = request.getParameter("username"); 
    int age = Integer.parseInt(request.getParameter("age"));
    log.info("username={}, age={}", username, age);
    
 		response.getWriter().write("ok");
 	}
}
```

**request.getParameter()**

여기서는 단순히 HttpServletRequest가 제공하는 방식으로 요청 파라미터를 조회했다.



**GET 실행** 

http://localhost:8080/request-param-v1?username=hello&age=20



**Post Form 페이지 생성**

먼저 테스트용 HTML Form을 만들어야 한다.

리소스는 `/resources/static` 아래에 두면 스프링 부트가 자동으로 인식한다.

`main/resources/static/basic/hello-form.html`

```html
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>Title</title>
</head>
<body>
   <form action="/request-param-v1" method="post">
     username: <input type="text" name="username" />
     age: <input type="text" name="age" />
     <button type="submit">전송</button>
   </form>
</body>
</html>
```

**Post Form 실행**

http://localhost:8080/basic/hello-form.html

> 참고
>
> `Jar`를 사용하면 `webapp` 경로를 사용할 수 없다. 이제부터 정적 리소스도 클래스 경로에 함께 포함해야 한다.



## HTTP 요청 파라미터 - @RequestParam

> 스프링이 제공하는 `@RequestParam`을 사용하면 요청 파라미터를 매우 편리하게 사용할 수 있다.

**requestParamV2**

```java
/**
 * @RequestParam 사용
 * - 파라미터 이름으로 바인딩
 * @ResponseBody 추가
 * - View 조회를 무시하고, HTTP message body에 직접 해당 내용 입력
 */
@ResponseBody
@RequestMapping("/request-param-v2")
public String requestParamV2(@RequestParam("username") String memberName,
                             @RequestParam("age") int memberAge) {
  
  log.info("username={}, age={}", memberName, memberAge);
  return "ok";
}
```

* `@RequestParam` : 파라미터 이름으로 바인딩

* `@ResponseBody` : View 조회를 무시하고, HTTP message body에 직접 해당 내용 입력

  **@RequestParam**의 `name(value)` 속성이 파라미터 이름으로 사용

* @RequestParam("**username**") String **memberName**

* => request.getParameter("**username**")



**requestParamV3**

```java
/**
 * @RequestParam 사용
 * HTTP 파라미터 이름이 변수 이름과 같으면 @RequestParam(name="xx") 생략 가능
 */
@ResponseBody
@RequestMapping("/request-param-v3")
public String requestParamV3(@RequestParam String username,
                             @RequestParam int age) {
  
  log.info("username={}, age={}", username, age);
 	return "ok";
}
```

HTTP 파라미터 이름이 변수 이름과 같으면 `@RequestParam(name="xx")` 생략 가능



**requestParamV4**

```java
/**
 * @RequestParam 사용
 * String, int 등의 단순 타입이면 @RequestParam 도 생략 가능
 */
@ResponseBody
@RequestMapping("/request-param-v4")
public String requestParamV4(String username, int age) {
  
  log.info("username={}, age={}", username, age);
 	return "ok";
}
```

`String`, `int`, `Integer`등의 단순 타입이면 `@RequestParam`도 생략 가능

> **주의**
>
> `@RequestParam` 애뇨테이션을 생략하면 스프링 MVC는 내부에서 `required=false`를 적용한다.
>
> `required` 옵션은 바로 다음에 설명



> **참고**
>
> 이렇게 애노테이션을 완전히 생략해도 되는데, 너무 없는 것도 과하다는 주관적인 생각이 들 수 있다.
>
> `@RequestParam`이 있으면 명확하게 요청 파라미터에서 데이터를 읽는다는 것을 알 수 있다.





**파라미터 필수 여부 - requestParamRequired**

```java
/**
 * @RequestParam.required
 * /request-param -> username이 없으므로 예외
 *
 * 주의!
 * /request-param?username= -> 빈문자로 통과
 *
 * 주의!
 * /request-param
 * int age -> null을 int에 입력하는 것은 불가능, 따라서 Integer 변경해야 함(또는 다음에 나오는
defaultValue 사용)
 */
@ResponseBody
@RequestMapping("/request-param-required")
public String requestParamRequired(@RequestParam(required = true) String username,
                                   @RequestParam(required = false) Integer age) {
  
  log.info("username={}, age={}", username, age);
 	return "ok";
}
```

* `@RequestParam.required`
  * 파라미터 필수 여부
  * 기본값이 파라미터 필수(`true`)이다.
* `/request-param` 요청
  * `username`이 없으므로 400 예외가 발생한다.



**주의1! - 파라미터 이름만 사용**

`/request-param?username=`

파라미터 이름만 있고 값이 없는 경우 -> 빈문자("")로 통과



**주의2! - 기본형(primitive)에 null 입력**

* `/request-param` 요청
* `@RequestParam(required = false) int age`

`null`을 `int`에 입력하는 것은 불가능(500 예외 발생)

따라서 `null`을 받을 수 있는 `Integer`로 변경하거나, 또는 다음에 나오는 `defaultValue` 사용



**기본 값 적용 - requestParamDefault**

```java
/**
 * @RequestParam
 * - defaultValue 사용
 *
 * 참고: defaultValue는 빈 문자의 경우에도 적용
 * /request-param?username=
 */
@ResponseBody
@RequestMapping("/request-param-default")
public String requestParamDefault(
  @RequestParam(required = true, defaultValue = "guest") String username,
 	@RequestParam(required = false, defaultValue = "-1") int age) {
  
  log.info("username={}, age={}", username, age);
 	return "ok";
}
```

파라미터에 값이 없는 경우 `defaultValue`를 사용하면 기본 값을 적용할 수 있다.

이미 기본 값이 있기 때문에 `required`는 의미가 없다.



`defaultValue`는 빈 문자의 경우에도 설정한 기본 값이 적용된다.

`/request-param?username=`



**파라미터를 Map으로 조회하기 - requestParamMap**

```java
/**
 * @RequestParam Map, MultiValueMap
 * Map(key=value)
 * MultiValueMap(key=[value1, value2, ...] ex) (key=userIds, value=[id1, id2])
 */
@ResponseBody
@RequestMapping("/request-param-map")
public String requestParamMap(@RequestParam Map<String, Object> paramMap) {

  log.info("username={}, age={}", paramMap.get("username"),
           paramMap.get("age"));

  return "ok";
}
```

파라미터를 Map, MultiValueMap으로 조회할 수 있다.



* `@RequestPram Map`
  * `Map(key=value)`
* `@RequestParam MultiValueMap`
  * `MultiValueMap(Key=[value1, value2, ...] ex) (key=userIds, value=[id1, id2])`

파라미터의 값이 1개가 확실하다면 `Map`을 사용해도 되지만, 그렇지 않다면 `MultiValueMap`을 사용하자.

