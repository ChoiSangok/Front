package ex;

import java.util.ArrayList;
import java.util.List;

import dao.face.EmpDao;
import dao.impl.EmpDaoImpl;
import dto.Emp;

public class EmpEx {
	
	//EmpDao 객체 생성
	private static EmpDao empDao= new EmpDaoImpl();
	
	public static void main(String[] args) {
		
		//DAO를 통한 Emp 테이블 전체 조회
		
		List<Emp> list= empDao.selectAll();
		
		for(Emp emp: list) {
			System.out.println(emp);
		}
		
	}
}
