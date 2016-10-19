package com.shop.action;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.shop.beans.Bargain;
import com.shop.beans.Book;

import Dao.BookManage;

public class ShoppingCartAction extends ActionSupport{
	private BookManage bookManage;
	public void setBookManage(BookManage bookManage) {
		this.bookManage = bookManage;
	}
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response =ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		String bookId = request.getParameter("bookId");//获取页面传来的servlet parameter
		List<Book> shoppingBook = new ArrayList<Book>();
		if(session.getAttribute("shoppingBook")==null){
			session.setAttribute("shoppingBook", shoppingBook);//没有购物信息，则赋予一个内容是空的ArrayList<Book>
		}else{
			shoppingBook = (List<Book>)session.getAttribute("shoppingBook");
		}
		int i = 0;
		for(Book book :shoppingBook){//如果用户想要放入购物车的书已经在了，直接跳回原页面
			if(bookId.equals(book.getBookid()+"")){
				i++;//或者加数量？还得查数量够不够
			}
		}
		if(i==0){
			Book book =bookManage.findBook(Integer.parseInt(bookId));
			book.setBookAmount(1);
			Bargain bargain = null;
			bargain = bookManage.isBargain(Integer.parseInt(bookId));
			if(bargain!=null){
				book.setBookPrice(bargain.getBoolNewPrice());
			}
			shoppingBook.add(book);
			double totalMoney = 0;
			if(session.getAttribute("totalMoney")==null){
				session.setAttribute("totalMoney", book.getBookPrice());
			}else{
				totalMoney = (Double)session.getAttribute("totalMoney");
				totalMoney+=book.getBookPrice();
				session.removeAttribute("totalMoney");//修改总金额session值--》去除，设置
				session.setAttribute("totalMoney", totalMoney);
			}
			session.removeAttribute("shoppingBook");
			session.setAttribute("shoppingBook", shoppingBook);
		}
		try{
			response.sendRedirect("../singleBook.jsp?bookId="+bookId);//返回原页面。多了session中总金额，书单shoppingBook
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
