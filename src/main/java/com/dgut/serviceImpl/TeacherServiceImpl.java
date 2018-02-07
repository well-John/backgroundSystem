package com.dgut.serviceImpl;

import com.dgut.dao.TeacherMapper;
import com.dgut.entity.Teacher;
import com.dgut.entity.TeacherExample;
import com.dgut.entity.TeacherExample.Criteria;
import com.dgut.service.TeacherService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TeacherServiceImpl extends BaseServiceImpl<Teacher, TeacherExample> implements TeacherService {

	@Autowired
	TeacherMapper teacherMapper;

	@Autowired
	public void setBaseMapper() {
		super.setBaseMapper(teacherMapper);
	}


	@Override
	public Teacher login(String email, String password) {
		TeacherExample example=new TeacherExample();
		Criteria criteria=example.createCriteria();
		criteria.andEmailEqualTo(email);
		criteria.andPasswordEqualTo(password);
		List<Teacher> list=teacherMapper.selectByExample(example);
		if(list.size()==1){
			return list.get(0);
		}else{
			return null;
		}
	}
	@Override
	public Integer register(Teacher teacher) {
		teacherMapper.insertSelective(teacher);
		return teacher.getId();
	}


	@Override
	public List<Teacher> selecTeachersByExample(String subject, String university, String area, Integer identity, Integer sex) {
		TeacherExample example=new TeacherExample();
		Criteria criteria=example.createCriteria();
		if(subject!=null&&!subject.equals("")){
			criteria.andTeachingSubjectLike("%"+subject.trim()+"%");
		}
		if(university!=null&&!university.equals("")){
			criteria.andUniversityEqualTo(university.trim());
		}
		if(area!=null&&!area.equals("")){
			criteria.andTeachingAreaLike("%"+area.trim()+"%");
		}
		if(identity!=null&&!identity.equals("")){
			criteria.andIdentityEqualTo(identity);
		}
		if(sex!=null&&!sex.equals("")){
			criteria.andSexEqualTo(sex);
		}
		return teacherMapper.selectByExample(example);
	}

	@Override
	public Integer deleteByIds(List<Integer> list) {
		return teacherMapper.deleteByIds(list);
	}

	@Override
	public List<Teacher> selectTeacherByExample(Date start, Date end, String name) {
		TeacherExample example=new TeacherExample();
		Criteria criteria=example.createCriteria();
		if(start!=null){
			criteria.andRegisterTimeGreaterThan(start);
		}
		if(end!=null){
			criteria.andRegisterTimeLessThanOrEqualTo(end);
		}
		if(StringUtils.isNotBlank(name)){
			criteria.andNameLike("%"+name.trim()+"%");
		}
		return teacherMapper.selectByExample(example);
	}

}
