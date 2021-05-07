
public class GugudanMethod {
	// 메소드를 활용해 구구단 출력 
	public static int[] calculate(int times) {
		int [] result = new int[9];
		for(int i = 0; i < result.length; i++) {
			result[i] = times * (i+1); 
		}
		return result;
	}
	public static void print(int[] result) {
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		
	}

	public static void main(String[] args) {
		//하나씩 호출
		int [] result = calculate(2);
		print(result);
		
		int [] result2 = calculate(3);
		print(result2);
		
		int [] result3 = calculate(4);
		print(result3);
		
		int [] result4 = calculate(5);
		print(result4);
		
		// 반복문을 이용해 간단하게 출력 
		for(int i = 2; i<10; i++) {
			int [] result5 = calculate(i);
			print(result5);
		}
	}

}
