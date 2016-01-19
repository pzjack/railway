package org.pz.railway.entity;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="T_USER")
@Cacheable
public class User extends ID {
	private static final long serialVersionUID = -1879967712893628793L;

	private String name;
	private Integer role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "org_id")
	private Org org;
	private String email;
	private String phone;
	private String baiduid;
	private String account;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public Org getOrg() {
		return org;
	}
	public void setOrg(Org org) {
		this.org = org;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBaiduid() {
		return baiduid;
	}
	public void setBaiduid(String baiduid) {
		this.baiduid = baiduid;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
}