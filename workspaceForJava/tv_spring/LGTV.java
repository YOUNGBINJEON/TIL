package tv.spring;

public class LGTV implements TV {
	public void powerOn() {
		System.out.println("엘지 tv 전원 켜다");
	}
	public void powerOff() {
		System.out.println("엘지 tv 전원 끄다");
	}
	public void volumeUp() {
		System.out.println("엘지 tv 볼륨 높이다");
	}
	public void volumeDown() {
		System.out.println("엘지 tv 볼륨 낮추다");
	}

}
