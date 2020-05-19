package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.face.DeptDao;
import dto.Dept;

public class DeptDaoImpl implements DeptDao{
	
	//OJDBC 드라이버 
	private static final String DRIVER
	="oracle.jdbc.driver.OracleDriver";
	
	//DB 연결 정보
	private static final String  URL 
	="jdbc:oracle:thin:@localhost:1521:xe";
	
	private static final String USERNAME="scott";
	private static final String PASSWORD = "tiger";
	
	//OJDBC 객체
	private static Connection conn=null; //db 연결객체
	private static Statement st = null;
	private static PreparedStatement ps= null; //SQL 수행객체
	private static ResultSet rs = null; //조회 결과 객체
	
	public DeptDaoImpl() {
		try {
			// 드라이버 코드
			Class.forName(DRIVER);
			//------------------
			
			// DB 연결
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Dept> selectAll() {
		
		//sql 작성
		String sql ="";
		sql += " select * from dept";
		sql += " order by deptno";
		
		//쿼리 수행 결과 list
		List<Dept> deptList= new ArrayList<>();
		
		try {
			// 쿼리 수행 객체 생성
			ps=conn.prepareStatement(sql);
			
			//쿼리 수행
			rs = ps.executeQuery();
			
			//결과 처리
			while(rs.next()) {
				Dept d=new Dept();
				
				d.setDeptno(rs.getInt("deptno"));
				d.setDname(rs.getString("dname"));
				d.setLoc(rs.getString("loc"));
				
				deptList.add(d);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				//자원 반납
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return deptList;
	}

	public void insert(Dept dept) {
		
		//sql 작성
		String sql ="";
		sql += "insert into dept(deptno, dname, loc)";
		sql += " values(?,?,?)";
		
//				
//		sql += " select * from dept";
//		sql += " order by deptno";
//		
		//쿼리 수행 결과 list
		List<Dept> deptList= new ArrayList<>();
		
		try {
			// 쿼리 수행 객체 생성
			ps=conn.prepareStatement(sql);
			
			ps.setInt(1, dept.getDeptno());
			ps.setString(2, dept.getDname());
			ps.setString(3,dept.getLoc());
			//쿼리 수행
			ps.executeUpdate();
				
			
			//커밋 - 정상 동작
			conn.commit();
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			//롤백 - 잘못된 동작(sql 수행 중 예외 발생)
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} finally {
			
			try {
				//자원 반납
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
	

}

