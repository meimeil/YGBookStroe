package com.shop.action;
import com.shop.beans.Sex;
import com.shop.beans.User;

import Dao.PersonManage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UserInforAction extends ActionSupport{
	private PersonManage personManage;

	public PersonManage getPersonManage() {
		return personManage;
	}

	public void setPersonManage(PersonManage personManage) {
		this.personManage = personManage;
	}
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session =request.getSession();
		//User user= new User();
		User oldUser=(User)session.getAttribute("loginUser");
		//String userName = oldUser.getUserName();
		
		String userEmail = request.getParameter("userEmail");
		String userNickname = request.getParameter("userNickname");
		String userPhone = request.getParameter("userPhone");
		String userAddress = request.getParameter("userAddress");
		String userRemark = request.getParameter("userRemark");
		String sexId = request.getParameter("sexId");//
		Sex sex =personManage.findSex(Integer.valueOf(sexId.trim()));
		oldUser.setSex(sex);
		oldUser.setUserAddress(userAddress);
		oldUser.setUserEmail(userEmail);
		//user.setUserName(userName);
		oldUser.setUserNickName(userNickname);
		oldUser.setUserPhone(userPhone);
		oldUser.setUserRemark(userRemark);
		
		int i=personManage.updateUserInfor(oldUser);
		if(i==1){
		if(session.getAttribute("loginUser")!=null){
			session.removeAttribute("loginUser");
		}
		session.setAttribute("loginUser", oldUser);
		return SUCCESS;
		}
		return ERROR;
	}
}
