const letter = prompt("영문자를 입력해주세요.");

if(letter === letter.toUpperCase()) {
  console.log("Yes");
}
else{
  console.log("No");
}