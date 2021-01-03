package com.leaning.Services;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.leaning.Model.UserModel;



@Component
public class IDAO_Implementaion implements IDAO {

	private String user = "sa";
	private String pass = "";
	private String url = "jdbc:h2:tcp://localhost/~/test";
	Connection conn;
	PreparedStatement pstmt;
	Statement stmt;
	UserModel model;

	private boolean getConnection() {

		try {
			
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("CONNECTION SUCCESSFULLY");

		} catch (ClassNotFoundException e) {

			System.out.println("ClassNotFoundException" + e.getMessage());

		} catch (SQLException e) {

			System.out.println("SQLException" + e.getMessage());

		}

		if (conn != null) {
			return true;
		}

		else {
			return false;
		}

	}

	@Override
	public List<UserModel> getUserDetails() {

		List<UserModel> userlist = new ArrayList();

		if (getConnection()) {
			String query = "select * from SPRINGUSER";

			try {
				stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(query);

				while (result.next()) {

					model = new UserModel();
					model.setId(result.getInt("id"));
					model.setName(result.getString("name"));
					model.setEmail(result.getString("email"));
					model.setPassword(result.getString("password"));
					model.setAddre(result.getString("addre"));
					userlist.add(model);			
					
				}

			} catch (SQLException e) {

				System.out.println("SQLException Found" + e.getMessage());

			}

		}

		return userlist;
	}

	@Override
	public boolean insertUserRecord(UserModel model) {

		int rowInserted = 0;

		if (getConnection()) {

			try {
				String query = "INSERT INTO SPRINGUSER (NAME,EMAIL,PASSWORD,ADDRE)" 
							+ " VALUES (?,?,?,?) ";

				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, model.getName());
				pstmt.setString(2, model.getEmail());
				pstmt.setString(3, model.getPassword());
				pstmt.setString(4, model.getAddre());

				rowInserted = pstmt.executeUpdate();

			} catch (SQLException e) {

				System.out.print("SQL EXCEPTION" + e.getMessage());
				
				
			}

		}

		if (rowInserted > 0) {

			return true;

		} else
		{
			return false;
		}
	}

	@Override
	public int editUser(UserModel model) {
		
		
		int rowUpdate=0;
		
		try {
			
			String query="UPDATE SPRINGUSER "
					+ " SET NAME=?,EMAIL=?,PASSWORD=?,ADDRE=?"
					+ "WHERE ID =?";
			
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, model.getName());
			pstmt.setString(2, model.getEmail());
			pstmt.setString(3, model.getPassword());
			pstmt.setString(4, model.getAddre());
			pstmt.setInt(5, model.getId());
			rowUpdate=pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			
			System.out.print("SQL EXCEPTION" + e.getMessage());
		}
		
		
		return rowUpdate;
	}

	@Override
	public UserModel getRecordById(int i) {
	
		if(getConnection()) {
			
			try {
				String query="SELECT * FROM SPRINGUSER WHERE ID=? ";
				
				pstmt=conn.prepareStatement(query);
				pstmt.setInt(1, i);
				ResultSet result=pstmt.executeQuery();
				
				while(result.next())
				{
					
					model=new UserModel();
					model.setId(result.getInt("ID"));
					model.setName(result.getString("NAME"));
					model.setEmail(result.getString("EMAIL"));
					model.setPassword(result.getString("PASSWORD"));
					model.setAddre(result.getString("ADDRE"));
							
				}
			
			} 
			catch (SQLException e) {
				
				System.out.print("SQL EXCEPTION" + e.getMessage());
			}
				
		}
		
		return model;
	}

	@Override
	public int deleteUser(int i) {
	
		int rowAffected=0;
		
		if(getConnection())
		{
		
			try {
				
				String query ="DELETE  FROM SPRINGUSER WHERE ID=? ";
				
				pstmt=conn.prepareStatement(query);
				pstmt.setInt(1, i);
				rowAffected=pstmt.executeUpdate();
				
				
			} catch (SQLException e) {
				
				System.out.print("SQL EXCEPTION" + e.getMessage());

			}
			
		}
		
		return rowAffected;
	}

}
