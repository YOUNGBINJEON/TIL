'use strict';

//Promise is a JavaScrtipt object for asynchromous poeration.
// StateL pending => fulfilled or rejected
// Producer vs Consumer

// 1. Producer
// 불필요한 네트워크 통신이 있기때문에 새로운 프로미스를 생성할때 염두해두자
const promise = new Promise((resolve, reject) => {
  // doing some heavy work( network, read files)
  console.log('doing smething...');
  setTimeout(() => {
    //resolve('ellie');
    reject(new Error('no network'));
  }, 2000);
}); 

// 2. Consumers : then, catch, finally
promise.then((value) => {
  console.log(value);
})
.catch(error => {
  console.log(error);
})
.finally(()=>{
  console.log('finally');
});

// 3. Promise chaining
const fetchNumber = new Promise((resolve, reject) => {
  setTimeout(() => resolve(1), 1000);

});

fetchNumber
.then(num => num*2)// 2
.then(num => num*3)// 6
.then(num => {
  return new Promise((resolve, reject) => {
    setTimeout(()=> resolve(num-1), 1000); // 5
  });
})
.then(num => console.log(num)); // 5


// 4. Error Handling
const getHen = () => 
new Promise((resolve, reject) => {
  setTimeout(()=> resolve('닭'), 1000);
});
const getEgg = hen => 
new Promise((resolve, reject) => {
  setTimeout(()=> resolve(`${hen} => egg`), 1000);
});
const cook = egg => 
new Promise((resolve, reject) => {
  setTimeout(()=> resolve(`${egg} => FRI`), 1000);
});

getHen()
  .then(getEgg)
  .then(cook)
  .then(console.log)
  .catch(console.log);