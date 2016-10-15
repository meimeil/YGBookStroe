package com.shop.action;
import Dao.BookManage;
import com.shop.beans.Book;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LeftAction extends ActionSupport {
	private BookManage bookManage;

	public void setBookManage(BookManage bookManage) {
		this.bookManage = bookManage;
	}
	public String execute(){
		List<Book> bestSellingBook =bookManage.bestSellingBook(1, 10);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("bestSellingBook", bestSellingBook);
		return null;//���ﲻ��Ҫaction���κ���ת�����Է���null���ڶ���action��jsp��������
	}
}
