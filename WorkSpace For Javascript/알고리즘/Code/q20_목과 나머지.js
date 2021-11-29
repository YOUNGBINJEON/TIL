const num = prompt("공백으로 두 숫자를 넣어주세요.").split(' ');

let val1 = Math.floor(parseInt(num[0], 10)/parseInt(num[1], 10));
let val2 = parseInt(num[0], 10) % parseInt(num[1], 10);

console.log(val1, val2);
