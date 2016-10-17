package Dao;
import java.util.*;
import com.shop.common.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shop.beans.Manager;
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
	public Sex findSex(int sexId) {
		Session session = HibernateSessionFactory.getSession();
		String hql = "from Sex as sex where sex.sexid ='"+sexId+"'";
		Sex sex=null;
		try{
			List<Sex> l= session.createQuery(hql).list();
			if(l.size() > 0){
				sex = l.get(0);
			}
			HibernateSessionFactory.closeSession();
		}catch(RuntimeException re){
			re.printStackTrace();
		}
		return sex;
	}
	//普通用户登录验证
		@SuppressWarnings("unchecked")
		public User checkUser(String userName,String userPassword){
			Session session = HibernateSessionFactory.getSession();
			String hql = "from User as user where user.userName = '"+userName+"' and user.userPassword = '"+userPassword+"'";
			User user = null;
			try{
				List<User> userList = session.createQuery(hql).list();
				if(userList.size() > 0){
					user = new User();
					user = userList.get(0);
				}
				HibernateSessionFactory.closeSession();
			}catch(RuntimeException re){
				re.printStackTrace();
			}
			
			return user;
		}
		//管理员登录验证
		@SuppressWarnings("unchecked")
		public boolean checkManager(String managerName,String managerPassword){
			Session session = HibernateSessionFactory.getSession();
			boolean flag = false;
			String hql = "from Manager as manager where manager.managerName = '"+managerName+"' and manager.managerPassword = '"+managerPassword+"'";
			List<Manager> managerList = session.createQuery(hql).list();
			if(managerList.size()>0){
				flag = true;
			}
			HibernateSessionFactory.closeSession();
			return flag;
		}
		//获取用户信息??meiyong
		public User findUser(int userId){
			User user = null;
			Session session = HibernateSessionFactory.getSession();
			try{
				user = (User)session.get("com.shop.beans.User", userId);
				HibernateSessionFactory.closeSession();
				return user;
			}catch(RuntimeException re){
				throw re;
			}
		}
		//修改一条用户信息
		public int updateUserInfor(User user){
			Session session = HibernateSessionFactory.getSession();
			Transaction tx = null;
			int i = 0;
			try{
				tx = session.beginTransaction();
				session.update(user);
				i = 1;
				tx.commit();
			}catch (RuntimeException re) {
				tx.rollback();
				throw re;
			}
			session.close();
			return i;
		}
}
