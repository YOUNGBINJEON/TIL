package day8;


@FunctionalInterface
interface Math {
	public int calc(int first, int second);
}
@FunctionalInterface
interface A1 {
	int ma();
}

@FunctionalInterface
interface B {
	int mb(int i);
}

class C1 {
	static int mc1(int i, int j) {return i /j;}
	int mc2(int i, int j ) {return i % j;}
}

public class FuntionalTest {
	String name = "멤버변수";
public static void main(String[] args) {
		Math m = (a, b) -> a*b;
		System.out.println(m.calc(10, 2));
		
		Math m2 = (i, j) -> i -j;
		System.out.println(m2.calc(10, 2));
		
		Math m3 = (i, j) -> i + j;
		System.out.println(m3.calc(10, 2));
		
		Math m4 = (i, j) -> i / j;
		System.out.println(m4.calc(10, 2));
		
		//람다식의 매개변수를 외부클래스 메소드 배개변수 전달하고
		//Math m5 = (i, j) -> C1.mc1(i, j);
		Math m5 = C1::mc1; //방법 1 : 바로 위 코드를 조금더 간결하게 만든 코드
				//클래스명::static메소드명
		//외부클래스 메소드 실행한 결과 리턴 
		System.out.println(m5.calc(10, 2));
		
		//Math m6 = (i, j) -> new C1().mc2(i, j);
		C1 c = new C1();
		Math m6 = c::mc2; //방법 2 
			//객체생성변수명::non-static메소드명
		
		A1 a1 = ()->1;
		System.out.println(a1.ma());
		
		B b1 = (a)->{
			String name = "람다";
			System.out.println("람다식 실행");
			
			//statuc 변수 --> 클래스명.static변수
			//non-static 변수 --> new 클래스명().non-static변수
			System.out.println(new FuntionalTest().name);
			return a*a;
		};
		System.out.println(b1.mb(10));
	}
}