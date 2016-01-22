package org.pz.railway.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.pz.railway.contants.Contants;
import org.pz.railway.contants.GeneratorUUID;
import org.pz.railway.entity.Account;
import org.pz.railway.entity.Org;
import org.pz.railway.entity.Token;
import org.pz.railway.entity.User;
import org.pz.railway.form.UserForm;
import org.pz.railway.form.UserList;
import org.pz.railway.repository.AccountRepository;
import org.pz.railway.repository.TokenRepository;
import org.pz.railway.repository.UserRepository;
import org.pz.railway.service.OrgService;
import org.pz.railway.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;

@Component
@Transactional
public class UserServiceImpl implements UserService {
	private final static Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private TokenRepository tokenRepository;
	
	@Autowired
	private OrgService orgService;
	public User save(User org){
		return userRepository.save(org);
	}
	
	@Transactional(readOnly = true)
	public User read(Long id) {
		return userRepository.findOne(id);
	}

	@Transactional(readOnly = true)
	public List<UserList> findUser() {
		List<UserList> list = new ArrayList<UserList>();
		Page<User> page = userRepository.findAll(new PageRequest(0, 20));
		List<User> userData = page.getContent();
		for(User user : userData) {
			UserList userlist = new UserList();
			userlist.setAccount(user.getAccount());
			userlist.setCreatetime(null != user.getCreatetime()?Contants.FORMAT.format(user.getCreatetime()):null);
			userlist.setEmail(user.getEmail());
			userlist.setPhone(user.getPhone());
			userlist.setName(user.getName());
			userlist.setOrgName(null != user.getOrg()? user.getOrg().getName() : null);
			userlist.setRole(Contants.ROLES.get(user.getRole()));
			list.add(userlist);
		}
		return list;
	}
	
	public User saveUser(UserForm form, Errors errors) {
		Date date = new Date();
		List<Account> aclist = accountRepository.findByAccount(form.getAccount());
		if(aclist.size() > 0) {
//			errors.?
			return null;
		}
		Account account = new Account();
		account.setAccount(form.getAccount());
		account.setPassword(form.getPassword());
		account.setRole(form.getRole());
		account.setCreatetime(date);
		account.setName(form.getName());
		
		User user = new User();
		account.setUser(user);
		accountRepository.save(account);
		
		user.setName(form.getName());
		user.setPhone(form.getPhone());
		user.setEmail(form.getEmail());
		user.setRole(form.getRole());
		user.setCreatetime(date);
		user.setAccount(form.getAccount());
		if(null != form.getOrgId() && form.getOrgId() > 0) {
			Org parent = orgService.read(form.getOrgId());
			user.setOrg(parent);
		}
		return save(user);
	}
	
	@Transactional(readOnly = true)
	public Account findByAccount(String account) {
		List<Account> aclist = accountRepository.findByAccount(account);
		if(aclist.size() == 1) {
			return aclist.get(0);
		} else {
			if(aclist.size() > 1) {
				LOG.warn("Account [{}] has mutil recorder.");
			}
			return null;
		}
	}
	
	public void createToken(Account act) {
		List<Token> list = tokenRepository.findByAccountId(act.getId());
		if(list.size() > 0) {
			tokenRepository.delete(list);
		}
		Token token = new Token();
		token.setAccount(act);
		token.setCreatetime(new Date());
		token.setUser(act.getUser());
		token.setToken(GeneratorUUID.getRadomUUID());
		tokenRepository.save(token);
	}
}
