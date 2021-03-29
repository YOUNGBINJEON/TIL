package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {

	public static void main(String[] args) {
		//1. 오라클 자동시작 2. ojdbc8.jar 세팅
		Connection conn = null;
		try {
			//jdbc driver 메모리 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// db 연결
			// 다른사람의 컴퓨터에 들어가기 위해서는 @뒤에 상대방 IP주소를 적어야한다
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
			System.out.println("db연결성공");
			// jdbc 계정 안에 c_emp 테이블에 데이터 저장
			// 사번 600 이름 LeeJava 직금 IO 연봉 10000 사번 10
			// 사번 700 이름 LeeJava 직금 IO 연봉 10000 사번 10 ==> 명령형 매개변수
			// c_emp 테이블 제약조건 설정확인
			// desc user_constraints; sqlplus명령어 입력
			// select constraint_name, constraint_type, search_condition, table_name from user_constraints where table_name='C_EMP';
			
			// 자바 "sql" 정의 -> db 전송 -> 결과 검색 이용
			//insert into 테이블명 values(값, .args)
			String sql = "insert into c_emp values(" + args[0] + ", '" +args[1]  + "', '" + args[2] + "', " + args[3] + "," + args[4] + ")";
			
			//db 전송
			Statement st = conn.createStatement();
			// 실행
			int insertrow = st.executeUpdate(sql);
			// 리턴 결과 검색
			System.out.println(insertrow + " 개의 행 삽입");
			
			
			System.out.println("DB연결해제 성공");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 세팅 확인하세요");
		}catch(SQLException e) {
			System.out.println("DB연결정보 확인하세요");
			e.printStackTrace();//자세한 오류 원인 확인
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				
			}
		
		}
	}

}
