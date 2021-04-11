//JSON
// JavaScript Object Notation

// 1. Object to JSON
// stringify(obj)
let json = JSON.stringify(true);
console.log(json);

jons = JSON.stringify(['apple', 'banana']);
console.log(json);

const rabbit = {
  name: 'tori', 
  color: 'white', 
  size: null,
  birthDate: new Date(),

  // 오브젝트에 포함되어있지않기에 표기되지않음 
  jump: () => {
    console.log(`${name} can jump!`);
  },
};

json = JSON.stringify(rabbit);
console.log(rabbit);

json = JSON.stringify(rabbit, ['name', 'color', 'size']);
console.log(json);

//콜백함수를 이용해 디테일한 정보변경 가능
json = JSON.stringify(rabbit, (key, value) =>{
  console.log(`key: ${key}, value: ${value}`);
  return key === 'name' ? 'ellie' : value;
});
console.log(json);


// 2. JSON to Object
// parse(json)
console.clear();
json = JSON.stringify(rabbit);
console.log(json);
const obj=JSON.parse(json, (key, value) => {
  console.log(`key: ${key}, value: ${value}`);
  return key === 'birthDate' ? new Date(value) : value;
});
console.log(obj);
rabbit.jump();

console.log(rabbit.birthDate.getDate());
console.log(obj.birthDate.getDate());