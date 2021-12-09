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
console.log(c(10));
```





















## 해답

* `Math.pow(base, exponent)` : `base` 에  `exponent` 를 제곱한 값을 반환한다.

  * `base` : 밑 값
  * `exponent` : 밑을 제곱하기 위해 사용하는 지수

  



### 결과

**코드**

```js
function one(n) {
  function two(m){
    
    return Math.pow(m, n);
  }
  return two;
}

const a = one(2);
const b = one(3);
const c = one(4);

console.log(a(10));
console.log(b(10));
console.log(c(10));

```







**출력 창** 

![스크린샷 2021-12-09 오후 9.08.09](../../md-images/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202021-12-09%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%209.08.09.png)