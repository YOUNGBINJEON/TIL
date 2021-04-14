package tv.spring;

public class SamsungTV implements TV {
	public SamsungTV() {
		System.out.println("삼성 생성자 호출");
	}
	public void powerOn() {
		System.out.println("삼성 tv 전원 켜다");
	}
	public void powerOff() {
		System.out.println("삼성 tv 전원 끄다");
	}
	public void volumeUp() {
		System.out.println("삼성 tv 볼륨 높이다");
	}
	public void volumeDown() {
		System.out.println("삼성 tv 볼륨 낮추다");
	}

}
