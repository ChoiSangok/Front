package ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Emp;



public class OjdbcEx_04 {
	
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
	private static PreparedStatement ps= null; //SQL 수행객체
	private static ResultSet rs = null; //조회 결과 객체
	
	public static void main(String[] args) {
		
		// 전체 조회 결과를 저장할 리스트
		List<Emp> list= new ArrayList<>();
		
		
		
		
		// --- 드라이버 로드 ---		
			try {
				Class.forName(DRIVER);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//------------------
			
			String job="SALESMAN";

			//--- sql 작성----
//			
//			String sql ="";
//			sql += "SELECT * FROM emp";
//			sql += " where job= '" + job + "'";
//			sql += " order by empno";
			
			//--------------
			String sql ="";
			sql += "SELECT * FROM emp";
			sql += " where job= ?";
			sql += " order by empno";
			
			//-------------------
			
			
			try {
				// --- DB 연결 ----
				conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				//---------------------
				
				//--- sql 수행 객체 -----				
				ps=conn.prepareStatement(sql);
				
				ps.setString(1, job); 

				rs=ps.executeQuery();
				//---------------------
				
				
				//----결과처리 ------
				
				while(rs.next()) {  // 모든 데이터(행) 를 반복
					
					// o새로운 빈 Emp 객체 생성
					Emp emp= new Emp();
					
					//ResultSet에서 emp 객체 데이터 담기
					emp.setEmpno(rs.getInt("empno"));
					emp.setEname(rs.getString("ename"));
					emp.setJob(rs.getString("job"));
					emp.setMgr(rs.getInt("mgr"));
					emp.setHiredate(rs.getDate("hiredate"));
					emp.setSal(rs.getDouble("sal"));
					emp.setComm(rs.getDouble("comm"));
					
					emp.setDeptno(rs.getInt("deptno"));

					//DTO 를 list 담기
					list.add(emp);

				}
				//--------------
				
				for(Emp e : list) {
					System.out.println(e);
				}
			
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			} finally {
				
				try {
					if(rs!=null ) rs.close();
					if(ps!=null) ps.close();
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			

				
		
	}
	
	

}



