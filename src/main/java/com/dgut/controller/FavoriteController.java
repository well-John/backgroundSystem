package com.dgut.controller;

import com.dgut.entity.*;
import com.dgut.service.FavoriteService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FavoriteController {

	private Logger logger = LoggerFactory.getLogger(FavoriteController.class);

	private final Integer pageSize=5;

	@Autowired
	FavoriteService favoriteService;
	
	@RequestMapping(value = "selectAllFavorite",method = RequestMethod.POST)
	@ResponseBody
	public Msg selectAllFavorite(HttpSession session, @RequestParam(value="pageNum",defaultValue="1")Integer pageNum){
		Student student=(Student) session.getAttribute("student");
		PageHelper.startPage(pageNum, pageSize);
		List<Favorite> list =favoriteService.selectAllFavorite(student.getId());
		if(list.size()!=0&&list!=null){
			PageInfo<Favorite> pageInfo=new PageInfo<>(list);
			return Msg.success("").add("pageInfo", pageInfo);
		}
		return Msg.error("");
	}
}
