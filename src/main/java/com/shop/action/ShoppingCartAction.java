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
		String bookId = request.getParameter("bookId");//��ȡҳ�洫����servlet parameter
		List<Book> shoppingBook = new ArrayList<Book>();
		if(session.getAttribute("shoppingBook")==null){
			session.setAttribute("shoppingBook", shoppingBook);//û�й�����Ϣ������һ�������ǿյ�ArrayList<Book>
		}else{
			shoppingBook = (List<Book>)session.getAttribute("shoppingBook");
		}
		int i = 0;
		for(Book book :shoppingBook){//����û���Ҫ���빺�ﳵ�����Ѿ����ˣ�ֱ������ԭҳ��
			if(bookId.equals(book.getBookid()+"")){
				i++;//���߼����������ò�����������
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
				session.removeAttribute("totalMoney");//�޸��ܽ��sessionֵ--��ȥ��������
				session.setAttribute("totalMoney", totalMoney);
			}
			session.removeAttribute("shoppingBook");
			session.setAttribute("shoppingBook", shoppingBook);
		}
		try{
			response.sendRedirect("../singleBook.jsp?bookId="+bookId);//����ԭҳ�档����session���ܽ��鵥shoppingBook
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
