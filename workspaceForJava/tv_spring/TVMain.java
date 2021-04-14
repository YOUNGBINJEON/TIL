package tv.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TVMain {

	//tv 객체 변경하니 같이 변경 코드 따라오더라 = coupling 높다
	// 커플링 낮은 코드 필요
	// 인터페이스 - 메소드 선언 상속 아위클래스들 표준호 ㅏ메소드 오버라이딩
	// 여러가지 하위클래스 타입 호환
	// 엘지티비 / 삼성티비
	public static void main(String[] args) {
		//spring 설정해놓은 객체가 있다면 주입을 받고 설정파일 필요함
		// 파일 읽기
		ApplicationContext factory =
				 new ClassPathXmlApplicationContext("tv/spring/tv.xml");
		TV tv = factory.getBean("tv", TV.class);
		TV tv2 = factory.getBean("tv2", TV.class);
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		
		tv2.powerOn();
		tv2.powerOff();
		tv2.volumeUp();
		tv2.volumeDown();

		tv = factory.getBean("tv", TV.class);
		tv = factory.getBean("tv", TV.class);
		tv = factory.getBean("tv", TV.class);

		
	}

}
