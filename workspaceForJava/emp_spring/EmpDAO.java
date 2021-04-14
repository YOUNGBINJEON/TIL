package emp.spring;

public class EmpDAO {
	// 사원정보를 다른 객체로부터 전달받는다 = 주입받는다 = injection(매개변수 객체)
	void insertEmp(VO vo){ 
		/*
		 * EmpVO vo = new EmpVO();
			vo.setId(100);
			vo.setName("이사원");
			vo.setSalary(3800);
		*/
		
		if(vo instanceof EmpVO) {
			EmpVO e = (EmpVO)vo;
			System.out.println(e.getId()+" : "+e.getName()+" : " +e.getSalary());
		}
		else if(vo instanceof MemberVO) {
			MemberVO m = (MemberVO)vo;
			System.out.println(m.getId()+":"+m.getName()+" : " +m.getEmail());
		}
		System.out.println("DB등록 완료했습니다");
	}

}
