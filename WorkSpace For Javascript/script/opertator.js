// 1. String concatenation

console.log('my' + ' cat');
console.log('1' + 2);
console.log(`string literals: 1+2 = ${1+2}`);

//2. Numeric operators
console.log(1 + 2); //add
console.log(3 - 2); //substract
console.log(4 / 2); //divide
console.log(1 * 2); //multiply
console.log(5 % 2); //remainder
console.log(2 ** 2); // exponentiation

// 3. Increment and decrement operators
let counter = 2;
const preIncrement = ++counter;

const postIncrement = counter++;

// 4. Assignment operators
let x = 3;
let y = 6;
x +=y; //x = x+y;
x -= y;
x *= y;
x /= y;

// 5. Comparison operators
console.log(10 < 6);
console.log(10 <= 6);
console.log(10 >= 6);
console.log(10 > 6);


// 6. Logical opertors : || && !(not)
const value1 = true;
const value2 = 4 < 2;

// ||, 만약 3가지를 논리연상하게 된다면 첫번째 두번째를 비교하고 결과를 토출하기에 유의해야함
// 3가지 논리연산할 결우 함수를 맨 뒤로 배치하는게 국룰
console.log(`or: ${value1 || value2 || check()}`); //check 함수는 출력안됨

// &&
console.log(`and: ${value1 && value2 && check()}`);
function check() {
  for (let i = 0; i< 10; i++) {
    console.log('😩');
  }
  return true;
}


// 7. Equality

const stringFive = '5';
const numberFive = 5;

// == 는 형태만 같으면 true
console.log(stringFive == numberFive); //true
console.log(stringFive != numberFive); //false

// === 타입까지 고려해서 True 
console.log(stringFive === numberFive); //false
console.log(stringFive !== numberFive); //true


// 8. if, elseif, else
const name = 'coder';
if(name === 'ellie'){

} else if {

} else {

}

// 9. Ternary operator : ?
// 간단한 경우에만 사용한다 3항 논리연산자
console.log(name === 'ellie' ? 'yes' : 'no');


// 10. Switch statement
const browser = 'IE';

switch ( browser) {

}

// 11. Loops
let i =3;
while ( i>0) {

}

// do-while
// 블럭을 실행하고 조건확인
do {

} while(i > 0);

// for loop

for ( i = 3; i> 0; i --) {

}

//반복문 충첩도 가능하니 참고해서 공부하자 




