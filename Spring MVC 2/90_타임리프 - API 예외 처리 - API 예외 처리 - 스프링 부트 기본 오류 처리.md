# 90_타임리프 - API 예외 처리 - API 예외 처리 - 스프링 부트 기본 오류 처리

##  API 예외 처리 - 스프링 부트 기본 오류 처리

API 예외 처리도 스프링 부트가 제공하는 기본 오류 방식을 사용할 수 있다.

스프링 부트가 제공하는 `BasicErrorController` 코드를 보자.



**BasicErrorController 코드**

```java
@RequestMapping(produces = MediaType.TEXT_HTML_VALUE)
public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse 
response) {}

@RequestMapping
public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {}
```

`/error` 동일한 경로를 처리하는 `errorHtml()`, `error()` 두 메서드를 확인할 수 있다.

* `errorHtml()` : `produces = MediaType.TEXT_HTML_VALUE` : 클라이언트 요청의 Accept 해더 값이 `text/html` 인 경우에는 `errorHtml() ` 을 호출해서 view를 제공한다.
* `error()` : 그외 경우에 호출되고 `ResponseEntity` 로 HTTP Body에 JSON 데이터를 반환한다.



**스프링 부트의 예외 처리**

앞서 학습했듯이 스프링 부트의 기본 설정은 오류 발생시 `/error` 를 오류 페이지로 요청한다.

`BasicErrorController` 는 이 경로를 기본으로 받는다. (`server.error.path` 로 수정 가능, 기본 경로 `/error`)



**Postman으로 실행**

GET http://localhost:8080/api/members/ex

**주의**

`BasicErrorController` 를 사용하도록 `WebServerCustomizer` 의 `@Component`를 주석 처리 하자.

```java

{ 
	"timestamp": "2021-04-28T00:00:00.000+00:00",
 	"status": 500,
 	"error": "Internal Server Error",
 	"exception": "java.lang.RuntimeException",
 	"trace": "java.lang.RuntimeException: 잘못된 사용자\n\tat 
hello.exception.web.api.ApiExceptionController.getMember(ApiExceptionController
.java:19...,
 	"message": "잘못된 사용자",
 	"path": "/api/members/ex"
}
```

스프링 부트는 `BasicErrorController` 가 제공하는 기본 정보들을 활용해서 오류 API를 생성해준다.

다음 옵션들을 설정하면 더 자세한 오류 정보를 추가할 수 있다.

* server.error.include-binding-errors=always
* server.error.include-exception=true
* server.error.include-message=always
* server.error.include-stacktrace=always

물론 오류 메시지는 이렇게 막 추가하면 보안상 위험할 수 있다. 간결한 메시지만 노출하고, 로그를 통해서 확인하자.