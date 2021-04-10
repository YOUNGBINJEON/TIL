package cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookie1")
public class CookieServlet1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// id - jdbc, pw - program
		Cookie c1 = new Cookie("id", java.net.URLEncoder.encode("한글", "utf-8")); //쿠키는 영문자로만 가능
		Cookie c2 = new Cookie("pw","jdbc");
		//브라우저 종료 이후 초단위 지속 설정
		c1.setMaxAge(60*60*24);
		
		//클라이언트 전송 
		response.addCookie(c1);
		response.addCookie(c2);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o =response.getWriter();
		o.println(c1.getName()+ "=" + c1.getValue()+ "<br>");
		o.println(c2.getName()+ "=" + c2.getValue()+ "<br>");
		o.println("위와 같은 쿠키를 클라이언트로 전송했습니다");
	}

}
