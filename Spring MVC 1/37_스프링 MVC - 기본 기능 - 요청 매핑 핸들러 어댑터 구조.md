# 스프링 MVC  기본기능 - 요청 매핑 핸들러 어댑터 구조

그렇다면 HTTP 메시지 컨버터는 스프링 MVC 어디쯤에서 사용되는 것일까?

다음 그림에서는 보이지 않는다.

**SpringMVC 구조**

![스크린샷 2021-10-08 오후 9.53.45](/Users/MisternB/Desktop/TIL/md-images/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202021-10-08%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%209.53.45.png)

모든 비밀은 애노티에션 기반의 컨트롤러, 그러니까 `@RequestMapping`을 처리하는 핸들러 어댑터인 `RequestMappingHandlerAdapter`(요청 매핑 핸들러 어댑터)에 있다.



**RequestMappingHandlerAdapter 동작 방식**

![스크린샷 2021-10-08 오후 9.55.50](/Users/MisternB/Desktop/TIL/md-images/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202021-10-08%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%209.55.50.png)

**ArgumentResolver**

생각해보면 애노테이션 기반의 컨트롤러는 매우 다양한 파라미터를 사용할 수 있었다.

`HttpServletRequest`, `Model` 은 물론이고, `@RequestParam`, `@ModelAttribute`같은 애노테이션 그리고 `@RequestBody`, `HttpEntity` 같은 HTTP 메시지를 처리하는 부분까지 매우 큰 유연함을 보여주었다. 

이렇게 파라미터를 유연하게 처리할 수 있는 이유가 바로 `ArgumentResolver` 덕분이다.

애노테이션 기반 컨트롤러를 처리하는 `RequestMappingHandlerAdapter`는 바로 이 `ArgumentResolver`를 호출해서 컨트롤러(핸들러)가 필요로 하는 다양한 파라미터의 값(객체)을 생성한다. 그리고 이렇게 파라미터의 값이 모두 준비되면 컨트롤러를 호출하면서 값을 넘겨준다.



스프링은 30개가 넘는 `ArgumentResolver`를 기본으로 제공한다.

어떤 종류들이 있는지 살짝 코드로 확인해보자.

> **참고**
>
> 가능한 파라미터 목록은 다음 공식 메뉴얼에서 확인할 수 있다.
>
> https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-ann-arguments



**동작방식**

`ArgumentResolver`의 `supportsParameter()`를 호출해서 해당 파라미터를 지원하는지 체크하고, 지원하면 `resolveArgument()`를 호출해서 실제 객체를 생성한다. 그리고 이렇게 생성된 객체가 컨트롤러 호출시 넘어가는 것이다.

그리고 원한다면 직접 이 인터페이스를 확장해서 원하는 `ArgumentResolver`를 만들 수도 있다.

실제 확장하는 예제는 향후 로그인 처리에서 진행



**ReturnValueHandler**

`HandlerMethodReturnValueHandler`를 줄여서 `ReturnValueHandle` 라 부른다.

`ArgumentResolver`와 비슷한데, 이것은 응답 값을 변환하고 처리한다.

컨트롤러에서 String으로 뷰 이름을 반환해도 동작하는 이유가 바로 `ReturnValueHandler` 덕분이다.

어떤 종류들이 있는지 코드를 확인 해보자.

스프링은 10여개가 넘는 `ReturnValueHandler`를 지원한다.

예)`ModelAndview`, `@ResponseBody`, `HttpEntity`, `String`

> **참고**
>
> 가능한 응답 값 목록은 다음 공식 메뉴얼에서 확인 가능
>
> https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-ann-return-types