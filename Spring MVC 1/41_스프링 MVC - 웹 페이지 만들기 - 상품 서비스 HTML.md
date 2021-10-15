# 스프링 MVC - 웹 페이지 만들기 - 상품 서비스 HTML

>  부트스트랩을 이용해 편리하게 개발해보도록 하자



**부트스트랩**

* 부트스트랩 공식 사이트 : https://getbootstrap.com/
* 부트스트랩을 다운로드 받고 압축을 풀자.
  * 이동 : https://getbootstrap.com/docs/5.0/getting-started/download/
  * Compiled CSS and JS 항목을 다운로드하자
  * 압축을 풀고 `bootstrap.min.css`를 복사해서 다음 폴더에 추가
  * `resources/static/css/bootstrap.min.css`

> **참고**
>
> 부트스트랩(Bootstrap)은 웹사이트를 쉽게 만들 수 있게 도와주는 HTML, CSS, JS 프레임워크이다.  하나의 CSS로 휴대폰, 태블릿, 데스크탑까지 다양한 기기에서 작동한다. 다양한 기능을 제공하여 사용자가 쉽게 웹사이트를 제작, 유지, 보수할 수 있도록 도와준다.



HTML, CSS 파일

* `/resources/static/css/bootstrap.min.css` -> 부트스트랩 다운로드
* `/resources/static/html/items.html` -> 아래 참조
* `/resources/static/html/items.html`
* `/resources/static/html/addForm.html`
* `/resources/static/html/editForm.html`

참고로 `/resources/static` 에 넣어두었기 때문에 스프링부트가 정적 리소스를 제공한다.

* http://localhost:8080/html/items.html

  그런데 정적 리소스여서 해당 파일을 탐색기를 통해 직접 열어도 동작하는 것을 확인할 수 있다.

> **참고**
>
> 이렇게 정적 리소스가 공개되는 `/resources/static` 폴더에 HTML을 넣어두면, 실제 서비스에서도 공개된다. 서비스를 운영한다면 지금처럼 공개할 필요없는 hTML을 두는 것은 주의하자.



**상품 목록 HTML**

`resources/static/html/items.html`

```html
<!DOCTYPE HTML>
<html>
<head>
 <meta charset="utf-8">
 <link href="../css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
  <div class="container" style="max-width: 600px">
    <div class="py-5 text-center">
      <h2>상품 목록</h2>
    </div>
    
    <div class="row">
      <div class="col">
        <button class="btn btn-primary float-end" onclick="location.href='addForm.html'" type="button">상품등록</button>
      </div>
    </div>
    
    <hr class="my-4">
    <div>
      <table class="table">
        <thead>
          <tr>
            <th>ID</th>
            <th>상품명</th>
            <th>가격</th>
            <th>수량</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td><a href="item.html">1</a></td>
            <td><a href="item.html">테스트 상품1</a></td>
            <td>10000</td>
            <td>10</td>
          </tr>
          <tr>
            <td><a href="item.html">2</a></td>
            <td><a href="item.html">테스트 상품2</a></td>
            <td>20000</td>
            <td>20</td>
          </tr>
        </tbody>
      </table>
    </div>
  
  </div> <!-- /container -->
  
  </body>
</html>
```



**상품 상세 HTML**

`resources/static/html/item.html`

```html
<!DOCTYPE HTML>
<html>
<head>
 <meta charset="utf-8">
 <link href="../css/bootstrap.min.css" rel="stylesheet">
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
        <input type="text" id="itemId" name="itemId" class="form-control"
value="1" readonly>
      </div>
      
      <div>
        <label for="itemName">상품명</label>
        <input type="text" id="itemName" name="itemName" class="form-control" value="상품A" readonly>
      </div>
      
      <div>
        <label for="price">가격</label>
        <input type="text" id="price" name="price" class="form-control"
value="10000" readonly>
      </div>
      <div>
        <label for="quantity">수량</label>
        <input type="text" id="quantity" name="quantity" class="form-control" value="10" readonly>
      </div>
      
      <hr class="my-4">
      <div class="row">
        <div class="col">
          <button class="w-100 btn btn-primary btn-lg" onclick="location.href='editForm.html'" type="button">상품 수정</button>
        </div>
        
        <div class="col">
          <button class="w-100 btn btn-secondary btn-lg" onclick="location.href='items.html'" type="button">목록으로</button>
        </div>
      </div>

    </div> <!-- /container -->

  </body>
</html>
```



**상품 등록 폼 HTML**

`resources/static/html/addForm.html`

```html
<!DOCTYPE HTML>
<html>
  <head>
    <meta charset="utf-8">
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <style>
      .container {
        max-width: 560px;
      }
    </style>
      </head>
  <body>
    <div class="container">
      <div class="py-5 text-center">
        <h2>상품 등록 폼</h2>
      </div>
      
      <h4 class="mb-3">상품 입력</h4>
      <form action="item.html" method="post">
        <div>
          <label for="itemName">상품명</label>
          <input type="text" id="itemName" name="itemName" class="formcontrol" placeholder="이름을 입력하세요">
        </div>
        
        <div>
          <label for="price">가격</label>
          <input type="text" id="price" name="price" class="form-control"
placeholder="가격을 입력하세요">
        </div>
        
        <div>
          <label for="quantity">수량</label>
          <input type="text" id="quantity" name="quantity" class="formcontrol" placeholder="수량을 입력하세요">
        </div>
        
        <hr class="my-4">
        <div class="row">
          <div class="col">
            <button class="w-100 btn btn-primary btn-lg" type="submit">상품 등록</button>
          </div>
          
          <div class="col">
            <button class="w-100 btn btn-secondary btn-lg" onclick="location.href='items.html'" type="button">취소</button>
          </div>
        </div>
      </form>
    
    </div> <!-- /container -->
  </body>
</html>
```



**상품 수정 폼 HTML**

`resources/static/html/editForm.html`

```html
<!DOCTYPE HTML>
<html>
  <head>
    <meta charset="utf-8">
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    
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
      <form action="item.html" method="post">
        <div>
          <label for="id">상품 ID</label>
          <input type="text" id="id" name="id" class="form-control" value="1" readonly>
        </div>
        
        <div>
          <label for="itemName">상품명</label>
          <input type="text" id="itemName" name="itemName" class="formcontrol" value="상품A">
        </div>
        
        <div>
          <label for="price">가격</label>
          <input type="text" id="price" name="price" class="form-control"
value="10000">
        </div>
        
        <div>
          <label for="quantity">수량</label>
          <input type="text" id="quantity" name="quantity" class="formcontrol" value="10">
        </div>
        
        <hr class="my-4">
        <div class="row">
          <div class="col">
            <button class="w-100 btn btn-primary btn-lg" type="submit">저장 </button>
          </div>
          
          <div class="col">
            <button class="w-100 btn btn-secondary btn-lg" onclick="location.href='item.html'" type="button">취소</button>
          </div>
        </div>
      </form>

    </div> <!-- /container -->
  </body>
</html>
```

