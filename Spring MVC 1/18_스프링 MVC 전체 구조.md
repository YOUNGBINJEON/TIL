# 스프링 MVC의 전체 구조

**직접 만든 MVC 프레임 워크 구조**

![스크린샷 2021-09-06 오후 11.19.49](../md-images/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202021-09-06%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%2011.19.49.png)



**SpringMVC 구조**

![스크린샷 2021-09-06 오후 11.20.56](../md-images/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202021-09-06%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%2011.20.56.png)



**직접 만든 프레임워크** => **스프링 MVC 비교** 

* FrontController => DispatcherServlet 
* handlerMappingMap => HandlerMapping 
* MyHandlerAdapter => HandlerAdapter 
* ModelView => ModelAndView 
* viewResolver => ViewResolver
* MyView => View