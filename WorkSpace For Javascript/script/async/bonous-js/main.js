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
const sum = add(3, 4);

function devide(num1, num2){
  return num1 / num2;
}
function surprise(operator) {
  const result = operator(3, 4);// add(3, 4) 와 같은 기능하는중
  console.log(result);
}
surprise(devide);

// ===========콜백을 활용한 여러 기능 제작
class Counter {
  constructor(runEveryFiveTimes){
    this.counter = 0;
    this.callback=runEveryFiveTimes;;
  }

  increse() {
    this.counter++;
    console.log(this.counter);
    if(this.counter % 5 === 0){
      this.callback && this.callback(this.counter);
    }
  }
}

const cooCounter = new Counter();
function printSomething(num) {
  console.log(`yo! ${num}`);
}
const cooCounter =new Counter(printSomething);
cooCounter.increse();
cooCounter.increse();
cooCounter.increse();
cooCounter.increse();
cooCounter.increse();
