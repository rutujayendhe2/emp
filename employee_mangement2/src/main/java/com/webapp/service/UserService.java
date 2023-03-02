package com.webapp.service;

import java.util.ArrayList;
import java.util.List;

import com.webapp.dao.IUserRepository;
import com.webapp.dto.UserData;
import com.webapp.model.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class UserService implements IUserService {

	PasswordEncoder passwordEncoder;
	
	//DTO=>Entity
		private Users getUserEntity(UserData userData) {
			Users user = new Users();
			user.setUserId(userData.getUserId());
			user.setFirstName(userData.getFirstName());
			user.setLastName(userData.getLastName());
			user.setEmailAdd(userData.getEmailAdd());
			user.setAddress(userData.getAddress());
			user.setPhoneNo(userData.getPhoneNo());
			user.setPassword(userData.getPassword());

			return user;
		}
		
		//Entity=>DTO
		private UserData getUserData(Users user) {
			UserData userData = new UserData();
			userData.setUserId(user.getUserId());
			userData.setFirstName(user.getFirstName());
			userData.setLastName(user.getLastName());
			userData.setEmailAdd(user.getEmailAdd());
			userData.setAddress(user.getAddress());
			userData.setPhoneNo(user.getPhoneNo());
			userData.setPassword(user.getPassword());

			return userData;
		}
			
	@Autowired
	private IUserRepository userRepository;
		
	@Override
	public List<UserData> findAll() {
		List<UserData> userDataList = new ArrayList<>();
		List<Users> users = userRepository.findAll();
		users.forEach(user -> {
			userDataList.add(getUserData(user));
		});
		return userDataList;
	}
	

	@Override
	public UserData findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserData create(UserData userData) {
		Users user = getUserEntity(userData);
		passwordEncoder=new BCryptPasswordEncoder();
		String password = passwordEncoder.encode(user.getPassword());
		user.setPassword(password);
		return getUserData(userRepository.save(user));
	}

	

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Long id, UserData t) {
		// TODO Auto-generated method stub
		return false;
	}

}
