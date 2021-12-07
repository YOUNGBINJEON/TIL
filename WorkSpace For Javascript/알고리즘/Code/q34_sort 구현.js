const unsorted = prompt("키를 공백으로 구분하여 입력해주세요.");

let sorted = "";

sorted = (unsorted.split(" ").sort(function(a, b){
  return a - b; // 오름차순
  // return b - a; 내림차순
})).join(" ");

console.log(sorted);

if (unsorted === sorted) {
  console.log("Yes");
}
else {
  console.log("No");
}