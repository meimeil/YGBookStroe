package com.shop.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Dao.PersonManage;
import com.shop.beans.User;

@SuppressWarnings("serial")
public class UserInformationAction extends ActionSupport{

	private PersonManage personManage;

	public PersonManage getPersonManage() {
		return personManage;
	}

	public void setPersonManage(PersonManage personManage) {
		this.personManage = personManage;
	}
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String userIdString = request.getParameter("userId");
		int userId = Integer.parseInt(userIdString);
		User user = personManage.findUser(userId);
		request.setAttribute("user", user);
		return null;
	}
}
