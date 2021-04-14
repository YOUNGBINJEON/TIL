package emp.spring;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpMain {

	public static void main(String[] args) {
		
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("emp/spring/emp.xml");
		VO vo = factory.getBean("vo", VO.class);

		VO vo2 = factory.getBean("vo2", VO.class);
		
		EmpDAO dao = factory.getBean("dao", EmpDAO.class);
		
		dao.insertEmp(vo);//empVO 객체 전달
		dao.insertEmp(vo2);
		System.out.println("회원등록 마침");
		
	}

}
