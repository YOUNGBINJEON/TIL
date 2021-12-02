const planets = {
  수성 : "Mercury", 
  금성 : "Venus", 
  지구 : "Earth", 
  화성 : "Mars", 
  목성 : "Jupiter",
  토성 : "Saturn", 
  천왕성 : "Uranus", 
  해왕성 : "Neptune", 
  Mercury : "수성",
  Venus : "금성", 
  Earth : "지구", 
  Mars : "화성", 
  Jupiter : "목성", 
  Saturn : "토성", 
  Uranus : "천왕성", 
  Neptune : "해왕성"
};

const pName = prompt("행성 이름을 입력하세요.");
console.log(planets[pName]);
