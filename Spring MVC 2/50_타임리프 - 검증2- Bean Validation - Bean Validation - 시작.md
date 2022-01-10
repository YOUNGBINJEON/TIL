# 타임리프 - 검증2- Bean Validation - Bean Validation 

## 시작

Bean Validation 기능을 어떻게 사용하는지 코드로 알아보자. 먼저 스프링과 통합하지 않고, 순수한 Bean  Validation 사용법 부터 테스트 코드로 알아보자



### **Bean Validation 의존관계 추가**

**의존관계 추가**

Bean Validation을 사용하려면 다음 의존관계를 추가해야 한다.

`build.gradle`

```
implementation 'org.springframework.boot:spring-boot-starter-validation'
```

`spring-boot-starter-validation` 의존관계를 추가하면 라이브러리가 추가 된다.

**Jakarta Bean Validation**

`jakarta.validation-api` : Bean Validation 인터페이스

`hibernate-validator` 구현체



### 테스트 코드 작성

**Item - Bean Validation 애노테이션 적용**

```java
package hello.itemservice.domain.item;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Item {
 	private Long id;
  
 	@NotBlank
 	private String itemName;
 
  @NotNull
 	@Range(min = 1000, max = 1000000)
 	private Integer price;
 
  @NotNull
 	@Max(9999)
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

**검증 애노테이션**

`@NotBlank` : 빈값 + 공백만 있는 경우에 허용하지 않는다.

`@NotNull` : `null`을 허용하지 않는다

`@Range(min = 100, max = 1000000)` : 범위 안의 값이어야 한다.

`@Max(9999)` : 최대 9999까지만 허용한다.

> 참고
>
> `javax.validation.contraints.NouNull`
>
> `org.hibernate.validator.contraints.Range`
>
> `javax.validation` 으로 시작하면 특정 구현에 관계없이 제공되는 표준 인터페이스이고, `org.hibernate.validator`로 시작하면 하이버네이트 validator 구현체를 사용할 때만 제공되는 검증 기능이다. 실무에서 대부분 하이버네이트 validator를 사용하므로 자유롭게 사용해도 된다.



**BeanValidationTest - Bean Calidation 테스트 코드 작성**

```java
package hello.itemservice.validation;

import hello.itemservice.domain.item.Item;
import org.junit.jupiter.api.Test;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class BeanValidationTest {
  @Test
 	void beanValidation() {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    
    Item item = new Item();
    item.setItemName(" "); //공백
	 	item.setPrice(0);  
 		item.setQuantity(10000);
 
    Set<ConstraintViolation<Item>> violations = validator.validate(item);
 
    for (ConstraintViolation<Item> violation : violations) {
      System.out.println("violation=" + violation);
 			System.out.println("violation.message=" + violation.getMessage());
    }
  }
}
```

**검증기 생성**

다음 코드와 같이 검증기를 생성한다. 이후 스프링과 통합하면 우리가 직접 이런 코드를 작성하지는 않으므로, 이렇게 사용하는구나 정도만 참고하자.

```java
ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
Validator validator = factory.getValidator();
```



**검증 실행**

검증대상(`item`)을 직접 검증기에 넣고 그 결과를 받는다. `Set`에는 `ConstraintViolation` 이라는 검증 오류가 담긴다. 따라서 결과가 비어있으면 검증 오류가 없는 것이다.

```
Set<ConstraintViolation<Item>> violations = validator.validate(item);
```

실행 결과를 보자.

**실행 결과(일부생략)**

```
violation={interpolatedMessage='공백일 수 없습니다', propertyPath=itemName, 
rootBeanClass=class hello.itemservice.domain.item.Item, 
messageTemplate='{javax.validation.constraints.NotBlank.message}'}
violation.message=공백일 수 없습니다

violation={interpolatedMessage='9999 이하여야 합니다', propertyPath=quantity, 
rootBeanClass=class hello.itemservice.domain.item.Item, 
messageTemplate='{javax.validation.constraints.Max.message}'}
violation.message=9999 이하여야 합니다

violation={interpolatedMessage='1000에서 1000000 사이여야 합니다', 
propertyPath=price, rootBeanClass=class hello.itemservice.domain.item.Item, 
messageTemplate='{org.hibernate.validator.constraints.Range.message}'}
violation.message=1000에서 1000000 사이여야 합니다
```

`ConstraintViolation` 출력 결과를 보면, 검증 오류가 발생한 객체, 필드, 메시지 정보 등 다양한 정보를 확인할 수 있다.



**정리**

이렇게 빈 검증기(Bean Validation)를 직접 사용하는 방법을 알아보았다. 아마 지금까지 배웠던 스프링 MVC 검증 방법에 빈 검증기를 어떻게 적용하면 좋을지 여러가지 생각이 들 것이다. 스프링은 이미 개발자를 위해 빈 검증기를 스프링에 완전히 통합해두었다.







