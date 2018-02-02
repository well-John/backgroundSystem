package com.dgut.serviceImpl;

import com.dgut.dao.FavoriteMapper;
import com.dgut.entity.Favorite;
import com.dgut.entity.FavoriteExample;
import com.dgut.entity.FavoriteExample.Criteria;
import com.dgut.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteServiceImpl extends BaseServiceImpl<Favorite, FavoriteExample> implements FavoriteService{

	@Autowired
	FavoriteMapper favoriteMapper;
	
	@Autowired
	public void setBaseMapper() {
		super.setBaseMapper(favoriteMapper);
	}

	@Override
	public List<Favorite> selectAllFavorite(Integer id) {
		FavoriteExample example=new FavoriteExample();
		Criteria criteria=example.createCriteria();
		criteria.andStudentIdEqualTo(id);
		return favoriteMapper.selectByExample(example);
	}

}
