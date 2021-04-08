'use strict'

// Array🤔

//1. Declaration
const arr1 = new Array();
const arr2 = [1, 2];

// 2. Index position
const fruits = ['👍', '🏄‍♀️'];
console.log(fruits);
console.log(fruits.length);
console.log(fruits[0]);
console.log(fruits[1]);
// 배열의 맨 마지막 출력 
console.log(fruits[fruits.length - 1 ]);

// 3. Looping over an array
// a. for
for(let i in fruits){
  console.log(fruits[i]);
}

// b. for of
for(let i of fruits){
  console.log(fruits);
}

// c. forEach
fruits.forEach(function(fruit, index, array){
  console.log(fruit, index, array);
})
// 1줄로 작성한 포이치문
fruits.forEach((fruit) => console.log(fruit));

// 4. Addtion, deletion, copy
//push : add an item to the end
fruits.push('🚣‍♀️', '🏵');
console.log(fruits);

//pop : remove an item from the end
fruits.pop();
fruits.pop();
console.log(fruits);

// unshift: add an item to the benigging
// 앞에서부터 삽입
fruits.unshift('🍏', '🌝');
console.log(fruits);

//shift : remove an item from the benigging
fruits.shift();
fruits.shift();
console.log(fruits)
// NOTE!! 쉬프트와 언쉬프트는 푸쉬, 팝보다 느리다
// 되도록 푸쉬 팝을 사용하자
// splice : remove an item by ind position
fruits.push('🌎', '🌻', '🍉');
console.log(fruits);
fruits.splice(1, 2); //1번 인덱스 부터 2개 삭제 
console.log(fruits);
fruits.splice(1, 1, '🌊', '⭐️'); // 1번 인덱스에서 1개 지우고 나머지 두개 추가
console.log(fruits);

// combine two arrays
// 다른 배열과 합치는 방법 
const fruits2= ['⛄️', '⛈'];
const newFruits = fruits.concat(fruits2);
console.log(newFruits);


// 5. Searching
// find the index
console.clear();
console.log(fruits);
console.log(fruits.indexOf('⭐️'));
console.log(fruits.indexOf('🍐'));//해당하는 값이 없으면 -1 출력
// 배열에 포함되있는지 T, F 로 출력
console.log(fruits.includes('🍉'));
console.log(fruits.includes('🌊'));

//lastIndexOf
//배열 뒤에서부터 검색하여 배열 시작 앞에서 몇번째인지 
console.log(fruits.lastIndexOf('👍')); 
// IndexOf
//배열 앞에서부터 검색하여 배열 시작 앞에서 몇번째인지 
console.log(fruits.lastIndexOf('🌊')); 