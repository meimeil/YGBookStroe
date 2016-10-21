package com.shop.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Dao.OrdersManage;
import com.shop.beans.Orders;

@SuppressWarnings("serial")
public class DealOrdersAction extends ActionSupport{

	private OrdersManage ordersManage;
	
	public void setOrdersManage(OrdersManage ordersManage) {
		this.ordersManage = ordersManage;
	}

	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String ordersIdString = request.getParameter("ordersId");
		int ordersId = Integer.parseInt(ordersIdString);
		Orders orders = ordersManage.findOrders(ordersId);
		orders.setIsDeal('1');
		ordersManage.updateOrders(orders);
		try {
			response.sendRedirect("../manage/manageAllOrders.jsp?searchType=all");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
