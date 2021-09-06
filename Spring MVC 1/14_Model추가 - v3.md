# Model 추가 - v3

> 서블릿 종속성 제거
>
> 뷰 이름 중복 제거

**서블릿 종속성 제거**

컨트롤러 입장에서 HttpServletRequest, HttpServletResponse이 꼭 필요한가 의문

요청 파라미터 정보는 자바의 Map으로 대신 넘기도록 하면 지금 구조에서는 컨트롤러가 서블릿 기술을 몰라도 동작할 수 있다.

그리고 request 객체를 Model로 사용하는 대신에 별도의 Model 객체를 만들어서 반환하면 된다.

우리가 구현하는 컨트롤러가 서블릿 기술을 전혀 사용하지 않도록 변경

이렇게 하면 구현 코드도 매우 단순해지고, 테스트 코드 작성도 쉬워진다.



**뷰 이름 중복 제거** 

컨트롤러에서 지정하는 뷰 이름에 중복이 있은 것을 확인할 수 있다.

컨트롤러는 뷰의 논리 이름을 반환하고, 실제 물리 위치의 이름은 프론트 컨트롤러에서 처리하도록 단순화 하자.

이렇게 해두면 향후 뷰의 폴더 위치가 함께 이동해도 프론트 컨트롤러만 고치면 된다.

`/WEB-INF/views/new-form.jsp` -> **new-form** 

`/WEB-INF/views/save-result.jsp` ->  **save-result** 

`/WEB-INF/views/members.jsp` -> **members**



## V3 구조

![스크린샷 2021-09-04 오후 11.44.25](https://github.com/YOUNGBINJEON/TIL/blob/fc706dfa934bfe3dde582d2fbd42b17da5864f6b/md-images/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-09-04%20%EC%98%A4%ED%9B%84%2011.44.25.png)

