const num = 5;

for (let i=1; i<=num; i++) {  
  let space = '';

  // 공백 증가 
  for (let k=1; k<=num-i; k++) {
    space += ' ';
  }

  // 별 증가
  for (let j=1; j<=i*2-1; j++) {
    space += '*';

  }
  console.log(space);
}