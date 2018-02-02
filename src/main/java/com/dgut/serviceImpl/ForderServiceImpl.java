package com.dgut.serviceImpl;

import com.dgut.dao.ForderMapper;
import com.dgut.dao.TeacherRequirementMapper;
import com.dgut.entity.Forder;
import com.dgut.entity.ForderExample;
import com.dgut.entity.ForderExample.Criteria;
import com.dgut.service.ForderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForderServiceImpl extends BaseServiceImpl<Forder, ForderExample> implements ForderService{

	@Autowired
	ForderMapper forderMapper;
	
	@Autowired
	TeacherRequirementMapper teacherRequirementMapper;
	
	@Autowired
	public void setBaseMapper() {
		super.setBaseMapper(forderMapper);
	}

	@Override
	public List<Forder> selectMyForder(Integer id) {
		ForderExample example=new ForderExample();
		Criteria criteria=example.createCriteria();
		criteria.andStudentIdEqualTo(id);
		return forderMapper.selectByExample(example);
	}

	
	

}
