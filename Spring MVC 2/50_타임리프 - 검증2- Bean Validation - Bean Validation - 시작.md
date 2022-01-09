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





