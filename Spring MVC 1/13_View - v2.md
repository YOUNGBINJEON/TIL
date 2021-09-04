# View 분리 - V2

> 모든 컨트롤러에서 뷰로 이동하는 부분에 중복이 있고, 깔끔하지 않다.
>
> ```java
> String viewPath = "/WEB-INF/views/new-form.jsp";
> RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath); dispatcher.forward(request, response);
> 
> ```
>
> 이 부분을 깔끔하게 분리하기 위해 별도로 뷰를 처리하는 객체를 만든다.



## V2 구조

![스크린샷 2021-09-04 오후 9.34.30](../Desktop/TIL/md-images/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202021-09-04%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%209.34.30.png)



변경, 추가된 코드는 `servlet` 폴더에서 확인