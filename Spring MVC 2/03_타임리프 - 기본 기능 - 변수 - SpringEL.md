# 타임리프 - 기본기능 - 변수 - SpringEL

> 타임리프에서 변수를 사용할 때는 변수 표현식을 사용한다.



**변수 표현식** : `${...}`

그리고 이 변수 표현식에는 스프링 EL이라는 스프링이 제공하는 표현식을 사용할 수 있다.



**BasicController 추가**

```java
@GetMapping("/variable")
public String variable(Model model) {
  User userA = new User("userA", 10);
 	User userB = new User("userB", 20);
 	
  List<User> list = new ArrayList<>();
 	list.add(userA);
 	list.add(userB);
 	Map<String, User> map = new HashMap<>();
 	map.put("userA", userA);
 	map.put("userB", userB);
 
  model.addAttribute("user", userA);
 	model.addAttribute("users", list);
 	model.addAttribute("userMap", map);
 
  return "basic/variable";
}

@Data
static class User {
  private String username;
 	private int age;
 	
  public User(String username, int age) {
    this.username = username;
 		this.age = age;
  }
}
```



`/resources/templates/basic/variable.html`

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>

  <body>
  <h1>SpringEL 표현식</h1>
    <ul>Object
    <li>${user.username} = <span th:text="${user.username}"></span></li>
    <li>${user['username']} = <span th:text="${user['username']}"></span></li>
    <li>${user.getUsername()} = <span th:text="${user.getUsername()}">  </span></li>
    </ul>
    
    <ul>List
      <li>${users[0].username} = <span th:text="${users[0].username}"></
span></li>
      <li>${users[0]['username']} = <span th:text="${users[0]['username']}"></span></li>
      <li>${users[0].getUsername()} = <span th:text="${users[0].getUsername()}"></span></li>
    </ul>

    <ul>Map
      <li>${userMap['userA'].username} = <span th:text="${userMap['userA'].username}"></span></li>
      <li>${userMap['userA']['username']} = <span th:text="${userMap['userA']['username']}"></span></li>
      <li>${userMap['userA'].getUsername()} = <span th:text="${userMap['userA'].getUsername()}"></span></li>
    </ul>
  </body>
</html>
```

**SpringEL 다양항 표현식 사용**

**Object**

* `user.username` : user 의 username을 프로퍼티 접근 -> `user.getUsername()`
* `user['username']` : 위와 같음 -> `user.getUsername()`
* `user.getUsername()` : user의 `getUsername()` 을 직접 호출



**List**

* `users[0].username` : List에서 첫 번째 회원을 찾고 username 프로퍼티 접근 -> `list.get(0).getUsername()`

* `users[0]['username']` : 위와 같음
* `users[0].getUsername()` : List에서 첫 번째 회원을 찾고 메서드 직접 호출



**Map**

* `userMap['userA'].username` : Map에서 userA를 찾고, username 프로퍼티 접근 ->  `map.get("userA").getUsername()`
* `userMap['userA']['username']` : 위와 같음
* `userMap['userA'].getUsername()` : Map 에서 userA를 찾고 메서드 직접 호출



**실행**

* http://localhost:8080/basic/variable



지역 변수 선언

`th:with`를 사용하면 지역 변수를 선언해서 사용할 수 있다. 지역 변수는 선언한 태그 안에서만 사용할 수있다.



`/resources/templates/basic/variable.html` 추가

```html
<h1>지역 변수 - (th:with)</h1>
<div th:with="first=${users[0]}">
  <p>처음 사람의 이름은 <span th:text="${first.username}"></span></p>
</div>
```

