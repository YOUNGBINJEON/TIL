import java.util.Scanner;

public class Gugudan {
	public static void main(String [] args) {
		/*
		//2단
		System.out.println(2*1);
		System.out.println(2*2);
		System.out.println(2*3);
		System.out.println(2*4);
		System.out.println(2*5);
		System.out.println(2*6);
		System.out.println(2*7);
		System.out.println(2*8);
		System.out.println(2*9);
		
		//3단
		System.out.println(3*1);
		System.out.println(3*2);
		System.out.println(3*3);
		System.out.println(3*4);
		System.out.println(3*5);
		System.out.println(3*6);
		System.out.println(3*7);
		System.out.println(3*8);
		System.out.println(3*9);
		
		//4단 , 5단 
		int result = 4*1;
		System.out.println(result);
		
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		System.out.println("number :" + number);
		System.out.println(number * 1); 
		System.out.println(number * 2); 
		System.out.println(number * 3); 
		System.out.println(number * 4); 
		System.out.println(number * 5); 
		System.out.println(number * 6); 
		System.out.println(number * 7); 
		System.out.println(number * 8); 
		System.out.println(number * 9); 
		*/
		
		
		//while 6단
//		int i = 1;
//		while(i < 10) {
//			System.out.println(6 * i);
//			i++;
//		}
//		
//		//for 7단
//		for(int j = 1; j<10; j++) {
//			System.out.println(7 * j);
//		}
//		 
		
		//8단 
		System.out.println("구구단 중 출력할 단은? : ");
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		System.out.println("number : " + number);
		
		if( number < 2) {
			System.out.println("구구단 범위의 숫자를 입력하세요.");
		}else if(number > 9) {
			System.out.println("구구단 범위의 숫자를 입력하세요.");
			
		}
		else {
			for(int i = 1 ; i< 10; i++) {
				System.out.println(number * i);
			
			}
		}
		
	}

}
