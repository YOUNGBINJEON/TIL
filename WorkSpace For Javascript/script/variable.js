//1. uee struct
// added in ES5
//use this for vanlina Javascript

'use strict';

//2. varicable
//let( added in ES6)

{//블록 안으로 작성하면 블록안에서만 사용가능
    let name = 'Youngbin';
    console.log(name);
    //console.log(globalname);
}

// var 는 사용하면 안된다
// 블럭을 무시하고 사용되기에 오류발견ㅇ ㅣ어려움

//3. const
// 변수를 선언과 동시에 값이 변동이 안된다
// 보안성, 스레드안정서으 사람의 실수를 적게하기 위해서 값의 변동이 없을때 사용
const dayInweek = 7;
const maxNumber = 5;


//4. Variable types;
//자바스크립트는 정수 실수를 선언과 동시에 자동으로 인식함
const count = 16;
const size = 18.1;
console.log(`vaues : ${count}, type : {$typeof count}`);
console.log(`vaues : ${size}, type : {$typeof size}`);

// 실제로  사용가능한 수인지 확인이 필요함
const infinity = 1 / 0;
const negatuveInfinity = -1 /0 ;


//String
const char = 'c';
const brendan = 'breandan';
const greeting = `hello ` + brendan;
console.log(`value : ${greeting}, type : ${typeof  greeting}`);
const helloBob = `hi ${brendan}!`;

// 같은 문장인데 + 기호를 따로 구별안하고 사용하도록 쉽게 문법 작성 가능 
console.log(`value : ${helloBob}, type : ${typeof  helloBob}`);
console.log('value :'+ helloBob + 'type :' + typeof  helloBob);


//boolean
// false : 0 , null , undefined, NaN
// ture : any other value
const canRead = true;
const test = 3 < 1; // false

//null
// 값이 말그대로 비어있는 상태

//undefined
// 선언되어있지만 값이 지정되지않은 상태를 의미

//symbol : 고유한 식별자를 만들때 사용 같은 id라고 작성해도 다르게 판별함
const symbol1 = Symbol('id');
const symbol2 = Symbol('id');
console.log(symbol1 == symbol2); //false
//같은 심볼로 만들고 싶다면 symbol.for 사용 
const symbol3 = Symbol.for('id');
const symbol4 = Symbol.for('id');
console.log(symbol3 == symbol4); // ture 


// 5. Dynamic typing : dunamically  typed language
let text = 'hello';
console.log(`value: ${text}, type: ${typeof text}`);
text = 1;
console.log(`value: ${text}, type: ${typeof text}`);
text = '7' + 5;
console.log(`value: ${text}, type: ${typeof text}`);
text = '8' / '2';
console.log(`value: ${text}, type: ${typeof text}`);




