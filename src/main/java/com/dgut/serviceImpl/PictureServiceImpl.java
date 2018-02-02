package com.dgut.serviceImpl;

import com.dgut.dao.PictureMapper;
import com.dgut.entity.Picture;
import com.dgut.entity.PictureExample;
import com.dgut.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureServiceImpl extends BaseServiceImpl<Picture, PictureExample> implements PictureService{

	@Autowired
	PictureMapper pictureMapper;
	
	@Autowired
	public void setBaseMapper() {
		super.setBaseMapper(pictureMapper);
	}

}
