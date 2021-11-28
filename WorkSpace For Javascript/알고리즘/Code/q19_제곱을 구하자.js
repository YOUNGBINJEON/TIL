const num = prompt("숫자1과 숫자2를 공백으로 구분하여 입력해주세요.").split(' ');

console.log(parseInt(num[0] ** num[1], 10));

//console.log(Math.pow(parseInt(num[0]), parseInt(num[1])), 10);