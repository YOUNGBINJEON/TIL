# 09_자바스크립트 100제 - concat을 활용한 출력 방법

## 문제9 : concat을 활용한 출력 방법

다음 소스 코드를 완성하여 날짜와 시간을 출력하시오.

```js
var year = '2021';
var month = '11';
var day = '20';
var hour = '14';
var minute = '30';
var second = '15';

var result = ;// 빈칸을 채워주세요

console.log(result);
```



**출력 화면**

```
2021/11/20 14:30:15
```





## 해답

```js
var year = '2021';
var month = '11';
var day = '20';
var hour = '14';
var minute = '30';
var second = '15';

var result = year.concat("/"+month+"/"+day+" "+hour+":"+minute+":"+second);
//var result = year.concat("/", month, "/", day, " ", hour, ":", minute, ":", second);

console.log(result);
```

* `concat` : concatenate(~을 연결하다) 
  * 메서드를 호출한 배열 뒤에 각 인수를 순서대로 붙여 새로운 배열을 만든다. 인수가 배열이면 그 구성요소가 순서대로 붙고, 배열이 아니면 인수 자체가 붙는다.
  * 구문 : `array.concat([value1[, value2[, ...[, valueN]]]])`







### 결과

**코드**

```js
var year = '2021';
var month = '11';
var day = '20';
var hour = '14';
var minute = '30';
var second = '15';

var result = year.concat("/"+month+"/"+day+" "+hour+":"+minute+":"+second);

console.log(result);
```





**출력 창** 

![스크린샷 2021-11-24 오후 8.37.24](/Users/MisternB/Desktop/TIL/md-images/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202021-11-24%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%208.37.24.png)

