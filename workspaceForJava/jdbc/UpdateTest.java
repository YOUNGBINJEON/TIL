package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTest {

	public static void main(String[] args) {
		//1. 오라클 자동시작 2. ojdbc8.jar 세팅
		Connection conn = null;
		Statement st = null;
		try {
			//jdbc driver 메모리 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// db 연결
			// 다른사람의 컴퓨터에 들어가기 위해서는 @뒤에 상대방 IP주소를 적어야한다
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
			System.out.println("db연결성공");
			// jdbc 계정 안에 c_emp 테이블에 데이터 수정
			// LeeJava 직급 변경
			// update 테이블명
			// set 변경 컬럼 이름 = 변경값
			// where 변경조건식 
			// update c_emp set title = (select title from c_emp where emp_id = 100)
			// where emp_name = 'LeeJava'
			// 2번째 대리 연봉 5000 --> 명령행 매개변수로 입력받으면 c_emp 테이블 title 대리인 직원의 현재 급여에 5000 인상 = 급여 변경

			// c_emp 테이블 제약조건 설정확인
			// desc user_constraints; sqlplus명령어 입력
			// select constraint_name, constraint_type, search_condition, table_name from user_constraints where table_name='C_EMP';
			
			// 자바 "sql" 정의 -> db 전송 -> 결과 검색 이용
			//insert into 테이블명 values(값, .args)
			//String sql = "update c_emp set title = (select title from c_emp where emp_id = 100)" + " where emp_name = 'LeeJava'";
			
			// 2번째 대리 연봉 5000 --> 명령행 매개변수로 입력받으면 c_emp 테이블 title 대리인 직원의 현재 급여에 5000 인상 = 급여 변경
			String sql = "update c_emp set salary = salary + " + args[1] + " where title = '" + args[0] + "'";
			
			//"delete c_emp where emp_id = 100" --삭제문
			
			//db 전송
			st = conn.createStatement();
			// 실행
			int updaterow = st.executeUpdate(sql);
			// 리턴 결과 검색
			System.out.println(updaterow + " 개의 행 수정");
			
			
			System.out.println("DB연결해제 성공");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 세팅 확인하세요");
		}catch(SQLException e) {
			System.out.println("DB연결정보 확인하세요");
			e.printStackTrace();//자세한 오류 원인 확인
		}finally {
			try {
				st.close();
				conn.close();
			}catch(SQLException e) {
				
			}
		
		}
	}

}
