package Dao;
import com.shop.beans.Bargain;
import com.shop.beans.Book;
import com.shop.beans.Recommended;
import com.shop.beans.Sex;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.shop.common.HibernateSessionFactory;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
public class BookManage extends HibernateDaoSupport{
	public List<Book> bestSellingBook(int pageNumber,int pageSize){
		Session session = HibernateSessionFactory.getSession();
		String sql= "from Book  where bookSales>0 and bookAmount>0 order by bookSales desc";
		List<Book> bestSellingBook = null;
		try{
			Query query = session.createQuery(sql);
			query.setMaxResults(pageSize);//分为n页，每一页有s个大小。
			query.setFirstResult((pageNumber-1)*pageSize);//设置查询起点。
			bestSellingBook = query.list();
		}catch(RuntimeException re){
			re.printStackTrace();
		}
		HibernateSessionFactory.closeSession();
		return bestSellingBook;
	}
	public Book findBook(int bookId) {
		Session session = HibernateSessionFactory.getSession();
		String sql= "from book where bookid ="+bookId;
		Book book = null;
		try{
			Query query = session.createQuery(sql);
			book = (Book)query.list().get(0);
		}catch(RuntimeException re){
			re.printStackTrace();
		}
		HibernateSessionFactory.closeSession();
		
		return book;
	}
	public Bargain isBargain(int bookId){
		Session session = HibernateSessionFactory.getSession();
		String sql= "from bargain where bookId ="+bookId;
		Bargain bargain = null;
		try{
			Query query = session.createQuery(sql);
			bargain = (Bargain)query.list().get(0);
		}catch(RuntimeException re){
			re.printStackTrace();
		}
		HibernateSessionFactory.closeSession();
		
		return bargain;
	}
	public List<Recommended> allRecommended(int pageNumber,int pageSize) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		String sql= "from Recommended ";
		List<Recommended> listRecmmended=null;
		try{
			Query query = session.createQuery(sql);
			query.setFirstResult((pageNumber-1)*pageSize);
			query.setMaxResults(pageSize);
			listRecmmended=query.list();
			HibernateSessionFactory.closeSession();
		}catch(RuntimeException er){
			er.printStackTrace();
		}
		return listRecmmended;
	}
	public List<Bargain> allBargain(int pageNumber,int pageSize) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		String sql= "from Bargain ";
		List<Bargain> listBargain=null;
		try{
			Query query = session.createQuery(sql);
			query.setFirstResult((pageNumber-1)*pageSize);
			query.setMaxResults(pageSize);
			listBargain=query.list();
			HibernateSessionFactory.closeSession();
		}catch(RuntimeException er){
			er.printStackTrace();
		}
		return listBargain;
	}
	public List<Book> latestBook(int pageNumber,int pageSize) {
		Session session = HibernateSessionFactory.getSession();
		String sql= "from Book as book where book.bookAmount>0 order by book.bookShelveTime desc";
		List<Book> listLatestBook=null;
		try{
			Query query = session.createQuery(sql);
			query.setFirstResult((pageNumber-1)*pageSize);
			query.setMaxResults(pageSize);
			listLatestBook=query.list();
			HibernateSessionFactory.closeSession();
		}catch(RuntimeException er){
			er.printStackTrace();
		}
		return listLatestBook;
	}

}
