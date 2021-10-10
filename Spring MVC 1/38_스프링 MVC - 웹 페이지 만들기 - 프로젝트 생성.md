# 스프링 MVC - 웹 페이지 만들기

## 프로젝트 생성

**스프링 부트 스타터 사이트에서 프로젝트 생성**

https://start.spring.io/



* 프로젝트 선택
  * Project: Gradle 
  * Project Language: Java 
  * Spring Boot: 2.5.5
* Project Metadata
  * Group : hello
  * Artifact : **item-service**
  * Name : item-service
  * Package name : **hello.itemservice**
  * Packaging : **Jar(주의!)**
  * Java : 11
* Dependencies : **Spring Web**, **Thymeleaf, Lombok**

**build.gradle**

```
plugins {
 id 'org.springframework.boot' version '2.4.3'
 id 'io.spring.dependency-management' version '1.0.11.RELEASE'
 id 'java'
}

group = 'hello'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '11'

configurations {
 compileOnly {
 extendsFrom annotationProcessor
 }
}

repositories {
 mavenCentral()
}

dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
	implementation 'org.springframework.boot:spring-boot-starter-web'
 	compileOnly 'org.projectlombok:lombok'
 	annotationProcessor 'org.projectlombok:lombok'
 	testImplementation 'org.springframework.boot:spring-boot-starter-test'
}

test {
 useJUnitPlatform()
}
```

* 동작 확인
  * 기본 메인 클래스 실행(`SpringmvcApplication.main()`)
  * http://localhost:8080 호출해서 Whitelabel Errir Page가 나오면 정상 동작



Welcome 페이지 추가

편리하게 사용할 수 있도록 Welcome 페이지를 추가하자.

`/resources/static/index.html`

```html
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
 	<title>Title</title>
</head>

  <body>
    <ul>
      <li>상품 관리
        <ul>
          <li><a href="/basic/items">상품 관리 - 기본</a></li>
        </ul>
      </li>
    </ul>
  </body>
</html>
```

* 동작확인
  * 기본 메인 클래스 실행(`SpringmvcApplication.main()`)
  * http://localhost:8080 호출해서 Welcome 페이지가 나오면 성공



 