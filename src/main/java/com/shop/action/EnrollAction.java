package com.shop.action;

import java.util.regex.Pattern;//使用Pattern要

import com.opensymphony.xwork2.ActionSupport;
import Dao.PersonManage;

import com.shop.beans.User;
import com.shop.beans.Sex;

public class EnrollAction extends ActionSupport {

	
		// TODO Auto-generated method stub
		
		private String userName;
		private String userPassword;
		private String userRePassword;
		private String userEmail;
		private PersonManage personManage;//管理->人员信息的Dao类
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
		public String getUserRePassword() {
			return userRePassword;
		}
		public void setUserRePassword(String userRePassword) {
			this.userRePassword = userRePassword;
		}
		public String getUserEmail() {
			return userEmail;
		}
		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}
		/*public PersonManage getPersonManage() {
			return personManage;
		}*/
		public void setPersonManage(PersonManage personManage) {
			this.personManage = personManage;
		}
		
		public String execute(){//Action默认执行方法
			User newUser =new User();
			newUser.setUserName(userName);
			newUser.setUserPassword(userPassword);
			newUser.setUserEmail(userEmail);
			Sex sex =personManage.findSex(0);
			newUser.setSex(sex);
			personManage.addUser(newUser);
			return SUCCESS;
		}
		public void validate(){//重写ActionSupport的validate方法
			
			if(!Pattern.matches("[a-zA-Z0-9]{6,12}", userPassword)){
				addFieldError("userPassword","密码请使用6~12位英文字母或者数字!");
			}
			if(!Pattern.matches("[a-zA-Z][a-zA-Z0-9]{5,15}",userName)){
				addFieldError("userName","用户名请使用6~16位,且以字母开头!");
			}
			if(!userPassword.equals(userRePassword)){//string引用类型,需要用equals比较两个对象引用的内容是否相等
				addFieldError("userRePassword","两次密码不一致!");				
			}
			if("".equals(userEmail.trim())){
				addFieldError("userEmail","email不能位空!");	
			}
			boolean flag = true;
			flag = personManage.isUserNameExist(userName);
			if(flag){
				addFieldError("userName","用户名已经存在!");	
			}
			
		}

}

