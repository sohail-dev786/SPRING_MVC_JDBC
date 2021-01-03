package com.leaning.Services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.leaning.Model.UserModel;


@Component
public interface IDAO {
	
	
	public List<UserModel> getUserDetails();
	
	
	boolean insertUserRecord(UserModel model);	
	
	
	public int editUser(UserModel model);
	
	public UserModel getRecordById(int i);
	
	public int deleteUser(int i);

}
