package com.shop.action;

import java.util.regex.Pattern;//ʹ��PatternҪ

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
		private PersonManage personManage;//����->��Ա��Ϣ��Dao��
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
		
		public String execute(){//ActionĬ��ִ�з���
			User newUser =new User();
			newUser.setUserName(userName);
			newUser.setUserPassword(userPassword);
			newUser.setUserEmail(userEmail);
			Sex sex =personManage.findSex(0);
			newUser.setSex(sex);
			personManage.addUser(newUser);
			return SUCCESS;
		}
		public void validate(){//��дActionSupport��validate����
			
			if(!Pattern.matches("[a-zA-Z0-9]{6,12}", userPassword)){
				addFieldError("userPassword","������ʹ��6~12λӢ����ĸ��������!");
			}
			if(!Pattern.matches("[a-zA-Z][a-zA-Z0-9]{5,15}",userName)){
				addFieldError("userName","�û�����ʹ��6~16λ,������ĸ��ͷ!");
			}
			if(!userPassword.equals(userRePassword)){//string��������,��Ҫ��equals�Ƚ������������õ������Ƿ����
				addFieldError("userRePassword","�������벻һ��!");				
			}
			if("".equals(userEmail.trim())){
				addFieldError("userEmail","email����λ��!");	
			}
			boolean flag = true;
			flag = personManage.isUserNameExist(userName);
			if(flag){
				addFieldError("userName","�û����Ѿ�����!");	
			}
			
		}

}

