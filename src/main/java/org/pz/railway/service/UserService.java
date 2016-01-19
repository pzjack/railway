package org.pz.railway.service;

import java.util.List;

import org.pz.railway.entity.Account;
import org.pz.railway.entity.User;
import org.pz.railway.form.UserForm;
import org.pz.railway.form.UserList;
import org.springframework.validation.Errors;

public interface UserService {
	User save(User user);
	User read(Long id);
	User saveUser(UserForm form, Errors errors);
	List<UserList> findUser();
	Account findByAccount(String account);
}
