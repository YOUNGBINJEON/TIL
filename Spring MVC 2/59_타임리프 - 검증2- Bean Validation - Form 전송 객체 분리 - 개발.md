# 타임리프 - 검증2- Bean Validation - Form 전송 객체 분리 



## 개발

**ITEM 원복**

이제 `Item`의 검증은 사용하지 않으므로 검증 코드를 제거해도 된다.

```java
@Data
public class Item {
 private Long id;
 private String itemName;
 private Integer price;
 private Integer quantity;
}
```



**ItemSaveForm - ITEM 저장용 폼**

```java
package hello.itemservice.web.validation.form;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ItemSaveForm {
 
  @NotBlank
 	private String itemName;
 
  @NotNull
 	@Range(min = 1000, max = 1000000)
 	private Integer price;
 
  @NotNull
 	@Max(value = 9999)
 	private Integer quantity;
}
```

**ItemUpdateForm - ITEM 수정용 폼**

```java
package hello.itemservice.web.validation.form;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ItemUpdateForm {
 	@NotNull
 	private Long id;
 
  @NotBlank
 	private String itemName;
 
  @NotNull
 	@Range(min = 1000, max = 1000000)
 	private Integer price;
 	
  //수정에서는 수량은 자유롭게 변경할 수 있다.
 	private Integer quantity;
}
```



이제 등록, 수정용 폼 객체를 사용하도록 컨트롤러를 수정하자.

**ValidationItemControllerV4**

```java
package hello.itemservice.web.validation;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import hello.itemservice.web.validation.form.ItemSaveForm;
import hello.itemservice.web.validation.form.ItemUpdateForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/validation/v4/items")
@RequiredArgsConstructor
public class ValidationItemControllerV4 {
  private final ItemRepository itemRepository;
 
  @GetMapping
 	public String items(Model model) {
    List<Item> items = itemRepository.findAll();
 		model.addAttribute("items", items);
 		return "validation/v4/items";
  }
 
  @GetMapping("/{itemId}")
 	public String item(@PathVariable long itemId, Model model) {
    Item item = itemRepository.findById(itemId);
		model.addAttribute("item", item);
 		return "validation/v4/item";
  }
 
  @GetMapping("/add")
 	public String addForm(Model model) {
    model.addAttribute("item", new Item());
 		return "validation/v4/addForm";
  }
 
  @PostMapping("/add")
  public String addItem(@Validated @ModelAttribute("item") ItemSaveForm form, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
    //특정 필드 예외가 아닌 전체 예외
 		if (form.getPrice() != null && form.getQuantity() != null) {
      int resultPrice = form.getPrice() * form.getQuantity();
 
      if (resultPrice < 10000) {
        bindingResult.reject("totalPriceMin", new Object[]{10000, resultPrice}, null);
      }
 }
 
    if (bindingResult.hasErrors()) {
      log.info("errors={}", bindingResult);
 			return "validation/v4/addForm";
    }
 
    //성공 로직
    Item item = new Item();
		item.setItemName(form.getItemName());
 		item.setPrice(form.getPrice());
 		item.setQuantity(form.getQuantity());
 		Item savedItem = itemRepository.save(item);
 		redirectAttributes.addAttribute("itemId", savedItem.getId());
 		redirectAttributes.addAttribute("status", true);
 		return "redirect:/validation/v4/items/{itemId}";
  }
 
  @GetMapping("/{itemId}/edit")
 	public String editForm(@PathVariable Long itemId, Model model) {
    Item item = itemRepository.findById(itemId);
 		model.addAttribute("item", item);
 		return "validation/v4/editForm";
  }
 
  @PostMapping("/{itemId}/edit")
  public String edit(@PathVariable Long itemId, @Validated
@ModelAttribute("item") ItemUpdateForm form, BindingResult bindingResult) {
    //특정 필드 예외가 아닌 전체 예외
 		if (form.getPrice() != null && form.getQuantity() != null) {
      int resultPrice = form.getPrice() * form.getQuantity();
 
      if (resultPrice < 10000) {
        bindingResult.reject("totalPriceMin", new Object[]{10000, resultPrice}, null);
      }
    }
 
    if (bindingResult.hasErrors()) {
      log.info("errors={}", bindingResult);
 			return "validation/v4/editForm";
    }
 
    Item itemParam = new Item();
 		itemParam.setItemName(form.getItemName());
 		itemParam.setPrice(form.getPrice());
 		itemParam.setQuantity(form.getQuantity());
 		itemRepository.update(itemId, itemParam);
 		return "redirect:/validation/v4/items/{itemId}";
  }
}
```

* 기존 코드 제거 : `addItem(), addItemV2()`
* 기존 코드 제거 : `edit(), editV2()`
* 추가 : `addItem(), edit()`



**폼 객체 바인딩**

```java
@PostMapping("/add")
public String addItem(@Validated @ModelAttribute("item") ItemSaveForm form,
BindingResult bindingResult, RedirectAttributes redirectAttributes) {
 //...
}
```

`Item` 대신에 `ItemSaveForm` 을 전달 받는다. 그리고 `@Validated`로 검증도 수행하고, `BindingResult` 로 검증 결과도 받는다.



**주의**

`@ModelAttribute("item")` 에 `item` 이름을 넣어준 부분을 주의하자. 이것을 넣지 않으면 `ItemSaveForm`의 경우 규칙에 의해 `itemSaveForm` 이라는 이름으로 MVC Model 에 담기게 된다. 이렇게 되면 뷰 템플릿에서 접근하는 `th:object` 이름도 함께 변경해주어야 한다.



**폼 객체를 Item으로 변환**

```java
//성공 로직
Item item = new Item();
item.setItemName(form.getItemName());
item.setPrice(form.getPrice());
item.setQuantity(form.getQuantity());

Item savedItem = itemRepository.save(item);
```

폼 객체의 데이터를 기반으로 Item 객체를 생성한다. 이렇게 폼 객체처럼 중간에 다른 객체가 추가되면 변환하는 과정이 추가된다.



**수정**

```java
@PostMapping("/{itemId}/edit")
public String edit(@PathVariable Long itemId, @Validated
@ModelAttribute("item") ItemUpdateForm form, BindingResult bindingResult) {
 //...
}
```

수정의 경우도 등록과 같다. 그리고 폼 객체를 Item 객체로 변환하는 과정을 거친다.



**실행**

http://localhost:8080/validation/v4/items



**정리**

Form 전송 객체 분리를 해서 등록과 수정에 딱 맞는 기능을 구성하고, 검증도 명확히 분리했다.