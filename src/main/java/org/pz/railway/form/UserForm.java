package org.pz.railway.form;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.pz.railway.contants.Contants;

public class UserForm {
	private Long id;
	@NotBlank(message = Contants.NOT_BLANK_MESSAGE)
	private String name;
	private Integer role;
	private String email;
	@NotBlank(message = Contants.NOT_BLANK_MESSAGE)
	@Length(min=6, max=60)
	private String phone;
	private String baiduid;
	@NotBlank(message = Contants.NOT_BLANK_MESSAGE)
	private String account;
	@NotBlank(message = Contants.NOT_BLANK_MESSAGE)
	@Length(min=6, max=30)
	private String password;
	private Long orgId;
	@NotBlank(message = Contants.NOT_BLANK_MESSAGE)
	private String orgName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getOrgId() {
		return orgId;
	}
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}	
}