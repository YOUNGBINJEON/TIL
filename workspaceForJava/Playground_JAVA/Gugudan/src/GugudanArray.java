
public class GugudanArray {

	public static void main(String[] args) {
		int [] result = new int[9];
		for(int i = 0; i < result.length; i++) {
			result[i] = 2 * (i+1); 
		}
		
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

}
