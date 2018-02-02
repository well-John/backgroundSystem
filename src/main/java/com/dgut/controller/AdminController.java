package com.dgut.controller;

import com.dgut.entity.Admin;
import com.dgut.entity.Msg;
import com.dgut.service.AdminService;
import com.dgut.utils.IPAddressUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Date;

/**
 * @author: xieyougen
 * @email: xieyougen@tuandai.com
 * @description:
 * @date: 2018/2/2 14:10
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    private Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Msg login(HttpServletRequest request, String username,String password){
        logger.info("name:{},password:{}",username,password);
        Admin admin = adminService.login(username,password);
        if(admin != null){
            String Ip = IPAddressUtil.getIpAdrress(request);
            admin.setLastIp(Ip);
            admin.setLastTime(new Date());
            adminService.updateByPrimaryKey(admin);
            request.getSession().setAttribute("admin",admin);
            return Msg.success("");
        }
        return Msg.error("登录失败，请检查登录信息");
    }

}
