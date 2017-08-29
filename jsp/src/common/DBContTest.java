package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBContTest {

	public static void main(String[] args) {
	
		Connection con;
		
		try {
			DBCon db = new DBCon();
			con = db.getCon();
			
		
			String sql = "select * from user";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.print(rs.getString("id") + ",");
				System.out.print(rs.getString("pwd") + ",");
				System.out.println(rs.getString("name"));
				
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}