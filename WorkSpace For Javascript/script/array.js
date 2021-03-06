'use strict'

// Arrayπ€

//1. Declaration
const arr1 = new Array();
const arr2 = [1, 2];

// 2. Index position
const fruits = ['π', 'πββοΈ'];
console.log(fruits);
console.log(fruits.length);
console.log(fruits[0]);
console.log(fruits[1]);
// λ°°μ΄μ λ§¨ λ§μ§λ§ μΆλ ₯ 
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
// 1μ€λ‘ μμ±ν ν¬μ΄μΉλ¬Έ
fruits.forEach((fruit) => console.log(fruit));

// 4. Addtion, deletion, copy
//push : add an item to the end
fruits.push('π£ββοΈ', 'π΅');
console.log(fruits);

//pop : remove an item from the end
fruits.pop();
fruits.pop();
console.log(fruits);

// unshift: add an item to the benigging
// μμμλΆν° μ½μ
fruits.unshift('π', 'π');
console.log(fruits);

//shift : remove an item from the benigging
fruits.shift();
fruits.shift();
console.log(fruits)
// NOTE!! μ¬ννΈμ μΈμ¬ννΈλ νΈμ¬, νλ³΄λ€ λλ¦¬λ€
// λλλ‘ νΈμ¬ νμ μ¬μ©νμ
// splice : remove an item by ind position
fruits.push('π', 'π»', 'π');
console.log(fruits);
fruits.splice(1, 2); //1λ² μΈλ±μ€ λΆν° 2κ° μ­μ  
console.log(fruits);
fruits.splice(1, 1, 'π', 'β­οΈ'); // 1λ² μΈλ±μ€μμ 1κ° μ§μ°κ³  λλ¨Έμ§ λκ° μΆκ°
console.log(fruits);

// combine two arrays
// λ€λ₯Έ λ°°μ΄κ³Ό ν©μΉλ λ°©λ² 
const fruits2= ['βοΈ', 'β'];
const newFruits = fruits.concat(fruits2);
console.log(newFruits);


// 5. Searching
// find the index
console.clear();
console.log(fruits);
console.log(fruits.indexOf('β­οΈ'));
console.log(fruits.indexOf('π'));//ν΄λΉνλ κ°μ΄ μμΌλ©΄ -1 μΆλ ₯
// λ°°μ΄μ ν¬ν¨λμλμ§ T, F λ‘ μΆλ ₯
console.log(fruits.includes('π'));
console.log(fruits.includes('π'));

//lastIndexOf
//λ°°μ΄ λ€μμλΆν° κ²μνμ¬ λ°°μ΄ μμ μμμ λͺλ²μ§ΈμΈμ§ 
console.log(fruits.lastIndexOf('π')); 
// IndexOf
//λ°°μ΄ μμμλΆν° κ²μνμ¬ λ°°μ΄ μμ μμμ λͺλ²μ§ΈμΈμ§ 
console.log(fruits.lastIndexOf('π')); 