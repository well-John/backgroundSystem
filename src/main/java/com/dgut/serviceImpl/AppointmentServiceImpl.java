package com.dgut.serviceImpl;

import com.dgut.dao.AppointmentMapper;
import com.dgut.entity.Appointment;
import com.dgut.entity.AppointmentExample;
import com.dgut.entity.AppointmentExample.Criteria;
import com.dgut.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl extends BaseServiceImpl<Appointment, AppointmentExample> implements AppointmentService {

	@Autowired
	AppointmentMapper appointmentMapper;
	
	@Autowired
	public void setBaseMapper() {
		super.setBaseMapper(appointmentMapper);
	}

	@Override
	public List<Appointment> selectAllStudentAppointment(int organiser, Integer id) {
		AppointmentExample example=new AppointmentExample();
		Criteria criteria=example.createCriteria();
		criteria.andOrganiserEqualTo(organiser);
		criteria.andStudentIdEqualTo(id);
		return appointmentMapper.selectByExample(example);
	}

	@Override
	public List<Appointment> selectAllTeacherAppointment(int organiser, Integer id) {
		AppointmentExample example=new AppointmentExample();
		Criteria criteria=example.createCriteria();
		criteria.andOrganiserEqualTo(organiser);
		criteria.andTeacherIdEqualTo(id);
		return appointmentMapper.selectByExample(example);
	}

}
