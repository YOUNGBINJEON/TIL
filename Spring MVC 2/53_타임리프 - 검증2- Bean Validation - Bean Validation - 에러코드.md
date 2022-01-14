# 타임리프 - 검증2- Bean Validation - Bean Validation

## 에러코드

Bean Validation이 기본으로 제공하는 오류 메시지를 좀 더 자세히 변경하고 싶으면 어떻게 하면 될까?

Bean Validation을 적용하고 `bindingResult` 에 등록된 검증 오류 코드를 보자.

오류 코드가 애노테이션 이름으로 등록된다. 마치 `typeMismatch` 와 유사하다.

`NotBlank` 라는 오류 코드를 기반으로 `MessageCodesResolver` 를 통해 다양한 메시지 코드가 순서대로 생성된다.



**@NotBlank**

* NotBlank.item.itemName
* NotBlank.itemName
* NotBlank.java.lan.String
* NotBlank



**@Range**

* Range.item.price
* Range.price
* Range.java.lang.Integer
* Range



메시지 등록

이제 메시지를 등록해보자.

`errors.properties`

```
#Bean Validation 추가
NotBlank={0} 공백X 
Range={0}, {2} ~ {1} 허용
Max={0}, 최대 {1}
```

`{0}` 은 필드명이고, `{1}`, `{2}` ... 은 각 애노테이션마다 다르다.



**실행**

실행해보면 방금 등록한 메시지가 정상 적용되는 것을 확인할 수 있다.



**BeanValidation 메시지 찾는 순서**

1. 생성된 메시지 코드 순서대로 `messageSoucre` 에서 메시지 찾기
2. 애노테이션의 `message` 속성 사용 -> `@NotBlank(message = "공백! {0}")`
3. 라이브러리가 제공하는 기본 값 사용 -> 공백일 수 없습니다.



**애노테이션의 message 사용 예**

```java
@NotBlank(message = "공백은 입력할 수 없습니다.")
private String itemName;
```







