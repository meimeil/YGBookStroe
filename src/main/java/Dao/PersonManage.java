package Dao;
import java.util.*;
import com.shop.common.HibernateSessionFactory;
import org.hibernate.Session;
//import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shop.beans.Sex;
import com.shop.beans.User;

public class PersonManage extends HibernateDaoSupport{

	
	public int addUser(User user){//注册新用户
		Session session =HibernateSessionFactory.getSession();//1
		Transaction tx = null;
		int i =0;
		try{
			tx = session.beginTransaction();//2
			session.save(user);//3
			i = 1;
			tx.commit();//4
		}catch(RuntimeException re){
			tx.rollback();//5
			throw re;//6
		}
		HibernateSessionFactory.closeSession();//7
		return i;
	}
	public boolean isUserNameExist(String userName){
		Session session = HibernateSessionFactory.getSession();
		//Transaction 查询就不需要事务
		boolean flag = true;
		String hql = "from User as user where user.userName = '"+userName+"'";
		try{
			List<User> userList = session.createQuery(hql).list();//查询存在.  就不用get傻,用list方法返回一个List集合
			if(userList.size()==0){//不equals,只要查到的list有size不为0
				flag = false;
			}
			HibernateSessionFactory.closeSession();
			return flag ;
		}catch(RuntimeException re){
			throw re;
		}
	}
	public Sex findSex(int i) {
		Sex sex1=new Sex(i,"默认性别");
		
		return sex1;
	}
}
