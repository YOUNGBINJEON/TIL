const score = prompt("띄어쓰기로 과목 점수를 입력하세요.").split(' ');

let sum = 0;

for(let i = 0; i<score.length; i++) {
  sum += parseInt(score[i], 10);
}

console.log(Math.floor(sum/score.length));