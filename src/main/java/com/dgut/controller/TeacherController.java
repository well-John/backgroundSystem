package com.dgut.controller;

import com.dgut.entity.*;
import com.dgut.service.TeacherService;
import com.dgut.utils.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	
	private Logger logger =LoggerFactory.getLogger(TeacherController.class);
	
	private final static Integer PAGESIZE=2;

	@Autowired
	TeacherService teacherService;

	@RequestMapping("/login")
	@ResponseBody
	public Msg login(HttpSession session, String email, String password){
		Teacher teacher;
		if((teacher=teacherService.login(email, password))!=null){
			session.removeAttribute("student");
			session.setAttribute("teacher", teacher);
			session.setAttribute("identity", 2);
			return Msg.success("登录成功");
		}
		return Msg.error("登录失败");
	}
	
	@RequestMapping("/register")
	@ResponseBody
	public Msg register(HttpServletRequest request, Teacher teacher, String pcode){
		// 获取验证码
				teacher.setRegisterTime(new Date());
				String code = (String) request.getSession().getAttribute("RANDOM_CODE_KEY");
				if(!code.equals(pcode)){
					return Msg.error("验证码错误");
				}
				Integer id=teacherService.register(teacher);
				if (id!=null) {
					request.getSession().removeAttribute("RANDOM_CODE_KEY");
					return Msg.success("注册成功").add("id", id);
				}
				return Msg.error("注册失败");
	}
	
	@RequestMapping("selectTeacherInfo")
	@ResponseBody
	public Msg selectTeacherById(@RequestParam(value="id",required=true)Integer id){
		Teacher teacher = teacherService.selectByPrimaryKey(id);
		if(teacher==null) {
			logger.info("所查询的教师信息不存在！！！  id:{0}",id);
			return Msg.error("所查询的教师信息不存在！！！");
		}
		return Msg.success("").add("teacher", teacher);
	}

	@RequestMapping("selectAllTeacher")
	@ResponseBody
	public Result selectAllStudent(Integer page,Integer limit,HttpServletRequest request){
		PageHelper.startPage(page,limit);
		List<Teacher> list = teacherService.selectAll();
		PageInfo<Teacher> pageInfo = new PageInfo<>(list);
		return Result.success("",  pageInfo.getTotal(),list);
	}

	@RequestMapping("deleteByIds")
	@ResponseBody
	public Msg delete(String ids){

		List<Integer> list = StringUtil.splitIds(ids);
		if(teacherService.deleteByIds(list) != 0){
			return Msg.success("");
		}
		return Msg.error("");
	}
}
