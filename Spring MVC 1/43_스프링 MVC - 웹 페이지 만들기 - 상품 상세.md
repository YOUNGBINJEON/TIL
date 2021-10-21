# 스프링 MVC - 웹 페이지 만들기 - 상품 상세

> 상품 상세 컨트롤러와 뷰를 개발



**BasicItemController에 추가**

```java
@GetMapping("/{itemId}")
public String item(@PathVariable Long itemId, Model model) {
  Item item = itemRepository.findById(itemId);
  model.addAttribute("item", item);
 	return "basic/item";
}
```

`PathVatrible`로 넘어온 상품ID로 상품을 조회하고, 모델에 담아둔다. 그리고 뷰 템플릿을 호출한다.



**상품 상세 뷰**

정적 HTML을 뷰 템플릿(templates) 영역으로 복사하고 다음과 같이 수정

`/resources/static/item.html` -> 복사 -> `/resources/templates/basic/item.html`



`/resources/templates/basic/item.html`

```html
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
  <head>
    <meta charset="utf-8">
    <link href="../css/bootstrap.min.css" th:href="@{/css/bootstrap.min.css}" rel="stylesheet">
    <style>
      .container {
        max-width: 560px;
      }
    </style>
  </head>

  <body>
    <div class="container">
      <div class="py-5 text-center">
        <h2>상품 상세</h2>
      </div>
      
      <div>
        <label for="itemId">상품 ID</label>
        <input type="text" id="itemId" name="itemId" class="form-control" value="1" th:value="${item.id}" readonly>
      </div>
      
      <div>
        <label for="itemName">상품명</label>
        <input type="text" id="itemName" name="itemName" class="form-control" value="상품A" th:value="${item.itemName}" readonly>
      </div>
      
      <div>
        <label for="price">가격</label>
        <input type="text" id="price" name="price" class="form-control" value="10000" th:value="${item.price}" readonly>
      </div>
 
      <div>
        <label for="quantity">수량</label>
        <input type="text" id="quantity" name="quantity" class="form-control" value="10" th:value="${item.quantity}" readonly>
      </div>
      
      <hr class="my-4">
      <div class="row">
        <div class="col">
          <button class="w-100 btn btn-primary btn-lg" onclick="location.href='editForm.html'" th:onclick="|location.href='@{/basic/items/{itemId}/edit (itemId=${item.id})}'|" type="button">상품 수정</button>
        </div>
        <div class="col">
          <button class="w-100 btn btn-secondary btn-lg" onclick="location.href='items.html'" th:onclick="|location.href='@{/basic/items}'|" type="button">목록으로</button>
        </div>
      </div>

    </div> <!-- /container -->

  </body>
</html>

```



**속성 변경 - th:value**

`th:value="${item.id}"`

* 모델에 있는 item 정보를 획들하고 프로퍼티 접근법으로 출력한다.(`item.getId()`)
* `value` 속성을 `th:value` 속성으로 변경한다.



**상품 수정 링크**

* `th:onclick=""|location.href='@{/basic/items/{itemId}/edit(itemId=${item.id})}'|"`



**목록으로 링크**

* `th:onclick="|location.href='@{/basic/items}'|"`