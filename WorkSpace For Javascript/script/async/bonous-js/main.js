// number, String, boolean, null, undefined

let number = 2;
let number2 = number;
console.log(number);
console.log(number2);

number2 =3;
console.log(number);
console.log(number2);

//object
let obj = {
  name: 'ellie',
  age : 5,

};
console.log(obj.name);
let obj2 = obj;
console.log(obj2.name);

obj.name='james';
console.log('====');
console.log(obj.name);
console.log(obj2 .name);


//function
const num = 1;
const num2 = 2;
const result = num+num2;

const num3 = 3;
const num4 = 4;
const result2 = num3+num4;

function add(a,b) {
  return a+b;
}

