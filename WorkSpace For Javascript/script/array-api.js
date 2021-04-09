// Q1. make a string out of an array
{
  const fruits = ['apple', 'banana', 'orange'];
  const result = fruits.join(''); //() 안에 구분자 설정 가능
  console.log(result);
}

// Q2. make an array out of a string
{
  const fruits = '🍎, 🥝, 🍌, 🍒';
  const result = fruits.split(',');// 구분자 표기 안하면 하나의 배열로 들어감 
  console.log(result);
}

// Q3. make this array look like this: [5, 4, 3, 2, 1]
{
  const array = [1, 2, 3, 4, 5];
  const reverse1 = array.reverse();
  console.log(reverse1);
  console.log(array);// reverse배열 자체를 뒤집는다 
}

// Q4. make new array without the first two elements
{
  const array = [1, 2, 3, 4, 5];
  // splice 는 배열을 새롭게 만드는것이아닌 변형이기에 slice사용해야함
  const slice2 = array.slice(2); 
  console.log(slice2);
}

class Student {
  constructor(name, age, enrolled, score) {
    this.name = name;
    this.age = age;
    this.enrolled = enrolled;
    this.score = score;
  }
}
const students = [
  new Student('A', 29, true, 45),
  new Student('B', 28, false, 80),
  new Student('C', 30, true, 90),
  new Student('D', 40, false, 66),
  new Student('E', 18, true, 88),
];

// Q5. find a student with the score 90
{
  const result = students.find((student) => student.score === 90);
  console.log(result);
}

// Q6. make an array of enrolled students
{
  const result = students.filter((student) => student.enrolled === true);
  console.log(result);
}

// Q7. make an array containing only the students' scores
// result should be: [45, 80, 90, 66, 88]
{
  const result = students.map((student) => student.score);
  console.log(result);
}

// Q8. check if there is a student with the score lower than 50
{
  const result = students.some((student) => student.score < 50);
  console.log(result);
  //배열의 모든 값이 조건을 충족해야 true로 나옴
  const result2 = students.every((student) => student.score < 50);
  console.log(result2);
}

// Q9. compute students' average score
{//(prev, curr) 현재값을 이전값으로 순차적으로 누적
  // reduceright는 거꾸로 누적
  const result = students.reduce((prev, curr) => {
    console.log('--------');
    console.log(prev);
    console.log(curr);
    return prev + curr.score;
  }, 0);
  console.log(result/ students.length);
}

// Q10. make a string containing all the scores
// result should be: '45, 80, 90, 66, 88'
{
  const result = students.map(student => student.score).join();
  console.log(result);
}

// Bonus! do Q10 sorted in ascending order
// result should be: '45, 66, 80, 88, 90'
{
  const result = students.map(student => student.score).sort((a,b) => a-b).join();
  console.log(result);
}