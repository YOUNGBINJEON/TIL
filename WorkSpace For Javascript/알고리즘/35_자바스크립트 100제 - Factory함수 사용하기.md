# 35_자바스크립트 100제 - Factory함수 사용하기

## 문제35 : Factory함수 사용하기

2제곱, 3제곱, 4제곱 할 수 있는 Factory 함수를 만들려고 합니다.

<pass>에 코드를 작성하여 two 함수를 완성하세요.

```js
function one(n) {
  function two(){
    //pass
  }
  return two;
}

const a = one(2);
const b = one(3);
const c = one(4);

console.log(a(10));
console.log(b(10));
console.log(b(10));
```





















## 해답

* `prompt()` 함수를 통해 입력받은 값 `unsorted` 변수에 저장

* 정렬될 값을 저장할 `sorted` 변수 설정

* `sort()` : 배열의 요소를 적절한 위치에 정렬한 후 그 배열을 반환

  * `split(" ")` : 공백을 기준으로 요소를 나눈다
  * `function(a, b) {b-a}` : `unsorted` 요소를 2개씩 비교하여 `sort()` 메소드로 정렬

* `if()` 조건문으로 입력 받은 `unsorted` 요소와  정렬된 `sorted` 값을 비교하여 일치여부 출력

  



### 결과

**코드**

```js
function one(n) {
  function two(){
    //pass
  }
  return two;
}

const a = one(2);
const b = one(3);
const c = one(4);

console.log(a(10));
console.log(b(10));
console.log(b(10));

```







**출력 창** 

