package org.pz.railway.service;

import java.util.List;

import org.pz.railway.entity.Org;
import org.pz.railway.form.OrgForm;
import org.pz.railway.form.OrgList;
import org.pz.railway.form.OrgSelect;

public interface OrgService {
	Org save(Org org);
	Org read(Long id);
	Org saveOrg(OrgForm form);
	List<OrgList> findOrg();
	List<OrgSelect> querySelectDataByName(String name);
}
