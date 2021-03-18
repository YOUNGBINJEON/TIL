package TIL01;


public class ArrayExam02 {
    public int sum(int[] array) {
        int sum = 0;
        // array는 길이를 알 수 없는 int형 배열입니다.
        // 변수 sum에 array의 모든 값을 더해보세요.
        for(int i = 0; i < array.length; i++){
            sum += array[i];
        } 
        // 아래는 결과 평가를 위한 코드입니다. 수정하지 마세요.
        return sum;
    }
    
    // 아래는 실행을 위한 코드입니다. 수정하지 마세요.
    public static void main(String[] args) {
        int[] testcase1 = {1, 2, 3, 4};
        int[] testcase2 = {5, 6, 7};
        ArrayExam02 exam = new ArrayExam02();

        int answer1 = exam.sum(testcase1);        
        int answer2 = exam.sum(testcase2);        
        if (answer1 == 10 && answer2 == 18)
            System.out.println("정답입니다. [제출]을 누르세요.");
        else {
            System.out.println("틀렸습니다.");
            System.out.printf("1, 2, 3, 4를 더했는데 %d가 나왔네요.\n", answer1);
            System.out.printf("5, 6, 7을 더했는데 %d가 나왔네요.\n", answer2);
        }
    }
}