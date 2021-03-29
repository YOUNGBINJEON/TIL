package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) {
		//1. 오라클 자동시작 2. ojdbc8.jar 세팅
		Connection conn = null;
		try {
			//jdbc driver 메모리 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// db 연결
			// 다른사람의 컴퓨터에 들어가기 위해서는 @뒤에 상대방 IP주소를 적어야한다
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
			System.out.println("db연결성공");
			// sql 전송 - 결과 검색
			System.out.println("DB연결해제 성공");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 세팅 확인하세요");
		}catch(SQLException e) {
			System.out.println("DB연결정보 확인하세요");
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				
			}
		
		}
	}

}
