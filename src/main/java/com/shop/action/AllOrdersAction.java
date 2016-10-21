package com.shop.action;

import com.opensymphony.xwork2.ActionSupport;

import Dao.*;
import java.util.*;
import com.shop.beans.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

@SuppressWarnings("serial")
public class AllOrdersAction extends ActionSupport{

	private OrdersManage ordersManage;

	public void setOrdersManage(OrdersManage ordersManage) {
		this.ordersManage = ordersManage;
	}
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Orders> allOrders = new ArrayList<Orders>();
		/*String pageNumberString = request.getParameter("pageNumber");
		if(pageNumberString == null || "".equals(pageNumberString.trim())){
			pageNumberString = "1";
		}
		int pageNumber = Integer.parseInt(pageNumberString);*/
		int pageNumber = 1;
		int pageSize = 20;
		String searchType = request.getParameter("searchType");
		if(searchType == null || "".equals(searchType.trim())){
			searchType = "all";
		}
		if("all".equals(searchType)){
			allOrders = ordersManage.allOrders(pageNumber, pageSize);
		}
		if("isDeal".equals(searchType)){
			allOrders = ordersManage.allOrdersByDeal("1", pageNumber, pageSize);
		}
		if("isNotDeal".equals(searchType)){
			allOrders = ordersManage.allOrdersByDeal("0", pageNumber, pageSize);
		}
		int sequence = (pageNumber-1)*pageSize;
		request.setAttribute("allOrders", allOrders);
		request.setAttribute("sequence", sequence);
		return null;
	}
}
