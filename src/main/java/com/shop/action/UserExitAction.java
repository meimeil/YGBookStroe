package com.shop.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;


import Dao.PersonManage;

public class UserExitAction extends ActionSupport{
	
	public String execute(){
		String page = "firstPage";
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String userType = request.getParameter("userType");
		if("ordinaryUser".equals(userType)){
			session.removeAttribute("loginUser");
		}else if("manager".equals(userType)){
			session.removeAttribute("managerLoginName");
			page = "managerLogin";
		}else{
			page = "error";
		}
		return page;
	}
}
