package com.rel.admin.api.user;
import java.util.Optional;

import com.rel.persistence.model.admin.AdminUser;
import com.rel.persistence.repo.AdminUserRepo;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

//import com.app.repo.UserRepo;


import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

  @Autowired
  private AdminUserRepo userRepo;

	public String getLoggedInUserId(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth==null){
            return "nosession";
        }
		return auth.getName();
	}


	public User getLoggedInUser() {
		String loggedInUserId = this.getLoggedInUserId();
		System.out.format("\n1. Inside >> getLoggedInUser: %s", loggedInUserId);
		User user = this.getUserInfoByUserId(loggedInUserId);
		System.out.format("\n2. After Find User: %s", loggedInUserId);
		return user;
	}

	public User getUserInfoByUserId(String userId){
//			User user = this.userRepo.findOneByUserId(userId).orElseGet( () -> new User());
			User user = null;
			return user;
	}

	public boolean insertOrSaveUser(User user) {
//		this.userRepo.save(user);
		return true;
	}

	public boolean addNewUser(User user) {
	//	User newUser = this.getUserInfoByUserId(user.getUserId());
	//	if (newUser.getUserId().equals("new")){
			// This means the username is not found therfore its is returning a default value of "new"
		//	return this.insertOrSaveUser(user);
		//}
	//	else{
			return false;
	//	}
	}

    @Transactional
    public Optional<AdminUser> getByEmail(String email){
       return userRepo.findByEmail(email);
    }

}
