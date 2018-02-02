package com.dgut.serviceImpl;

import com.dgut.dao.TeacherDesireMapper;
import com.dgut.entity.TeacherDesire;
import com.dgut.entity.TeacherDesireExample;
import com.dgut.service.TeacherDesireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherDesireServiceImpl extends BaseServiceImpl<TeacherDesire, TeacherDesireExample> implements TeacherDesireService {

	@Autowired
	TeacherDesireMapper teacherDesireMapper; 
	
	@Autowired
	public void setBaseMapper() {
		super.setBaseMapper(teacherDesireMapper);
	}

}
