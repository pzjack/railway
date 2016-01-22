package org.pz.railway.api.v1.mvc;

import java.util.List;

import org.pz.railway.form.OrgSelect;
import org.pz.railway.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagerResourceController {
	
	@Autowired
	private OrgService orgService;

	@RequestMapping(value = "/api/v1/public/qryorg")
	public List<OrgSelect> queryOrg(String name) {
		return orgService.querySelectDataByName(name);
	}
}