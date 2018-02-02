package com.dgut.controller;

import com.dgut.entity.*;
import com.dgut.service.ForderService;
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
public class ForderController {

	private Logger logger = LoggerFactory.getLogger(ForderController.class);
	
	private final Integer pageSize=5;
	
	@Autowired
	ForderService forderService;

	
	@RequestMapping(value = "/selectMyForder",method = RequestMethod.POST)
	@ResponseBody
	public Msg selectMyForder(HttpSession session, @RequestParam(value="pageNum",defaultValue="1")Integer pageNum ){
		Student student=(Student) session.getAttribute("student");
		PageHelper.startPage(pageNum, pageSize);
		List<Forder> list= forderService.selectMyForder(student.getId());
		if(list!=null&&list.size()!=0){
			PageInfo<Forder> pageInfo=new PageInfo<>(list);
			return Msg.success("").add("pageInfo", pageInfo);
		}
		return Msg.error("");
	
	}
	
	@RequestMapping(value = "/selectAllForders",method = RequestMethod.POST)
	@ResponseBody
	public Msg selectAllForders(@RequestParam(value="pageNum",defaultValue="1")Integer pageNum){
		PageHelper.startPage(pageNum, pageSize);
		List<Forder> list=forderService.selectAll();
		if(list!=null&&!list.isEmpty()){
			PageInfo<Forder> pageInfo=new PageInfo<>(list);
			return Msg.success("").add("pageInfo", pageInfo);
		}
		return Msg.error("");
	}
	
	

}
