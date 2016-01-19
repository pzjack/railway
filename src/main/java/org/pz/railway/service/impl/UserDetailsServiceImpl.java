package org.pz.railway.service.impl;

import java.util.Collection;

import org.pz.railway.contants.Contants;
import org.pz.railway.entity.Account;
import org.pz.railway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService;
	
	/*
	 * (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account act = userService.findByAccount(username);
		if (act == null) {
			throw new UsernameNotFoundException("Could not find user " + username);
		}
		return new CustomUserDetails(act.getAccount(), act.getPassword(), act.getRole(), act.getUser().getName());
	}
	
	
	private final static class CustomUserDetails implements UserDetails {
		private static final long serialVersionUID = 8683102959103260527L;
		private String username;
		private String password;
		@SuppressWarnings("unused")
		private String role;
		private Integer roleid;
		@SuppressWarnings("unused")
		private String name;
		private CustomUserDetails(String username, String password, Integer roleId, String name) {
			this.username = username;
			this.password = password;
			this.roleid = roleId;
			this.role = Contants.ROLES.get(this.roleid);
			this.name = name;
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			if("admin".equals(username)) {
				return AuthorityUtils.createAuthorityList(Contants.ROLE_USER, Contants.ROLE_ADMIN);
			} else {
				switch(roleid) {
				case 0: return AuthorityUtils.createAuthorityList(Contants.ROLE_USER);
				case 10: return AuthorityUtils.createAuthorityList(Contants.ROLE_MEMBER);
				case 20: return AuthorityUtils.createAuthorityList(Contants.ROLE_LEADER);
				case 30: return AuthorityUtils.createAuthorityList(Contants.ROLE_CONTROLLER);
				default:
					return AuthorityUtils.createAuthorityList(Contants.ROLE_USER);
				}
			}
		}

		@Override
		public String getUsername() {
			return username;
		}
		@Override
		public String getPassword() {
			return password;
		}

		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return true;
		}
	}
}
