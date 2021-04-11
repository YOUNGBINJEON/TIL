'use strict';

//JavaScript is synchronous.(동기적인)
// Execute th code block in order after hoisting
// hoisting : var, funtion declaration
// 호이스팅이란 변수, 함수선언식에 대한 정보를 기억하고 있다가 실행시기도록하는것을 말함
console.log('1');
setTimeout(() => console.log('2'), 1000);
console.log('3');

//synchronous callback
function printImmediately(print) {
  print();
}
printImmediately(() => console.log('hello'));

//Asynchronous callbck

function printWithDelay(print, timeout) {
  setTimeout(print, timeout);
}
printWithDelay(() => console.log('async callback'), 2000);



// Callback Hell example

class UserStorage {
  loginUser(id, password, onSuccess, onError) {
    setTimeout(()=> {
      if (
        (id === 'ellie' && password === 'dream') || 
        (id === 'coder' && password === 'academy')
      ) {
        onSuccess(id)
      } else { 
        onError(new Error('not found'));
      }
    }, 2000);
  }

  getRoles(user, onSuccess, onError) {
    setTimeout(() => {
      if(user ==='ellie') {
        onSuccess({name: 'ellie', role: 'admin'});
      }else {
        onError(new Error('no access'));
      }
    }, 1000);
  }

}

const userStorage =new UserStorage();
const id = prompt('enter your id');
const password = prompt('enter your password');
userStorage.loginUser(
  id, 
  password, 
  user => {
    userStorage.getRoles(
      user,
      userWithRole => {
        alert(`Hello ${userWithRole.name}, you have a ${userWithRole.role} role`);
      },
      error => {
        console.log(error);
      }
    );
  },
  error => {
    console.log(error);
  }
);