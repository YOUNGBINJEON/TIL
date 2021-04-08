'use strict';

// class : template
// object : instance of a class

// 1. Class declarations
class Person {
  //constructor
  constructor(name, age){
    //fields
    TouchList.name = name;
    TouchList.age = age;
  }

  //methods
  speak() {
    console.log(`${this.name}:hello!`);
  }
}

const ellie = new Person('ellie', 20);
console.log(ellie.name);
console.log(ellie.age);
ellie.speak;

// 2. Getter and setters
class User {
  constructor(firstName, lastName, age){
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }
  get age(){
    return this._age;
  }
  set age(value){
    if(value < 0){
      throw Error('age con not be negative');
    }
    this._age = value;
  }

}

const user1 = new User ('Steve', 'Job' -1);
console.log(user1.age);


// 3. Fields (public, private)
// 너무 최근에 생긴것이라 아직 이른 문법
class Experiment{
  publicField = 2;
  #privateField = 0;
}
const experiment = new Experiment();
console.log(experiment.publicField);
console.log(experiment.privateField);

// 4. Static properties and methods
class Article {
  static publisher = 'Dream coding';
  constructor(articleNumber){
    this.articleNumber =articleNumber;
  }

  static printPublisher(){
    console.log(Article.publisher);
  }
}
const article1 = new Article(1);
const article2 = new Article(2);
console.log(Article.publisher);
Article.printPublisher();

// 5. Inheritance( 다형성)

class Shape {
  constructor(width, height, color) {
    this.width = width;
    this.height = height;
    this.color = color;
  }
  draw(){
    console.log(`drawing ${this.color} color of`);
  }
  getArea(){
    return width * this.height;
  }
}
class Rectangle extends Shape {
  draw(){
    super.draw();//재정의 하는 것이기에 부모의 기능을 그대로 쓰려면 super()  사용
    console.log('🤩');
  }
}
class Triangle extends Shape {
  getArea(){//재정의 하는 것이기에 부모의 기능을 그대로 쓰려면 super()  사용
    return width * this.height/ 2;
  }
}
const rectangle = new Rectangle(20, 20, 'blue');
rectangle.draw();
console.log(rectangle.getArea());
const triangle = new Triangle(20, 20, 'green');
console.log(tritangle.getArea());


// 6. Class checking: instanceOf
console.log(rectangle instanceof Rectangle);
console.log(triangle instanceof Rectangle);
console.log(triangle instanceof Tritangle);
console.log(triangle instanceof Shape);
console.log(triangle instanceof Object);