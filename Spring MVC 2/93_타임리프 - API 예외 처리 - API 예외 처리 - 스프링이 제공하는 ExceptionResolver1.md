# 93_타임리프 - API 예외 처리 - API 예외 처리 - 스프링이 제공하는 ExceptionResolver1

## API 예외 처리 - 스프링이 제공하는 ExceptionResolver1



스프링 부트가 기본으로 제공하는 `ExceptionResolver` 는 다음과 같다.

`HandlerExceptionResolverComposite` 에 다음 순서로 등록

1. `ExceptionHandlerExceptionResolver`
2. `ResponseStatusExceptionResolver`
3. `DafaultHandlerExceptionResolver` -> 우선 순위가 가장 낮다.



**ExceptionHandlerExceptionResolver**

`@ExceptionHandler` 을 처리한다. API 예외 처리는 대부분 이 기능으로 해결한다. 조금 뒤에 자세히 설명한다.



**ResponseStatusExceptionResolver**

HTTP 상태 코드를 지정해준다.

예) `@ResponseStatus(value = HttpStatus.NOT_FOUND)`



**DefaultHandlerExceptionResolver**

스프링 내부 기본 예외를 처리한다.

먼저 가장 쉬운 `ResponseStatusExceptionResolver` 부터 알아보자.



### ResponseStatusExceptionResolver

`ResponseStatusExceptionResolver` 는 예외에 따라서 HTTP 상태 코드를 지정해주는 역할을 한다.

다음 두 가지 경우를 처리한다.

* `ResponseStatus` 가 달려있는 예외
* `ResponseStatusException` 예외



하나씩 확인해보자.



예외에 다음과 같이 `@ResponseStatus` 애노테이션을 적용하면 HTTP 상태코드를 변경해준다.

```java
package hello.exception.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "잘못된 요청 오류")
public class BadRequestException extends RuntimeException {
}
```

`BadRequestException` 예외가 컨트롤러 밖으로 넘어가면 `ResponseStatusExceptionResolver` 예외가 해당 애노테이션을 확인해서 오류 코드를 `HttpStatus.BAD_REQUEST` (400)으로 변경하고, 메시지도 담는다.



`ResponseStatusExceptionResolver` 코드를 확인해보면 결국 `response.sendError(statusCode, resolvedReson)` 를 호출하는 것을 확인할 수 있다.

`sendError(400)` 를 호출했기 때문에 WAS에서 다시 오류 페이지 (`/error`)를 내부 요청한다.



**ApiExceptionController - 추가**

```java
@GetMapping("/api/response-status-ex1")
public String responseStatusEx1() {
 throw new BadRequestException();
}
```

**실행**

http://localhost:8080/api/response-status-ex1?message=

```
{
 "status": 400,
 "error": "Bad Request",
 "exception": "hello.exception.exception.BadRequestException",
 "message": "잘못된 요청 오류",
 "path": "/api/response-status-ex1"
}
```



**메시지 기능**

`reason` 을 `MessageSource` 에서 찾는 기능도 제공한다. `reason = "error.bad"`

```java
package hello.exception.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "잘못된 요청 오류")
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "error.bad")
public class BadRequestException extends RuntimeException {
}
```

