package com.dgut.serviceImpl;

import com.dgut.dao.AdminMapper;
import com.dgut.entity.Admin;
import com.dgut.entity.AdminExample;
import com.dgut.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl extends BaseServiceImpl<Admin, AdminExample> implements AdminService{

	@Autowired
	AdminMapper adminMapper;
	
	@Autowired
	public void setBaseMapper() {
		super.setBaseMapper(adminMapper);
	}

	@Override
	public Admin login(String username, String password) {
		AdminExample adminExample = new AdminExample();
		AdminExample.Criteria criteria = adminExample.createCriteria();
		criteria.andLoginEqualTo(username);
		criteria.andPasswordEqualTo(password);
		List<Admin> list = adminMapper.selectByExample(adminExample);
		return list.size()==1?list.get(0):null;
	}
}
