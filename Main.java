package ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		String url = "jdbc:mysql://localhost:3306/test";
		String sql = "select * from persoane";
		Connection connection= DriverManager.getConnection(url, "root", "root");
		java.sql.Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		//while (rs.next())
			//System.out.println("id=" + rs.getInt("Id") + ", nume= "
					//+ rs.getString("nume") + ",varsta=" + rs.getInt("varsta"));
		rs.next();
		System.out.println("id=" + rs.getInt("Id") + ", nume= "
				+ rs.getString("nume") + ",varsta=" + rs.getInt("varsta"));
		int a=rs.getRow();
		System.out.println(a);
		rs.next();
		System.out.println("id=" + rs.getInt("Id") + ", nume= "
				+ rs.getString("nume") + ",varsta=" + rs.getInt("varsta"));
		a=rs.getRow();
		System.out.println(a);
		connection.close();
		statement.close();
		rs.close();
		
	}

}
