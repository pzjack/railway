package org.pz.railway.entity;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="T_TOKEN")
@Cacheable
public class Token extends ID {
	private static final long serialVersionUID = 5160546461440324590L;
	private String token;
	private Long invalidtime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
	private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
	private User user;
    
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Long getInvalidtime() {
		return invalidtime;
	}
	public void setInvalidtime(Long invalidtime) {
		this.invalidtime = invalidtime;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}