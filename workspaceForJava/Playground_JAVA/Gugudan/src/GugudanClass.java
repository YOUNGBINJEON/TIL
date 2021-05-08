
public class GugudanClass {
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


}
