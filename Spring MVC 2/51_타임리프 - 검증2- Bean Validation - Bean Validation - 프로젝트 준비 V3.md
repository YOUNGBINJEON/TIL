# 타임리프 - 검증2- Bean Validation - Bean Validation 

## 프로젝트 준비 V3

앞서 만든 기능을 유지하기 위해, 컨트롤러와 템플릿 파일을 복사하자.



**ValidationItemControllerV3 컨트롤러 생성**

* `hello.itemservice.web.validation.ValidationItemControllerV2` 복사

* `hello.itemservice.web.validation.ValidationItemControllerV3` 붙여넣기

* URL 경로 변경 : `validation/v2/` -> `validation/v3/`



**템플릿 파일 복사**

`validation/v2` 디렉토리의 모든 템플릿 파일을 `validation/v3` 디렉토리로 복사

* `/resources/templates/validation/v2/` -> `/resources/templates/validation/v3/`
  * `addForm.html`
  * `editForm.html`
  * `item.html`
  * `items.html`
* `/resources/templates/validation/v3/` 하위 4개 파일 모두 URL 경로 변경 : `validation/v2/` -> `validation/v3/`
  * `addForm.html`
  * `editForm.html`
  * `item.html`
  * `items.html`



**실행**

http://localhost:8080/validation/v3/items

실행 후 웹 브라우저의 URL 이 `validation/v3` 으로 유지되는지 확인하자.