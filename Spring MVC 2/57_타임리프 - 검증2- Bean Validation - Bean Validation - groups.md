# 타임리프 - 검증2- Bean Validation - Bean Validation



## groups

동일한 모델 객체를 등록할 때와 수정할 때 각각 다르게 검증하는 방법을 알아보자.



**방법 2가지**

* BeanValidation의 groups 기능을 사용한다.
* Item을 직접 사용하지 않고, ItemSaveForm, ItemUpdateForm 같은 폼 전송을 위한 별도의 모델 객체를 만들어서 사용한다.



**BeanValidation groups 기능 사용**

이런 문제를 해결하기 위해 Bean Validation은 groups라는 기능을 제공한다.

예를 들어서 등록시에 검즐할 기능과 수정시에 검증할 기능을 각각 그룹으로 나누어 적용할 수 있다.

코드로 확인해보자.



**groups 적용**

**저장용 groups 생성**

```java
package hello.itemservice.domain.item;
public interface SaveCheck {
}
```

**수정용 groups 생성**

```java
package hello.itemservice.domain.item;

public interface UpdateCheck {
  
}
```

**Item - groups 적용**

```java
package hello.itemservice.domain.item;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Item {
 
  @NotNull(groups = UpdateCheck.class) //수정시에만 적용
 	private Long id;
 
  @NotBlank(groups = {SaveCheck.class, UpdateCheck.class})
 	private String itemName;
 
  @NotNull(groups = {SaveCheck.class, UpdateCheck.class})
 	@Range(min = 1000, max = 1000000, groups = {SaveCheck.class,
UpdateCheck.class})
 private Integer price;
 
  @NotNull(groups = {SaveCheck.class, UpdateCheck.class})
 	@Max(value = 9999, groups = SaveCheck.class) //등록시에만 적용
 	private Integer quantity;
 
  public Item() {
 }
 
  public Item(String itemName, Integer price, Integer quantity) {
    this.itemName = itemName;
 		this.price = price;
 		this.quantity = quantity;
  }
}
```



**ValidationItemControllerV3 - 저장 로직에 SaveCheck Groups 적용**

```java
@PostMapping("/add")
public String addItemV2(@Validated(SaveCheck.class) @ModelAttribute Item item,
BindingResult bindingResult, RedirectAttributes redirectAttributes) {
 //...
}
```

* `addItem()` 를 복사해서 `addItemV2()` 생성, `SaveCheck.class` 적용
* 기존 `addItem() @PostMapping("/add")` 주석처리



**ValidationItemControllerV3 - 수정 로직에 UpdateCheck Groups 적용**

```java
@PostMapping("/{itemId}/edit")
public String editV2(@PathVariable Long itemId, @Validated(UpdateCheck.class)
@ModelAttribute Item item, BindingResult bindingResult) {
 //...
}
```

* `edit()` 를 복사해서 `editV2()` 생성, `UpdateCheck.class` 적용
* 기존 `edit() @PostMapping("/PitemId/edit")` 주석처리

> 참고
>
> `@Valid` 에는 groups를 적용할 수 있는 기능이 없다. 따라서 groups를 사용하려면 `@Validated` 를 사용해야 한다.



**실행**

http://localhost:8080/validation/v3/items



**정리**

groups 기능을 사용해서 등록과 수정시에 각각 다르게 검증을 할 수 있었다. 그런데 groups 기능을 사용하니 `Item` 은 물론이고, 전반적으로 복잡도가 올라갔다.

사실 groups 기능은 실제 잘 사용되지는 않는데, 그 이유는 실무에서는 주로 다음에 등장하는 등록용 폼 객체와 수정용 폼 객체를 분리해서 사용하기 때문이다.

