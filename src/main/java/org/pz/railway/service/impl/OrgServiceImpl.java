package org.pz.railway.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.pz.railway.contants.Contants;
import org.pz.railway.entity.Org;
import org.pz.railway.form.OrgForm;
import org.pz.railway.form.OrgList;
import org.pz.railway.form.OrgSelect;
import org.pz.railway.repository.OrgRepository;
import org.pz.railway.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class OrgServiceImpl implements OrgService {
	
	@Autowired
	private OrgRepository orgRepository;
	public Org save(Org org){
		return orgRepository.save(org);
	}
	
	public Org read(Long id) {
		return orgRepository.findOne(id);
	}
	
	public List<OrgList> findOrg() {
		List<OrgList> list = new ArrayList<OrgList>();
		Page<Org> page = orgRepository.findAll(new PageRequest(0, 20));
		List<Org> orgData = page.getContent();
		for(Org org : orgData) {
			OrgList o = new OrgList();
			o.setId(org.getId());
			o.setName(org.getName());
			if(null != org.getCreatetime()) {
				o.setCreatetime(Contants.FORMAT.format(org.getCreatetime()));
			}
			o.setType(Contants.TYPES.get(org.getType()));
			if(null != org.getParent()) {
				o.setParentName(org.getParent().getName());
				o.setParentType(Contants.TYPES.get(org.getParent().getType()));
			}
			list.add(o);
		}
		return list;
	}
	
	public Org saveOrg(OrgForm form) {
		Org org = new Org();
		org.setName(form.getName());
		org.setDescriber(form.getDescriber());
		org.setType(form.getType());
		org.setCreatetime(new Date());
		
		if(null != form.getParentId() && form.getParentId() > 0) {
			Org parent = read(form.getParentId());
			org.setParent(parent);
		}
		return save(org);
	}
	
	public List<OrgSelect> querySelectDataByName(String name) {
		List<OrgSelect> data = new ArrayList<OrgSelect>();
		List<Org> dtlist = null;
		Page<Org> list = null;
		if(null != name && !name.trim().isEmpty()) {
			list = orgRepository.findByNameLike("%" + name.trim() + "%", new PageRequest(0, 10));
		} else {
			list = orgRepository.findAll(new PageRequest(0, 10));
		}
		dtlist = list.getContent();
		for(Org org : dtlist) {
			OrgSelect s = new OrgSelect();
			s.setData(org.getId());
			s.setValue(org.getName());
			data.add(s);
		}
		return data;
	}
}
