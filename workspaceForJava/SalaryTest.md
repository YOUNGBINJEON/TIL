#  급여계산기

> 직원 직급별 급여 계산을 통해 클래스와 상속에 대한 실습을 진행하도록 하자

## 과제 목표

-상속과 오버라이딩을 이용하여 
각 직종의 회사원들의 급여를 계산하시오.
super
형변환

```java
회사원(Employee class){
 	- 멤버변수 선언
 	   사번 이름 본봉 일반수당 총급여
 	- 생성자 정의(main참고)
 	e[0] = new Employee(1000,"이사원",10000,5000);
 	(총급여 제외한) 
        매개변수 4개의 값을 멤버변수 값으로  초기화.
 
 	- 급여 계산메서드(): {
 	   총급여 = 본봉 + 일반수당 
  }
}
```

```java
부직(Manager class) : 상속
	- 변수 선언(자동포함 제외 추가 변수 선언)
 	   이름 사번 본봉 일반수당 총급여
	  간부수당
	- 생성자 정의
 	Manager(2000,"김간부",20000,10000,10000);
        (Manager 생성자 내부 첫문장 super() ; 정의
         Employee() 생성자 호출)


- 급여 계산메서드() {
 	   총급여 = 본봉 + 일반수당+간부수당  
 }	
```

```java
기술직(Engineer class):상속 {
 - 변수 선언
 	   이름 사번 본봉 일반수당 총급여
 	 자격수당 기술수당 
 	- 생성자 정의:main
 	
 - 급여 계산메서드() {
 	   총급여 = 본봉 + 일반수당+자격수당+기술수당
  }
}
```

```java
비서직(Secretary class) :상속
	- 변수 선언
 	   이름 사번 본봉 일반수당 총급여
	  비서수당 
	- 생성자 정의
 	
	- 급여 계산메서드()
 	   총급여 = 본봉 + 일반수당+비서수당 
```

## 메인문

	
	class SalaryTest{
	public static void main(String args[]){
	Employee e [] = new Employee[4];
	// 1.상속 2.생성자(타입 순서 갯수....)
	e[0] = new Employee
	(1000,"이사원",10000,5000);
	e[1] = new Manager
	(2000,"김간부",20000,10000,10000);
	e[2] = new Engineer
	(3000,"박기술",15000,7500,5000,5000);
	e[3] = new Secretary
	(4000,"최비서",15000,7000,10000);
	
	 //배열 내의 각 객체의 급여계산메소드 호출하고 사번, 이름, 총급여 출력
	 }
	}

## 출력물

```java
사번:이름:본봉:총급여
1000:이사원:10000:xxxxx
2000:김간부:20000:xxxxx
3000:박기술:15000:xxxxx
4000:최비서:15000:xxxxx
```

## 결과물

```java
package day5;

class Employee {
	int id;
	String name;
	int basesalary;
	int generalFee;
	int totalSalary;
	
	
	//소스- 제너레이트 컨스트럭터 유징필드로 자동생성 가능.	
public Employee(int id, String name, int basesalary, int generalFee) { 
		//super(); 없어도 그만
		this.id = id;
		this.name = name;
		this.basesalary = basesalary;
		this.generalFee = generalFee;
	}
  

/*	
 	Employee(int id, String name, int basesalary, int generalFee){ //생성자 직접 작성
		this.id = id;
		this.name = name;
		this.basesalary = basesalary;
		this.generalFee = generalFee;
		
	}
*/	
	public void calcTotalSalatry() {
		this.totalSalary = this.basesalary + this.generalFee;
	}
	
}


class Manager extends Employee {
	int manFee;
	Manager(int id, String name, int basesalary, int generalFee, int manFee){
		//super(); 자동정의 ㄷEmployee() 생성자 호출
		super(id, name, basesalary, generalFee); //아래4문장을 한줄로 함축시켜준다 
		//super.id = id;
		//super.name = name;
		//super.basesalary = basesalary;
		//super.generalFee = genderalFee;
		this.manFee = manFee;
	}
  
  
	@Override
	public void calcTotalSalatry() { //급여계산 메소드 정의 
		//totalSalary = basesalary +generalFee + manFee;
		super.calcTotalSalatry();//this.totalSalary = this.basesalary + this.generalFee;
		totalSalary += manFee;
	}
		
}


class Engineer extends Employee {
	int certiFee;
	int techFee;
	Engineer(int id, String name, int basesalary, int generalFee, int certiFee, int techFee ) {
		super(id, name, basesalary, generalFee);
		this.certiFee = certiFee;
		this.techFee = techFee;
	}
  
	@Override
	public void calcTotalSalatry() {
		super.calcTotalSalatry();
		totalSalary = certiFee + techFee;
	}

}

class Secretary extends Employee {
	int secFee;
	public Secretary(int id, String name, int basesalary, int generalFee, int secFee) {
		super(id, name, basesalary, generalFee);
		this.secFee = secFee;
		
	}
  
	@Override
	public void calcTotalSalatry() {
		super.calcTotalSalatry();
		totalSalary += secFee;
	}	
  
}


public class SalaryTest {

	public static void main(String[] args) {
		Employee e [] = new Employee[4];
		// 1.상속 2.생성자(타입 순서 갯수....)
		e[0] = new Employee
		(1000,"이사원",10000,5000);
		e[1] = new Manager
		(2000,"김간부",20000,10000,10000);
		e[2] = new Engineer
		(3000,"박기술",15000,7500,5000,5000);
		e[3] = new Secretary
		(4000,"최비서",15000,7000,10000);
		
		System.out.println("사번 : 이름 : 본봉 : 총급여");
		for(int i = 0; i < e.length; i++) {
			e[i].calcTotalSalatry();
			System.out.println(e[i].id + " : " + e[i].name + " : " + e[i].basesalary + " : " + e[i].totalSalary );
			if(e[i] instanceof Engineer) { //엔지니어를 걸러내는거 
				//Engineer en = (Engineer)e[i];
				System.out.println(((Engineer)e[i]).certiFee + " : " + ((Engineer)e[i]).techFee);
				
			}
		
		}
		
	}

}

```

