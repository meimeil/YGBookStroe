package com.shop.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.shop.beans.Bargain;
import com.shop.beans.Book;
import com.shop.beans.Orders;
import com.shop.beans.Ordersbook;

import Dao.BookManage;
import Dao.OrdersManage;

public class SingleOrdersAction extends ActionSupport{
	private OrdersManage ordersManage;
	private BookManage bookManage;
	
	public void setOrdersManage(OrdersManage ordersManage) {
		this.ordersManage = ordersManage;
	}

	public void setBookManage(BookManage bookManage) {
		this.bookManage = bookManage;
	}
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Orders order=new Orders();
		String ordersId=request.getParameter("ordersId");
		order=ordersManage.findOrders(Integer.valueOf(ordersId));
		List<Ordersbook> allOrdersbookByOrders = new ArrayList<Ordersbook>();//user,orders成员，lazy=false
		allOrdersbookByOrders = ordersManage.allOrdersbookByOrders(Integer.valueOf(ordersId));
		List<Book> bookList = new ArrayList<Book>();
		double totalMoney=0;
		for(Ordersbook ordersbook : allOrdersbookByOrders){
			Book book = ordersbook.getBook();
			Bargain bargain = null;
			bargain = bookManage.isBargain(book.getBookid());
			if(bargain != null){
				book.setBookPrice(bargain.getBoolNewPrice());	
			}
			
			book.setBookAmount(ordersbook.getBookAmount());
			totalMoney+=(book.getBookAmount()*book.getBookPrice());
			bookList.add(book);
		}
		totalMoney=Math.round(totalMoney*100)/100.0;//Math.round四舍五入保留整数部分
		order.setTotalMoney(totalMoney);
		request.setAttribute("bookList", bookList);
		request.setAttribute("orders", order);
		return null;
		
	}
}
