const array = ["영빈", "불휘", "한울", "한울", "영빈", "불휘", "영빈", "영빈", "한울", "영빈", "영빈"]
let result = {};
let winner = "";

for(let index in array) {
  let val = array[index];
  result[val] = result[val] === undefined ? 1 : result[val] + 1;
}

winner = Object.keys(result).reduce(function(a, b){
  console.log(a, b);
  return result[a] > result[b] ? a : b

});

console.log(winner);
console.log(`${winner}(이)가 총 ${result[winner]}표로 반장이 되었습니다.`);