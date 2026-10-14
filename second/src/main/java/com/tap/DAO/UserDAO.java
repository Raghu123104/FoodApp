package com.tap.DAO;

import java.util.List;

import com.tap.Model.Users;

public interface UserDAO {
	  void saveUser(Users user);
	    List<Users> findByUsernameOrEmail(String username, String email);
	    Users findByEmailAndPassword(String email, String password);

}
