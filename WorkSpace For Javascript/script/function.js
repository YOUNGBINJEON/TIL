// 1. function declaration
// fubction name( param1, param2) {body ... return;}
// one function == one thing
// naming : doSomething, command, verb
//function is object in JS

function printHello() {
  console.log('hello');
}
printHello();

function log(message) {
  console.log();
}
log('Hello@');
log(1234);

// 2. Parameters
//premitive parameters : passed by value
// object parameters: passed by reference
function changeName(obj){
  obj.name = 'coder';
}
const ellie = {name: 'ellie'};
changeName(ellie);
console.log(ellie);

// 3. Default parameters ( add ES6)
function showMessage(message, from = 'unknown'){
  console.log(`${message} by ${from}`);
}
showMessage('hi!');

// 4. Rest parameters (add in ES6)
function printAll(...args) {
  for(let i =0; i< args.length; i++){
    console.log(args[i]);
  }
}
printAll('dreams', 'come', 'ture');

// 5. Local scope
// 스코프란 안쪽에서는 사용가능하나 밖쪽에서는 사용 안됨
// 자식함수은 부모함수 사용가능 부모는 자식함수 사용 불가
let globalMessage = 'global';
function printMessage() {
  let message = 'HELLO';
  console.log(message);
  console.log(globalMessage);
}
printMessage();

// 6. Return a value
function sum(a, b) {
  return a+b;
}
const result = sum(1,2);
console.log(`sum: ${sum(1,2)}`);

//7. Early return, early exit
//good
function upgradeUser(user) {
  if(user.point <= 10) {
    return;
  }
  //long upgrade logic 
}

//bad
function upgradeUser(user) {
  if(user.point > 10) {
    //long upgrade logic
  } 
}

// 1. 함수 표현 Function expression
const print = function () { //익명의 함수
  console.log('print');
};
print();
const printAgain = print;
printAgain();
const sumAgain = sum;
console.log(sumAgain(1, 3)); 

// 2. callback funcrion using finction expression
function randomQuiz(answer, printYes, printNo) {
  if (answer === 'love you') {
    printYes();
  }else{
    printNo();
  }
}
const printYes = function() {
  console.log('yes');
};

const printNo = function print() { // 네임드 함수 
  console.log('no');
};
randomQuiz('wrong', printYes, printNo);
randomQuiz('love you', printYes, printNo);

//Arrow Function
const simplePrint = function () { 
  console.log('simplePrint!');

};
const simplePrint = () => console.log('simplePrint!');
const add = (a, b) => a + b;
const simpleMultiply = (a, b) => {
  //do something more
  return a* b;
};

//IIFE : Immediately Invoked Function Expression
(function hello() {
  console.log('IIFE');
})();


// function calculate()
const calc = function calculate(command, a, b) {
  switch(command) {
    case 'add' :
      return 'a+b';
    case 'substract':
      return 'a-b';
    case 'multiply':
      return a*b;
    case 'remainder':
      return a%b;
    default:
      throw Error('unknown command');
  }
  
} 
calc('add', 2, 3);