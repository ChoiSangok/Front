package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//싱글톤 적용 객체 - DB연결
//		Connection 객체를 하나만 만들어서 사용할 수 있게 한다

public class DBConn {
	
	
	//OJDBC 드라이버 
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	//DB 연결 정보
	private static final String  URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME="scott";
	private static final String PASSWORD = "tiger";
	
	
	//OJDBC 객체
	private static Connection conn=null; //db 연결객체

	//private 생성자 - 외부에서 객체 생성하는 걸 막는 용도
	private DBConn() { }
	
	
 
	public static Connection getConnection() {
	
		if( conn == null) {
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
		
		return conn; //db 연결 객체 반환
	
	}
		

}












