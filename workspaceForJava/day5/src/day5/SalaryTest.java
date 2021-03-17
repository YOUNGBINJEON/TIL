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
 	Employee(int id, String name, int basesalary, int generalFee){ //생성자
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
