'use strict';
// objects
// object = {key : value};

// 1. Literals and properties
const obj1 = {}; //'object literal'
const obj2 = new Object(); //'object constructor'

function print(person) {
  console.log(person.name);
  console.log(person.age);
}

const ellie = { name: 'ellie', age : 4};
print(ellie);
//삭제도 가능
delete ellie.hasJob;
console.log(ellie.hasJob);


// 2. Computer properties(계산된 프로퍼티 )
// key should be always string
console.log(ellie.name);
console.log(ellie['name']); //같은 정보 출력 
ellie['hasJob'] =true;
console.log(ellie.hasJob);

//동적으로 키의 벨류를 받아올때 유용하게 사용
function printValue(obj, key){
  console.log(obj[key]);
}
printValue(ellie, 'name');
printValue(ellie, 'age');


// 3. Property value shorthand

const person1 = {name: 'bob', age: 2 };
const person2 = {name: 'steve', age: 22 };
const person3 = {name: 'dave', age: 23 };
const person4 = new Person('ellie', 27);
console.log(person4);

// 4. Constructor Function
function Person(name, age){
  //this = {};
  this.name = name;
  this.age = age;
  //return this;

}


// 5. in oerator: property existence check (key in obj)
// 해당 키가 오프젝트 안에 있는지 확인 가능
console.log('name' in ellie);
console.log('age' in ellie);
console.log('random' in ellie);
console.log(ellie.random);


// 6. for...in vs for ...of 
// for(key in obj)
for(key in ellie) { //모든 키를 받아서 출력

  console.log(key);
}

//for  ( value of iterable)
const array = [ 1, 2,4,5];
for(value of array){
  console.log(value);
}

// 7. Fun cloning
// Object.assign(dest, [obj1, obj2, obj3 ...])
const user = {name:'ellie', age: '20'};
const user2 = user;
user2.name = 'coder';
console.log(user);

const user4 = Object.assign({}, user);
console.log(user4);

//another example
const fruit1 = {color : 'red'};
const fruit2 = {color : 'green', size: 'big'};
const mixed = Object.assign({}, fruit1, fruit2);
console.log(mixed.color);
console.log(mixed.size);
// greed big 출력됨 왜냐하면 나중에 출력될수록 계속 덮어씌우기 때문에