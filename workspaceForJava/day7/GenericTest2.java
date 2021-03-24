package generic2;

class Fruit {
	String name;
}

class Apple extends Fruit {
	
	String origin;
	Apple(String name, String origin) {
		this.name = name;
		this.origin = origin;
	}
}

class Orange extends Fruit {
	String imported;
	Orange(String name, String imported){
		this.name = name;
		this.imported = imported;
	}
	
	
}

class Paper{
	String size = "A4";
}


class Box<T extends Fruit> {
	// 1. 멤버변수, 2. 생성자, 3. 메소드 선언 할때 순서는 상관없지만 룰대로 따르자.
	T o;
	Box(T o) {
		this.o = o;
	}
	public T getO() {
		return o;
	}
	public void setO(T o) {
		this.o = o;
	}
	
}
class BoxManager { 
	public void test(Box<? extends Fruit> b) { // 무엇을 전달할지 모르지만 푸릇의 하위클래스로부터 전달받는다
		
		System.out.println(b.getO().name);
		
	}
}

public class GenericTest2 {
	
	public static void main(String[] args) {
		Fruit f = new Fruit();
		Apple a = new Apple("사과", "장수");
		Orange o = new Orange("오렌지", "캘리포니아");
		Paper p = new Paper();
		Box<Apple> box1 = new Box<Apple>(a);
		Box<Orange> box2 = new Box<Orange>(o);
		Box<Fruit> box3 = new Box<Fruit>(f);
		//Box<Paper> box4 = new Box<Paper>(p);
		
		BoxManager m = new BoxManager();
		m.test(box1);
		m.test(box2);
		m.test(box3);
		//m.test(new Box<Paper> p)
	}

}
