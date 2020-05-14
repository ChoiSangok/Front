package ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//JDBC 사용방법
// 1. JDBC 드라이버 코드
// 2. DB 접속( 연결, Connection )
// 3. sql 쿼리 수행
// 4. 조회된 결과 처리
// 5. 연결 종료

public class OjdbcEx_01 {
	public static void main(String[] args) {
		
		// 1. JDBC 드라이버 코드
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// ----- OJDBC 사용에 필요한 변수들 ----
		Connection conn = null; //db 연결 객체(접속 객체)
		Statement st= null; //  sql 구문 저장 및 수행 객체
		ResultSet rs= null; // 조회결과 반환 객체
		
		
		// -------------------------------------
		
		// 2. DB 접속( 연결, Connection )		
		try {
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"scott", 
					"tiger");
			
			// 3. sql 쿼리 수행
			
			//3.1 쿼리 수행객체 생성
			st=conn.createStatement();
			
			//3.2 SQL 수행 및 결과 저장( ResultSet )
			rs = st.executeQuery("SELECT * FROM emp ORDER BY empno");
			
			// 조회된 행이 존재하는 만큼 반복하는 코드
			while( rs.next()) {
				//rs.next()를 한번 수행할 때마다 조회된 결과에서
				//순차적으로 한 행씩 참조한다
				
				System.out.println(rs.getString("ename") +", ");
				
				System.out.print(rs.getString("job")+ ", ");
				System.out.print(rs.getString("hiredate") + ", ");
				System.out.print(rs.getString("mgr")+", ");
				System.out.println(rs.getString("sal"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(st!=null) st.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
		// 4. 조회된 결과 처리
		// 5. 연결 종료
		
	}

}

