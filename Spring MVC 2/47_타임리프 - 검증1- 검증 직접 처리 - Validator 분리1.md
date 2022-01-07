# 타임리프 - 검증1- 검증 직접 처리 - Validator 분리1

> **목표**
>
> 복잡한 검증 로직을 변도로 분리하자.



컨트롤러에서 검증 로직이 차지하는 부분은 매우 크다. 이런 경우 별도의 클래스로 역할을 분리하는 것이 좋다. 그리고 이렇게 분리한 검증 로직을 재사용 할 수도 있다.

`ItemCalidator` 를 만들자.

```java
package hello.itemservice.web.validation;

import hello.itemservice.domain.item.Item;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ItemValidator implements Validator {
 	@Override
  public boolean supports(Class<?> clazz) {
    return Item.class.isAssignableFrom(clazz);
  }
 
  @Override
  public void validate(Object target, Errors errors) {
    Item item = (Item) target;
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "itemName",
"required");
    
    if (item.getPrice() == null || item.getPrice() < 1000 || item.getPrice() > 1000000) {
      errors.rejectValue("price", "range", new Object[]{1000, 1000000},
null);
    }
 
    if (item.getQuantity() == null || item.getQuantity() > 10000) {
      errors.rejectValue("quantity", "max", new Object[]{9999}, null);
    }
 
    //특정 필드 예외가 아닌 전체 예외
    if (item.getPrice() != null && item.getQuantity() != null) {
      int resultPrice = item.getPrice() * item.getQuantity();
 
      if (resultPrice < 10000) {
        errors.reject("totalPriceMin", new Object[]{10000, resultPrice}, null);
      }
    }
  }
}
```



스프링은 검증을 체계적으로 제공하기 위해 다음 인터페이스를 제공한다.

```java
public interface Validator {
  boolean supports(Class<?> clazz);
  void validate(Object target, Errors errors);
}
```

* `supports() {}` : 해당 검증기를 지원하는 여부 확인(뒤에서 설명)
* `validate(Object target, Errors errors)` : 검증 대상 객체와 `BindingResult` 



**ItemValidator 직접 호출하기**

**ValidationItemControllerV2 - addItemV5()**

```java
private final ItemValidator itemValidator;

@PostMapping("/add")
public String addItemV5(@ModelAttribute Item item, BindingResult bindingResult,RedirectAttributes redirectAttributes) {
 itemValidator.validate(item, bindingResult);
 
 if (bindingResult.hasErrors()) {
 log.info("errors={}", bindingResult);
 return "validation/v2/addForm";
 }
  
 //성공 로직
 Item savedItem = itemRepository.save(item);
 redirectAttributes.addAttribute("itemId", savedItem.getId());
 redirectAttributes.addAttribute("status", true);
 return "redirect:/validation/v2/items/{itemId}";
}
```

**코드변경**

* `addItemV4()` 의 `@PostMapping` 부분 주석 처리 

  `ItemValidator` 를 스프링 빈으로 주입 받아서 직접 호출했다.



**실행**

실행해보면 기존과 완전히 동일하게 동작하는 것을 확인할 수 있다. 검증과 관련된 부분이 깔끔하게 분리되었다.