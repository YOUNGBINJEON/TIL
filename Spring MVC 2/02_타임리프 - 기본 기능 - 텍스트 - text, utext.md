# 타임리프 - 기본기능 - 텍스트 - text, utext



> 타임리프의 가장 기본 기능인 텍스트를 출력하는 기능을 먼저 알아보자.



타임리프는 기본적으로 HTML 태그의 속성에 기능을 정의해서 동작한다. HTML의 콘텐츠(content)에 데이터를 출력할 때는 다음과 같이 `th:text`를 사용하면 된다.

`<span th:text="${data}">`



HTML 태그의 속성이 아니라 HTML 콘텐츠 영역안에서 직접 데이터를 출력하고 싶으면 다음과 같이 `[[...]]`를 사용하면 된다.

`콘텐츠 안에서 직접 출력하기 = [[${data}]]`



**BasicController**

```java
package hello.thymeleaf.basic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/basic")
public class BasicController {
  
  @GetMapping("/text-basic")
 	public String textBasic(Model model) {
    model.addAttribute("data", "Hello Spring!");
 		return "basic/text-basic";
  }
}
```



`/resources/templates/basic/text-basic.html`

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
</html><head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>

<body>
  <h1>컨텐츠에 데이터 출력하기</h1>
  <ul>
    <li>th:text 사용 <span th:text="${data}"></span></li>
    <li>컨텐츠 안에서 직접 출력하기 = [[${data}]]</li>
  </ul>  
</body>
</html>
```

**실행**

* http://localhost:8080/basic/text-basic





### Escape

> HTML 문서는 `<`, `>` 같은 특수 문자를 기반으로 정의된다. 따라서 뷰 템플릿으로 HTML 화면을 생성할 때는 출력하는 데이터에 이러한 특수 문자가 있는 것을 주의해서 사용해야 한다.
>
> 앞에서 만든 예제의 데이터를 다음과 같이 변경해서 실행해보자.



**변경 전**

`"Hello Spring!"`



**변경 후** 

`"Hello <b>Spring!</b>"`

`<b>` 태그를 사용해서 **Spring!** 이라는 단어가 진하게 나오도록 해보자.



웹 브라우저에서 실행 결과를 보자.

*  웹 브라우저 : `Hello <b>Spring!</b>`
* 소스 보기 : `Hello &lt;b&gt;Spring!&lt;/b&gt;`

개발자가 의도한 것은 `<b>`가 있으면 해당 부분을 강조하는 것이 목적이었다. 그런데 `<b>` 태그가 그대로 나온다.

소스보기를 하면 `<` 부분이 `&lt;`로 변경된 것을 확인할 수 있다.



**HTML 엔티티**

웹 브라우저는 `<`를 HTML 태그의 시작으로 인식한다. 따라서 `<` 태그의 시작이 아니라 문자로 표현할 수 있는 방법이 플요한데, 이것을 HTML 엔티티라 한다. 그리고 이렇게 HTML 에서 사용하는 특수 문자를 HTML 엔티티로 변경하는 것을 이스케이프(escape)라 한다. 그리고 타임리프가 제공하는 `th:text`, `[[...]]`는 **기본적으로 이스케이프(escape)를 제공**한다.

타임리프는 다음 두 기능을 제공한다.

* `th:text` -> `th:utext`
* `[[...]]` -> `[(...)]`



**BasicController에 추가**

```java
@GetMapping("/text-unescaped")
public String textUnescaped(Model model) {
  model.addAttribute("data", "Hello <b>Spring!</b>");
  return "basic/text-unescaped";
}
```

`/resources/templates/basic/text-unescape.html`

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
  <head>
    <meta charset="UTF-8">
    <title>Title</title>
  </head>
<body>
  <h1>text vs utext</h1>
  <ul>
    <li>th:text = <span th:text="${data}"></span></li>
 		<li>th:utext = <span th:utext="${data}"></span></li>
  </ul>
  <h1><span th:inline="none">[[...]] vs [(...)]</span></h1>
  <ul>
    <li><span th:inline="none">[[...]] = </span>[[${data}]]</li>
    <li><span th:inline="none">[(...)] = </span>[(${data})]</li>
  </ul>
  </body>
</html>
```

* `th:inline="none"` 타임리프는 `[[...]]` 를 해석하기 때문에, 화면에 `[[...]]` 글자를 보여줄 수 없다. 이 태그 안에서는 타임리프가 해석하지 말라는 옵션이다.



**실행**

* http://localhost:8080/basic/text-unescaped

실행해보면 다음과 같이 정상 수행되는 것을 확인할 수 있다.

* 웹 브라우저 : Hello **Spring!**
* 소스보기 : `Hello <b>Spring!</b>`



> **주의**
>
> 실제 서비스를 개발하다 보면 escape를 사용하지 않아서 HTML이 정상 렌더링 되지 않는 수 많은 문제가 발생한다. escape 를 기본으로 하고, 꼭 필요한 때만 unescape를 사용하자.

