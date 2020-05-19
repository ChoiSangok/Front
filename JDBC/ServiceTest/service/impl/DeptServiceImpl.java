package service.impl;

import java.util.List;

import dao.face.DeptDao;
import dao.impl.DeptDaoImpl;
import dto.Dept;
import service.face.DeptService;

public class DeptServiceImpl implements DeptService{
	
	//DeptDao 객체 생성
	private DeptDao deptDao = new DeptDaoImpl();
	

	@Override
	public List<Dept> deptList() {
		List<Dept> list= deptDao.selectAll();
		
		return list;
	}


	//이게 문제 dept dept
	@Override
	public void addDept(Dept dept) {

		
		deptDao.insert(dept);

		
	}


	
	
}
