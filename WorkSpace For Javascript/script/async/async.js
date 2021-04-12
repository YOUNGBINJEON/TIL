'use strict'

//async & await
// 깔끔하게 promise를 사용할 수 있는 스타일

// 1. async
async function fetchUser(){
    //do network request in 10 secs...
    return 'ellie';
  
}

const user = fetchUser();
user.then(console.log);
console.log(user);


// 2. await⭐️

function delay(ms){
  return new Promise(resolvde => setTimeout(resolve, ms));
}

async function getApple(){
  await delay(3000);
  return '🍎';
}

async function getBanana() {
  await delay(3000);
  return '🍌';
}

async function pickFruits() { 
  const applePromise = getApple();
  const bananaPromise = getBanana();
  const apple = await applePromise();
  const banana  = await bananaPromise();
  return `${apple} + ${banana}`;
}
//위 코드를 Promise를 활용해 병렬적으로 사용할 수 있다.
// 하지만 아래 3.번처럼 API사용하는게 정석임
pickFruits().then(console.log);

// 3. useful Promise APIs
function pickAllFruits() {
  return Promise.all([getApple(), getBanana()])
  .then(fruits => fruits.join('+'));
}
pickAllFruits().then(console.log);

function pickOnlyOne() {
  return Promise.race([getApple(), getBanana()]);
}

pickOnlyOne().then(console.log)