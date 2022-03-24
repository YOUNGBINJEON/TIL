# 91_타임리프 - API 예외 처리 - API 예외 처리 - HabdkerExceotuibResolver 시작

## API 예외 처리 - HabdkerExceotuibResolver 시작

**목표**

예외가 발생해서 서블릿을 넘어 WAS까지 예외가 전달되면 HTTP 상태코드가 500으로 처리된다. 발생하는 예외에 따라서 400, 404 등등 다른 상태코드도 처리하고 싶다.

오류 메시지, 형식등을 API마다 다르게 처리하고 싶다.



**상태코드 변환**

예를 들어서 `IllegalArgumentException` 을 처리하지 못해서 컨트롤러 밖으로 넘어가는 일이 발생하면 HTTP 상태코드를 400으로 처리하고 싶다. 어떻게 해야할까?



**ApiExceptionController - 수정**

```java
@GetMapping("/api/members/{id}")
public MemberDto getMember(@PathVariable("id") String id) {
 
  if (id.equals("ex")) {
    throw new RuntimeException("잘못된 사용자");
  }
 	if (id.equals("bad")) {
 		throw new IllegalArgumentException("잘못된 입력 값");
 	}
 
  return new MemberDto(id, "hello " + id);
}
```

http://localhost:8080/api/members/bad 라고 호출하면 `IllegalArgumentException` 이 발생하도록 했다.



**실행해보면 상태코드가 500인 것을 확인할 수 있다.**

```java
{
 "status": 500,
 "error": "Internal Server Error",
 "exception": "java.lang.IllegalArgumentException",
 "path": "/api/members/bad"
}
```



**HandlerExceptionResolver**

스프링 MVC는 컨트롤러(핸들러) 밖으로 예외가 던져진 경우 예외를 해결하고, 동작을 새로 정의할 수 있는 방법을 제공한다. 컨트롤러 밖으로 던져진 예외를 해결하고, 동작 방식을 변경하고 싶으면 `HandlerExceptionResolver` 를 사용하면 된다. 줄여서 `ExceptionResolver` 라 한다.



**ExceptionResolver 적용 전**

![스크린샷 2022-03-23 오후 2.04.12](../md-images/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202022-03-23%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%202.04.12.png)



**ExceptionResolver 적용 후**

![스크린샷 2022-03-23 오후 2.04.27](../md-images/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202022-03-23%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%202.04.27.png)

참고: `ExceptionResolver` 로 예외를 해결해도 `postHandle()` 은 호출되지 않는다.



**HandlerExceptionResolver - 인터페이스**

```java
public interface HandlerExceptionResolver {
 ModelAndView resolveException(
 HttpServletRequest request, HttpServletResponse response,
 Object handler, Exception ex);
}
```

* `handler` : 핸들러(컨트롤러) 정보
* `Exception ex` : 핸들러(컨트롤러) 에서 발생한 예외



**MyHandlerExceptionResolver**

```java
package hello.exception.resolver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {
  
  @Override
 	public ModelAndView resolveException(HttpServletRequest request,
HttpServletResponse response, Object handler, Exception ex) {
    
    try {
      if (ex instanceof IllegalArgumentException) {
        log.info("IllegalArgumentException resolver to 400");
 				response.sendError(HttpServletResponse.SC_BAD_REQUEST,
ex.getMessage());
        
        return new ModelAndView();
      }
    } catch (IOException e) {
      log.error("resolver ex", e);
    }
 
    return null;
  }
}

```

* `ExceotuibResolver` 가 `ModelAndView` 를 반환하는 이유는 마치 try, catch를 하듯이, `Exception`을 처리해서 정상 흐름처럼 변경하는 것이 목적이다. 이름 그대로 `Exception`을 Resolver(해결)하는 것이 목적이다.

  여기서는 `IllegalArgumentException`이 발생하면 `response.sendError(400)`를 호출해서 HTTP 상태 코드를 400으로 지정하고, 빈 `ModelAndView`를 반환한다.



**반환 값에 따른 동작 방식**

`HandlerExceptionResolver` 의 반환 값에 따른 `DispatcherServlet` 의 동작 방식은 다음과 같다.

* 빈 ModelAndView: `new ModelAndView()` 처럼 빈 `ModelAndView` 를 반환하면 뷰를 렌더링 하지않고, 정상 흐름으로 서블릿ㅇ ㅣ리턴된다.
* **ModelAndView 지정** : `ModelAndView`에 `View`, `Model` 등의 정보를 지정해서 반환하면 뷰를 렌더링 한다.
* **null** : `null` 을 반환하면, 다음 `ExceptionResolver`를 찾아서 실행한다. 만약 처리할 수 있는 `ExceptionResolver`가 없으면 예외 처리가 안되고, 기본에 발생한 예외를 서블릿 밖으로 던진다.



**ExceptionResolver 활용**

* 예외 상태 코드 변환
  * 예외를 `response.sendError(xxx)` 호출로 변경해서 서블릿에서 상태코드에 따른 오류를 처리하도록 위임
  * 이후 WAS는 서블릿 오류 페이지를 찾아서 내부 호출, 예을 들어서 스프링 부트가 기본으로 설정한 `/error`가 호출됨
* 뷰 템플릿 처리
  * `ModelAndView` 에 값을 채워서 예외에 따른 새로운 오류 화면 뷰 렌더링 해서 고객에게 제공
* API 응답 처리
  * `response.getWriter().println("hello");` 처럼 HTTP 응답 바디에 직접 데이터를 넣어주는 것도 가능하다. 여기에 JSON으로 응답하면 API 응답 처리를 할 수 있다.



**WebConfig - 수정**

`WebMvcConfigurer` 를 통해 등록

```java
/**
 * 기본 설정을 유지하면서 추가
 */
@Override
public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver>
resolvers) {
 resolvers.add(new MyHandlerExceptionResolver());
}
```

`configureHandlerExceptionResolvers(..)` 를 사용하면 스프링이 기본으로 등록하는 `ExceptionResolver` 가 제거되므로 주의, `extendHandlerExceptionResolvers` 를 사용하자.



**Postman으로 실행**

* http://localhost:8080/api/members/ex HTTP 상태 코드 500 
* http://localhost:8080/api/members/bad HTTP 상태 코드 400