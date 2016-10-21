package com.shop.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Dao.PersonManage;
import com.shop.beans.*;

@SuppressWarnings("serial")
public class UserManageAction extends ActionSupport{

	private String userNickname;
	private int sexId;
	private String userEmail;
	private String userPhone;
	private String userAddress;
	private String userRemark;
	
	private String userPassword;
	private String newUserPassword;
	private String reNewUserPassword;
	
	private PersonManage personManage;
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public int getSexId() {
		return sexId;
	}
	public void setSexId(int sexId) {
		this.sexId = sexId;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserRemark() {
		return userRemark;
	}
	public void setUserRemark(String userRemark) {
		this.userRemark = userRemark;
	}
	public void setPersonManage(PersonManage personManage) {
		this.personManage = personManage;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getNewUserPassword() {
		return newUserPassword;
	}
	public void setNewUserPassword(String newUserPassword) {
		this.newUserPassword = newUserPassword;
	}
	public String getReNewUserPassword() {
		return reNewUserPassword;
	}
	public void setReNewUserPassword(String reNewUserPassword) {
		this.reNewUserPassword = reNewUserPassword;
	}
	public String updateUserInfor(){
		String page = "fail";
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user  = (User)session.getAttribute("loginUser");
		if(user == null){
			page = "error";
		}else{
			user.setUserNickName(userNickname);
			Sex sex = personManage.findSex(sexId);
			user.setSex(sex);
			user.setUserEmail(userEmail);
			user.setUserPhone(userPhone);
			user.setUserAddress(userAddress);
			user.setUserRemark(userRemark);
			int i = 0 ;
			i = personManage.updateUserInfor(user);
			if(i == 1){
				page="success";
				session.removeAttribute("loginUser");
				session.setAttribute("loginUser", user);
			}
			if(i == 0){
				page = "error";
			}
		}
		return page;
	}
	public String updateUserPassword(){
		String page="fail";
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user  = (User)session.getAttribute("loginUser");
		if(user == null){
			page = "error";
		}else{
			if(user.getUserPassword().equals(userPassword)){
				if(newUserPassword.equals(reNewUserPassword)){
					user.setUserPassword(newUserPassword);
					int i = 0;
					i = personManage.updateUserInfor(user);
					if( i == 1){
						page="success";
						session.removeAttribute("loginUser");
						session.setAttribute("loginUser", user);						
					}
					if(i == 0){
						page = "error";
					}					
				}
			}
		}	
		return page;
	}
}
