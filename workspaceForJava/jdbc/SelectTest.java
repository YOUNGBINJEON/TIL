package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {

	public static void main(String[] args) {
		//1. 오라클 자동시작 2. ojdbc8.jar 세팅
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			//jdbc driver 메모리 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// db 연결
			// 다른사람의 컴퓨터에 들어가기 위해서는 @뒤에 상대방 IP주소를 적어야한다
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
			System.out.println("db연결성공");
			
			String sql = "select * from c_emp where dept_id = 40"; //null 값 포함하여 테이블 레코드 갯수 리턴. 1행 1열 리턴
					//"select * from c_emp";
			//sql 저장 - db 전송 = 결과 저장
			st = conn.createStatement();
			// 실행
			rs = st.executeQuery(sql);
			// 리턴 결과 검색
			rs.next(); // 1행 이동
			System.out.println(rs.getInt("count(*)")); // 컬럼명, index, 별칭, 함수명
			/*
			while(rs.next()) {
				int emp_id = rs.getInt("emp_id");
				String emp_name = rs.getString("emp_name");
				String title = rs.getString("title");
				double salary = rs.getDouble("salary");
				int dept_id = rs.getInt("dept_id");
				System.out.println(emp_id + "|" + emp_name + "|" + title + "|" + salary + "|" + dept_id);
			}
			*/
			System.out.println(rs);
			
			
			System.out.println("DB연결해제 성공");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 세팅 확인하세요");
		}catch(SQLException e) {
			System.out.println("DB연결정보 확인하세요");
			e.printStackTrace();//자세한 오류 원인 확인
		}finally {
			try {
				rs.close();
				st.close();
				conn.close();
			}catch(SQLException e) {
				
			}
		
		}
	}

}
