package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import common.DBCon;

public class UserServiceImpl implements UserService{

	
	@Override
	public Map<String, String> getUserLogin(String id, String pwd) {
		// TODO Auto-generated method stub
	
		Connection con;		
		try {
			DBCon db = new DBCon();
			con = db.getCon();
			String sql = "select * from user where id=?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				if (pwd.equals(rs.getString("pwd"))) {
					Map<String,String> hm = new HashMap<String, String>();
					hm.put("user_no", rs.getString("user_no"));				
					hm.put("name", rs.getString("name"));
					hm.put("hobby", rs.getString("hobby"));
					hm.put("id", id);
					hm.put("admin", rs.getString("admin"));
										
					return hm;				
				} 				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public int insertUser(Map<String, String> hm) {
		String sql = "Insert into user(id,pwd,name,hobby,admin)";
		sql+="values(?,?,?,?,?)";
		Connection con;
		try {
			DBCon db = new DBCon();
			con = db.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, hm.get("id"));
			ps.setString(2, hm.get("pwd"));
			ps.setString(3, hm.get("name"));
			ps.setString(4, hm.get("hobby"));
			ps.setString(5, hm.get("admin"));
			
			int rCnt = ps.executeUpdate();
			return rCnt;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int updateUser(Map<String, String> hm) {
		String sql = "update user set pwd=?, name=?, hobby=? where user_no=?";
		Connection con;
		try {
			DBCon db = new DBCon();
			con = db.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, hm.get("pwd"));
			ps.setString(2, hm.get("name"));
			ps.setString(3, hm.get("hobby"));
			ps.setString(4, hm.get("user_no"));
			
			int rCnt = ps.executeUpdate();
			return rCnt;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteUser(Map<String, String> hm) {
		String sql = "delete from user where user_no=?";
		Connection con;
		try {
			DBCon db = new DBCon();
			con = db.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, hm.get("user_no"));			
			int rCnt = ps.executeUpdate();
			return rCnt;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public List<Map<String, String>> getUserList(Map<String, String> hm) {
		
		Connection con;		
		List<Map<String,String>> userList = new ArrayList<Map<String,String>>();
		try {
			DBCon db = new DBCon();
			con = db.getCon();
			String sql = "select * from user where 1=1";
			if(hm.get("name")!= null) {
				sql +=" and name like concat('%',?,'%')";
			}
			PreparedStatement ps = con.prepareStatement(sql);
			if(hm.get("name")!= null) {
				ps.setString(1, hm.get("name"));
			}
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Map<String,String> rHm = new HashMap<String, String>();
				rHm.put("id", rs.getString("id"));	
				rHm.put("user_no", rs.getString("user_no"));				
				rHm.put("name", rs.getString("name"));
				rHm.put("hobby", rs.getString("hobby"));
				rHm.put("admin", rs.getString("admin"));	
				userList.add(rHm);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return userList;
	}

	@Override
	public Map<String, String> selectUser(String userNo) {
		Connection con;		
		try {
			DBCon db = new DBCon();
			con = db.getCon();
			String sql = "select * from user where user_no = ?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userNo);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
								
					Map<String,String> hm = new HashMap<String, String>();
					hm.put("id", rs.getString("id"));
					hm.put("user_no", rs.getString("user_no"));				
					hm.put("name", rs.getString("name"));
					hm.put("hobby", rs.getString("hobby"));					
					hm.put("admin", rs.getString("admin"));
										
					return hm;				
						
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
