package com.shop.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.classic.Session;

import com.opensymphony.xwork2.ActionSupport;
import com.shop.beans.Sex;
import com.shop.beans.User;

import Dao.PersonManage;

public class LoginAction  extends ActionSupport {
	private String userName;
	private String userPassword;
	private PersonManage personManage;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public PersonManage getPersonManage() {
		return personManage;
	}
	public void setPersonManage(PersonManage personManage) {
		this.personManage = personManage;
	}
	//普通用户登陆
	public String loginCheck(){
		String page = INPUT;
		User newUser =new User();
		newUser = personManage.checkUser(userName,userPassword);
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session =request.getSession();
		if(newUser!=null){
			page=SUCCESS;
			if(session.getAttribute("loginUser")!=null){
				session.removeAttribute("loginUser");
			}
				session.setAttribute("loginUser", newUser);
		}
		else{addFieldError("userPassword","密码或用户名不正确");}
		return page;
	}
	//管理员登录
		public String managerLoginCheck(){
			String page = "fail";
			boolean flag = false;
			flag = personManage.checkManager(userName, userPassword);
			if(flag){
				page = "success";
				HttpServletRequest request = ServletActionContext.getRequest();
				HttpSession session = request.getSession();
				if(session.getAttribute("managerLoginName") != null){
					session.removeAttribute("managerLoginName");
				}
				session.setAttribute("managerLoginName", userName);			
			}
			return page;
		}
}
