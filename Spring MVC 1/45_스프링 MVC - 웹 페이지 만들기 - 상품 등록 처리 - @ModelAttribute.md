# 스프링 MVC - 웹 페이지 만들기 - 상품등록 처리 - @ModelAttribute



> 이제 상품 등록 폼에서 전달된 데이터로 실제 상품을 등록 처리해보자.
>
> 상품 등록 폼은 다음 방식으로 서버에 데이터를 전달한다.

* POST - HTML Form
  * `content-type: application/x-www-form-urlencoded`
  * 메시지 바디에 쿼리 파라미터 형식으로 전달 `itemName=itemA&price=10000&quentity=10`
  * 예) 회원 가입, 상품 주문, HTML Form 사용

요청 파라미터 형식으로 처리하므로 `@RequestParam`을 사용하자



#### 상품 등록 처리 - @RequestParam

**addItemV1 - BasicItemController에 추가**

```java
@PostMapping("/add")
public String addItemV1(@RequestParam String itemName,
                        @RequestParam int price,
                        @RequestParam Integer quantity,
                        Model model) {

  Item item = new Item();
 	item.setItemName(itemName);
 	item.setPrice(price);
 	item.setQuantity(quantity);
 	itemRepository.save(item);
 	model.addAttribute("item", item);
 
  return "basic/item";
}
```

* 먼저 `@RequestParam String itemName` : itemName 요청 파라미터 데이터를 해당 변수에 받는다.

* `Item` 객체를 생성하고 `itemRepository`를 통해서 저장한다.

* 저장된 `item`을 모델에 담아서 뷰에 전달한다.

  **중요** : 여기서는 상품 상세에서 사용한 `item.html` 뷰 템플릿을 그대로 재활용한다.

  실행해서 상품이 잘 저장되는지 확인하자.

  

#### 상품 등록 처리 - @ModelAttribute

`@ReqiestParam`으로 변수를 하나하나 받아서 `Item`을 생성하는 과정은 불편하다.

이번에는 `@ModelAttribute`를 사용해서 한번에 처리해보자.



**addItemV2- 상품등록 처리 - ModelAttribute**

```java
/**
 * @ModelAttribute("item") Item item
 * model.addAttribute("item", item); 자동 추가
 */
@PostMapping("/add")
public String addItemV2(@ModelAttribute("item") Item item, Model model) {
  itemRepository.save(item);
 	
  //model.addAttribute("item", item); //자동 추가, 생략 가능
 	return "basic/item";
}
```

**@ModelAttribute - 요청 파라미터 처리**

`@ModelAttribute`는 `Item` 객ㅊ를 생성하고, 요청 파라미터의 값을 프로퍼티 접근법(setXxx)으로 입력해준다.



**@ModelAttribute - Model 추가**

`@ModelAttribute`는 중요한 한가지 기능이 더 있는데, 바로 모델(Model)에 `@ModelAttribute`로 지정한 객체를 자동으로 넣어준다. 지금 코드를 보면 `model.addAttribute("item", item)`가 주석처리 되어 있어도 잘 동작하는 것을 확인할 수 있다.



모델에 데이터를 담을 때는 이름이 필요하다. 이름은 `@ModelAttribute`에 지정한 `name(value)`속성을 사용한다. 만약 다음과 같이 `@ModelAttribute`의 이름을 다르게 지정하면 다른 이름으로 모델에 포함된다.



`@ModelAttribute("hello") Item item` -> 이름을 `hello`로 지정

`model.addAttribute("hello", item);` -> 모델에 `hello`이름으로 저장



**주의**

실행 전에 이전 버전인 `addItemV1`에 `@PostMapping("/add")`를 꼭 주석처리 해주어야 한다. 그렇지 않으면 중복 매핑으로 오류가 발생

```java
//@PostMapping("/add") 이전 코드의 매핑 주석처리!
public String addItemV1(@RequestParam String itemName,
```



**addItemV3 - 상품 등록 처리 - ModelAttribute 이름 생략**

```java
/**
 * @ModelAttribute name 생략 가능
 * model.addAttribute(item); 자동 추가, 생략 가능
 * 생략시 model에 저장되는 name은 클래스명 첫글자만 소문자로 등록 Item -> item
 */
@PostMapping("/add")
public String addItemV3(@ModelAttribute Item item) {
  itemRepository.save(item);
 	
  return "basic/item";
}
```

`@ModelAttribute`의 이름을 생략할 수 있다.



**주의**

`@ModelAttribute`의 이름을 생략하면 모델에 저잘될 때 클래스 명을 사용한다. 이때 **클래스의 첫 글자만 소문자로 변경**해서 등록한다.

* 예) `@ModelAttribute` 클래스명 -> 모델에 자동 추가되는 이름
  * `Item` -> `item`
  * `HelloWorld` -> `helloWorld`



**addItemV4 - 상품 등록 처리 - ModelAttribute 전체 생략** 

```java
/**
 * @ModelAttribute 자체 생략 가능
 * model.addAttribute(item) 자동 추가
 */
@PostMapping("/add")
public String addItemV4(Item item) {
 	itemRepository.save(item);
 
  return "basic/item";
}
```

`@ModelAttribute` 자체도 생략가능하다. 대상 객체는 모델에 자동 등록된다. 나머지 사항은 기존과 동일하다.

