const num = prompt("구구단 출력하고자하는 숫자를 입력해주세요.");

let result = "";

for(let i = 0; i<9; i++) {
  result += num * (i+1) + " ";
}


console.log(result);
