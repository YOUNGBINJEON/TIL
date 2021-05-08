
public class GugudanMain {
	public static void main(String[] args) {
		// 반복문을 이용해 간단하게 출력 
		for(int i = 2; i<10; i++) {
			int [] result5 = GugudanClass.calculate(i);
			GugudanClass.print(result5);
		}
	}

}
