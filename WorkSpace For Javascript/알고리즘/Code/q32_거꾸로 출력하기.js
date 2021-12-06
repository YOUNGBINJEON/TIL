const nums = prompt("띄어쓰기로 구분하여 숫자를 입력해주세요.");

const arr = nums.split(" ").reverse();

//console.log(arr);

let reverseNums = "";

for(let i = 0; i < arr.length; i++) {
  reverseNums += (arr[i] + " ");
}

console.log(reverseNums);