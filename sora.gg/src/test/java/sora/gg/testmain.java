package sora.gg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class testmain {
public static void main(String[] args) {
	  try {
		  Connection connection = getConnection();
		  Statement statement = connection.createStatement();
		int result = statement.executeUpdate("TRUNCATE table toprankergame");
//	  connection.commit();
	

	  } catch (SQLException e1) {
		  // TODO Auto-generated catch block
		  e1.printStackTrace();
	  }
}

private static Connection getConnection() {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	try {
		return	DriverManager.getConnection(url, "test2", "test2");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
		
		
	//사용은 DBM.connect();
	
//	con = DBM.connect();
//	connection con = null;;
		
//	}
//
//	public static void close(	Connection con, PreparedStatement psmt, ResultSet rs) {
//	//오류발생시 트라이캐치
//		try {
//			if (rs != null)
//			{rs.close();}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			psmt.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			con.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		//사용은 DBM.close(con,psmt,rs); 안쓴 인자는 null 넣어서 사용
//		
//		
//	}
	return null;
}
}
