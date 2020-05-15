package ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class OjdbcEx_03 {
	
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
	private static Statement st=null; //sql 수행객체
	private static PreparedStatement ps= null;
	private static ResultSet rs = null; //조회 결과 객체
	
	public static void main(String[] args) {
		// --- 드라이버 로드 ---		
			try {
				Class.forName(DRIVER);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//------------------
			
			// scanner 
			Scanner sc= new Scanner(System.in);
			
		
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
				
				//Statement 객체는 생성(createStatement()) 될 때
				// 쿼리를 매개변수 없음
				
				// execute 수행할 때 매개변수 없음
				
				// execute 전에 ? 에 대한 값을 채워줘야함
				
				
//				st= conn.createStatement();
//				rs=st.executeQuery(sql);
				
				ps=conn.prepareStatement(sql);
				
				ps.setString(1, job); //salesman 이 'salesman' 으로 들어감

				rs=ps.executeQuery();
				//---------------------
				// 조회된 행이 존재하는 만큼 반복하는 코드
				while( rs.next()) {
					
					System.out.println(rs.getString("ename") +", ");
					
					System.out.print(rs.getString("job")+ ", ");
					System.out.print(rs.getString("hiredate") + ", ");
					System.out.print(rs.getString("mgr")+", ");
					System.out.print(rs.getString("sal"));
					System.out.print(rs.getString("comm"));
					System.out.println(rs.getString("deptno"));
					
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



