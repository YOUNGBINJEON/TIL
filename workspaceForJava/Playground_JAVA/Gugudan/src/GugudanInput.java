import java.util.Scanner;

public class GugudanInput {

	public static void main(String[] args) {
		
		System.out.println("2개의 입력값을 넣어주세요 ex) a,b");
		Scanner scanner = new Scanner(System.in);
		String inputValue = scanner.nextLine();
		
		String [] splitedValue = inputValue.split(",");
		int first = Integer.parseInt(splitedValue[0]);
		int second = Integer.parseInt(splitedValue[1]);
		
		// 1. first 값을 입력한 단까지 순차적으로 
		if(first < 2) {
			System.out.println("첫 번째 값을 2보다 큰 값을 입력해주세요");
		}
		else if(second < 1){
			System.out.println("두 번째 값을 1보다 큰 값을 입력해주세요");
		}
		else {
			for(int i = 2; i <= first; i ++) {
				
				// 2. second 값까지 순차적으로 곱해서 출력
				for(int j = 1; j<= second; j++ ) {					
					System.out.printf("%d * %d = %d \n",  i, j, i * j);
				}	
			}
		}		
	}

}
