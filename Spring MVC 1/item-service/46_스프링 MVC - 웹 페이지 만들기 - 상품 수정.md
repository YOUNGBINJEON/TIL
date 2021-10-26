# 스프링 MVC - 웹 페이지 만들기 - 상품 수정

#### 상품 수정 폼 컨트롤러

**BasicItemController에 추가**

```java
@GetMapping("/{itemId}/edit")
public String editForm(@PathVariable Long itemId, Model model) {
  Item item = itemRepository.findById(itemId);
  model.addAttribute("item", item);
 	return "basic/editForm";
}
```

수정에 필요한 정보를 조회하고, 수정용 폼 뷰를 호출한다.



**상품 수정 폼 뷰**

정적 HTML을 뷰 템플릿(templates) 영역으로 복사하고 다음과 같이 수정하자.

`/resources/static/editForm.html` -> 복사 -> `/resources/templates/basic/editForm.html`



`/resources/templates/basic/editForm.html`

```html
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
  <meta charset="utf-8">
  <link href="../css/bootstrap.min.css"
        th:href="@{/css/bootstrap.min.css}" rel="stylesheet">
  <style>
    .container {
      max-width: 560px;
    }
  </style>
  </head>
  <body>
    <div class="container">
      <div class="py-5 text-center">
        <h2>상품 수정 폼</h2>
      </div>
      <form action="item.html" th:action method="post">
        <div>
          <label for="id">상품 ID</label>
          <input type="text" id="id" name="id" class="form-control"
                 value="1" th:value="${item.id}" readonly>
        </div>
        <div>
          <label for="itemName">상품명</label>
          <input type="text" id="itemName" name="itemName"
                 class="formcontrol" value="상품A"
                 th:value="${item.itemName}">
        </div>
        <div>
          <label for="price">가격</label>
          <input type="text" id="price" name="price" class="form-control"
                 th:value="${item.price}">
        </div>
        <div>
          <label for="quantity">수량</label>
          <input type="text" id="quantity" name="quantity"
                 class="formcontrol" th:value="${item.quantity}">
        </div>
        <hr class="my-4">
        <div class="row">
          <div class="col">
            <button class="w-100 btn btn-primary btn-lg" type="submit">저장
            </button>
          </div>
          <div class="col">
            <button class="w-100 btn btn-secondary btn-lg"
                    onclick="location.href='item.html'"
                    th:onclick="|location.href='@{/basic/items/{itemId}
                                (itemId=${item.id})}'|"
                    type="button">취소</button>
          </div>
        </div>
      </form>
        </div> <!-- /container -->
  </body>
</html>
```

상품 수정 폼은 상품 등록과 유사하고, 특별한 내용이 없다.



**상품수정 개발** 

```java
@PostMapping("/{itemId}/edit")
public String edit(@PathVariable Long itemId, @ModelAttribute Item item) {
  itemRepository.update(itemId, item);
  return "redirect:/basic/items/{itemId}";
}
```

상품 수정은 상품 등록과 전체 프로세스가 유사하다.

* GET `/items/{itemId}/edit` : 상품 수정 폼
* POST `/items/{itemId}/edit` : 상품 수정 처리



**리다이렉트**

상품 수정은 마지막에 뷰 템플릿을 호출하는 대신에 상품 상세 화면으로 이동하도록 리다이렉트를 호출한다.

* 스프링은 `redirect:/...` 으로 편리하게 리다이렉트를 지원한다.
* `redirect:/basic/items/{itemId}`
  * 컨트롤러에 매핑된 `@PathVariable`의 값은 `redirect 에도 사용할 수 있다.
  * `Rdirect:/basic/items/{itemId}` -> `{itemId}` 는 `@PathVariable Long itemId`의 값을 그대로 사용한다.

> **참고 1**
>
> 리다이렉트에 대한 자세한 내용은 모든 개발자를 위한 HTTP 웹 기본 지식 강의 참고



> **참고 2**
>
> HTML Form 전송은 PUT, PATCH 를 지원하지 않는다. GET, POST만 사용할 수 있다.
>
> PUT, PATCH는 HTTP API 전송시에 사용
>
> 스프링에서 HTTP POST로 Form 요철할 때 히든 필드를 통해서 PUT, PATCH 매핑을 사용하는 방법이 있지만, HTTP 요청상 POST 요청이다.