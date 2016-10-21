package com.shop.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.shop.beans.Orders;
import com.shop.beans.User;

import Dao.OrdersManage;
//按条件显示订单
public class OrdersAction extends ActionSupport{
	private OrdersManage ordersManage;

	public void setOrdersManage(OrdersManage ordersManage) {
		this.ordersManage = ordersManage;
	}
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		List<Orders> allOrdersByUser=new ArrayList<Orders>();
		User user=(User)session.getAttribute("loginUser");
		int userId=user.getUserId();
		String searchType = request.getParameter("searchType");
		if(searchType == null || "".equals(searchType.trim())){
			searchType = "all";
		}
		if("all".equals(searchType)){
			allOrdersByUser = ordersManage.allOrdersByUser(userId, 1, 5);
		}
		if("isDeal".equals(searchType)){
			allOrdersByUser = ordersManage.allOrdersByUserDeal(userId, "1", 1, 5);
		}
		if("isNotDeal".equals(searchType)){
			allOrdersByUser = ordersManage.allOrdersByUserDeal(userId, "0", 1, 5);
		}
		
		
		request.setAttribute("allOrdersByUser", allOrdersByUser);
		int sequence = (1-1)*5;
		request.setAttribute("sequence", sequence);
		return null;
		
	}
}
