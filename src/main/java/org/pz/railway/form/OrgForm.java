package org.pz.railway.form;

import org.hibernate.validator.constraints.NotBlank;
import org.pz.railway.contants.Contants;

public class OrgForm {
	private Long id;
	@NotBlank(message = Contants.NOT_BLANK_MESSAGE)
//	@Length(min=2, max=60)
	private String name;
//	@NotBlank(message = OrgForm.NOT_BLANK_MESSAGE)
	private Integer type;
	private String describer;
	private Long parentId;
	private String parentName;
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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getDescriber() {
		return describer;
	}
	public void setDescriber(String describer) {
		this.describer = describer;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
}