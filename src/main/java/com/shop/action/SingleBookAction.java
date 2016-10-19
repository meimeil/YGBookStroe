package com.shop.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.shop.beans.Bargain;
import com.shop.beans.Book;

import Dao.BookManage;

public class SingleBookAction extends ActionSupport{
	private BookManage bookManage;
	public void setBookManage(BookManage bookManage) {
		this.bookManage = bookManage;
	}
	
	public String execute(){
	String page=ERROR;
	HttpServletRequest request=ServletActionContext.getRequest();
	String id=request.getParameter("bookId");
	int bookId=Integer.valueOf(id);
	Book singleBook=new Book();
	singleBook =bookManage.findBook(bookId);
	if(singleBook!=null){
		page=SUCCESS;
	}
	Bargain bargain = null;
	bargain = bookManage.isBargain(bookId);
	if(bargain == null){
		singleBook.setBookNewPrice(singleBook.getBookPrice());
	}else{
		singleBook.setBookNewPrice(bargain.getBoolNewPrice());
	}
	request.setAttribute("singleBook", singleBook);
	return page;
	}
}
