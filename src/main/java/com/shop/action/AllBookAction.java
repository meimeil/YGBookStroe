package com.shop.action;
import com.opensymphony.xwork2.ActionSupport;
import com.shop.beans.Bargain;
import com.shop.beans.Book;
import com.shop.beans.Recommended;

import java.util.*;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import Dao.BookManage;
public class AllBookAction extends ActionSupport {
	private BookManage bookManage;
	public void setBookManage(BookManage bookManage) {
		this.bookManage = bookManage;
	}
	
	public String execute(){
		//推荐书
		List<Recommended> allRecommended = bookManage.allRecommended(1, 4);
		List<Book> recommendedBook = new ArrayList<Book>();
		for(Recommended recommended : allRecommended){
			Book book = new Book();
			book = recommended.getBook();//取Book类
			recommendedBook.add(book);
		}
		//特价书
		List<Bargain> allBargain = bookManage.allBargain(1, 4);
		List<Book> bargainBook = new ArrayList<Book>();
		for(Bargain bargain : allBargain){
			Book book = new Book();
			book = bargain.getBook();
			bargainBook.add(book);
		}
		//新书
		List<Book> latestBook = bookManage.latestBook(1, 6);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("recommendedBook", recommendedBook);
		request.setAttribute("bargainBook", bargainBook);
		request.setAttribute("latestBook", latestBook);
		
		return null;
	}
}
