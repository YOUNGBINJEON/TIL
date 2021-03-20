package TIL01;

public class StringExam {
    public static void main(String[] args) {
        String str1 = "안녕하세요. ";
        String str2 = "벌써 여기까지 오셨네요. 끝까지 화이팅!!";
        
        String concatResult;
        String substringResult;
        
        // 아래쪽에 코드를 작성하세요.
        concatResult = str1.concat(str2);
        substringResult = str1.substring(str1.length()-5); //맨 끝 문자열에서 5번째부터 출력
        
        // 이 아래는 정답 확인을 위한 코드입니다. 수정하지 마세요.
        System.out.println(concatResult);
        System.out.println(substringResult);
    }
}