package com.shop.action;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.shop.beans.Book;

public class UpdateCartAction extends ActionSupport{
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		String updateType = request.getParameter("updateType");
		List<Book> shoppingBook = (List<Book>) session.getAttribute("shoppingBook");
		double totalMoney = 0;
		totalMoney =(Double) session.getAttribute("totalMoney");
		if("update".equals(updateType)){
			String bookId = request.getParameter("bookId");
			String bookAmount = request.getParameter("bookAmount");
			for(Book book : shoppingBook){
				if(bookId.equals(book.getBookid()+"")){
					totalMoney += (Integer.parseInt(bookAmount)-book.getBookAmount())*book.getBookPrice(); 
					book.setBookAmount(Integer.parseInt(bookAmount));
				}
			}
		}
		if("delete".equals(updateType)){
			String bookId = request.getParameter("bookId");
			Iterator<Book> iter = shoppingBook.iterator();
			while(iter.hasNext()){
				Book book = (Book)iter.next();
				if(bookId.equals(book.getBookid()+"")){
					totalMoney -= book.getBookAmount()*book.getBookPrice();
					iter.remove();
				}
			}
		}
		session.removeAttribute("shoppingBook");
		session.setAttribute("shoppingBook", shoppingBook);
		session.removeAttribute("totalMoney");
		session.setAttribute("totalMoney", totalMoney);
		try {
			response.sendRedirect("../shoppingCart.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
