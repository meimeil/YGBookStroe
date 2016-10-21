package com.shop.action;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.shop.beans.Book;
//更新购物车，改变图书数量，删除图书
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
					iter.remove();//iterator 是工作在一个独立的线程中，并且拥有一个 mutex 锁。 在工作的时候是不允许被迭代的对象被改变的.
					//但你可以使用 Iterator 本身的方法 remove() 来删除对象，Iterator.remove() 方法会在删除当前迭代对象的同时维护索引的一致性。 
				}
			}
		}
		session.removeAttribute("shoppingBook");
		session.setAttribute("shoppingBook", shoppingBook);
		session.removeAttribute("totalMoney");
		session.setAttribute("totalMoney", totalMoney);
		try {
			response.sendRedirect("../shoppingCart.jsp");//response.sendRedirect回到购物车页面，或者在action里用result控制视图
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
