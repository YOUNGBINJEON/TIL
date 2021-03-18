package day6;

import java.util.StringTokenizer;

/*
JAVA API를 사용하여 다음과 같은 결과가 나오도록 빈칸을 채우십시오. 단, 빈칸은 반드시 적절한 메쏘드를 사용해서 채워져야 합니다.

---------------------------
실행 결과: 
1. 이름: Arnold Alois Schwarzenegger
2. 이름 (대문자): ARNOLD SCHWARZENEGGER
3. 이니셜:  AAS
4. First Name은 arnold이다. (대소문자 구분; T/F):  false
5. First Name은 arnold이다. (대소문자 미구분; T/F):  true
6. Last Name Schwarzenegger의 index 번호 6~13까지 문자열 : zenegger
7. Last Name Schwarzenegger에서 negger 문자열의 위치 : 8
---------------------------
*/

class StringTest {
  public static void main(String[] args) {
	String first = "Arnold";
	String middle = "Alois";
	String last = "Schwarzenegger";
	String initials;
	String firstInit, middleInit, lastInit;

	firstInit = first.substring(0, 1); //문자열 추출 0번인덱스부터 1번미만
	middleInit = middle.substring(0, 1);
	lastInit = last.substring(0, 1);
	initials = firstInit + middleInit + lastInit; //AAS

	System.out.print("1. 이름: ");
	System.out.println(first + " " + middle + " " + last);
	System.out.print("2. 이름 (대문자): ");
	System.out.println(first.toUpperCase() + " " + last.toUpperCase());
	System.out.print("3. 이니셜:  ");
	System.out.println(initials);
			
	System.out.println("4. First Name은 arnold이다. (대소문자 구분; T/F):  " + first.equals("arnold"));
	System.out.println("5. First Name은 arnold이다. (대소문자 미구분; T/F):  " + first.equalsIgnoreCase("arnold")); //아놀드라는 문자열을 대소문자 미구분하면서 트루폴스 확인
		
	System.out.println("6. Last Name " + last + "의 index 번호 6~14까지 문자열 : " +  last.substring(6)); //6번 인덱스부터 끝까지 
	System.out.println("7. Last Name " + last + "에서 negger 문자열의 위치 : " + last.indexOf("negger"));
	
	//스플릿은 구분자를 |로 나눠야하고 스트링 토크나이저는 구분자 구분없이 사용해도 하나씩 구분해줌
	String address = "서울시-강남구/역삼동:100번지 위워크 빌딩 5층"; //지정한 문자를 중심을 나누기
	String details [] = address.split("/|:|-" ); //구분을 하고싶으면 |(or)연산자 넣어주면 된다.
	System.out.println("구분 갯수 = " + details.length);
	for (int i= 0; i < details.length; i++) {
		System.out.println(details[i]);
	}
	//StringTokenizer 클래스 문자열 분할 기능 전용.
  StringTokenizer st = new StringTokenizer("서울시-강남구/역삼동:100번지 위워크 빌딩 5층", "/-:"); //("문자열", "구분자") 로 작성
  while(st.hasMoreTokens()) {
	  System.out.println(st.nextToken());
  }
	}
  
 
  
}

