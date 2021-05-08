import java.util.Scanner;

public class GugudanNN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		System.out.println("입력한 값 : "+ number);
		
		if(number < 2) {
			System.out.println("2 이상의 값을 입력하세요.");
		}
		else {
			for(int i = 1; i <= number; i++) {
				System.out.printf("%d * %d = %d \n", number, i,number * i);
			}
		}
		
	}

}
