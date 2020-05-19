package service.face; //

import java.util.List;

import dto.Dept;

// mvc 패턴으로 하기위해서 service 단계를 추가함
//controller 에서 

public interface DeptService {

//	//전체 조회
//	public List <Dept> selectAll() ;
	
//	부서 정보 전체 조회
//	return List<Dept> - 조회된 부서 정보 리스트
	
	public List<Dept> deptList();

	//신규 부서 정보 입략
	//dept - 새롭게 입력될 부서 정보
	
	public void addDept(Dept dept);
	
	
}
