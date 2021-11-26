const n = prompt("3의 배수라면 답변 : 짝!");

if(n%3 == 0 && n != 0) {
  console.log("짝!");
}
else {
  console.log(n);
}