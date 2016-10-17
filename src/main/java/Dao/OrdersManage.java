package Dao;
import com.shop.beans.Orders;
import com.shop.beans.Ordersbook;
import com.shop.common.HibernateSessionFactory;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class OrdersManage {
	//����һ������
	public int addOrders(Orders orders){
		Session session = HibernateSessionFactory.getSession();
		Transaction tx =null;
		int i =0;
		try{
			tx=session.beginTransaction();
			session.save(orders);
			String sql="select max(orderId)from Orders";
			List<Integer> idList = session.createQuery(sql).list();
			if(idList.size()>0){
				i=idList.get(0);
			}
			tx.commit();
		}catch(RuntimeException re){
			re.printStackTrace();
			tx.rollback();
		}
		HibernateSessionFactory.closeSession();
		return i;
	}
	//ɾ��һ������
	public int deleteOrders(int ordersId) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null;
		int i = 0;
		try{
			tx = session.beginTransaction();
			session.delete(session.get("com.shop.beans.Orders", ordersId));
			i = 1;
			tx.commit();
		}catch(RuntimeException re){
			re.printStackTrace();
			tx.rollback();
		}
		session.close();
		return i ;
		
	}
	
	//����ID��ѯ����
	public Orders findOrders(int ordersId) {
		Session session = HibernateSessionFactory.getSession();
		try{
			Orders orders = (Orders)session.get("com.shop.beans.Orders", ordersId);
			return orders;
		}catch(RuntimeException re){
			throw re;
		}finally{
			session.close();
		}
	}
	
	

	//�޸Ķ���
		public void updateOrders(Orders orders){
			Session session = HibernateSessionFactory.getSession();
			Transaction  tx = null;
			try{
				tx = session.beginTransaction();
				session.update(orders);
				tx.commit();
			}catch(RuntimeException re){
				re.printStackTrace();
				tx.rollback();
			}
			session.close();
		}
		//���һ������ͼ����Ϣ
		public void addOrdersbook(Ordersbook ordersbook) {
			Session session = HibernateSessionFactory.getSession();
			Transaction tx = null;
			try{
				tx = session.beginTransaction();
				session.save(ordersbook);
				tx.commit();
			}catch (RuntimeException re) {
				
				tx.rollback();
				throw re;
			}finally{
				session.close();
			}
		}
		//����userId,��������״̬��ȡ���û����ж���
		public List<Orders> allOrdersByDeal(final String isDeal,final int pageNumber,final int pageSize){
			Session session = HibernateSessionFactory.getSession();
			String hql = "from Orders as orders where orders.isDeal = '"+isDeal+"' order by ordersTime desc";
			Query query = session.createQuery(hql);
			query.setFirstResult((pageNumber-1)*pageSize);
			query.setMaxResults(pageSize);
			List<Orders> list = query.list();
			session.close();
			return list;
		}
		//����userId��ȡ���û����ж���
		@SuppressWarnings("unchecked")
		public List<Orders> allOrdersByUser(int userId,int pageNumber,int pageSize){
			Session session = HibernateSessionFactory.getSession();
			String hql = "from Orders as orders where orders.user.userId="+userId+" order by ordersTime desc";
			try{
				List<Orders> allOrdersByUser = session.createQuery(hql).list();
				session.close();
				return allOrdersByUser;
			}catch(RuntimeException re){
				throw re;
			}
		}
		//����ordersId��ȡ�ö������ж���ͼ��
		@SuppressWarnings("unchecked")
		public List<Ordersbook> allOrdersbookByOrders(int ordersId){
			Session session = HibernateSessionFactory.getSession();
			String hql = "from Ordersbook as ordersbook where ordersbook.orders.ordersId="+ordersId;
			try{
				List<Ordersbook> allOrdersbookByOrders = session.createQuery(hql).list();
				session.close();
				return allOrdersbookByOrders;
			}catch(RuntimeException re){
				throw re;
			}
		}
		//��ѯ���ж���
		@SuppressWarnings("unchecked")
		public List<Orders> allOrders(final int pageNumber,final int pageSize){
			Session session = HibernateSessionFactory.getSession();//Session session = sessionFactory.openSession();
			String hql = "from Orders as orders order by ordersTime desc";
			List<Orders> allOrders = null;
			try {
				Query query = session.createQuery(hql);
				query.setFirstResult((pageNumber-1)*pageSize);
				query.setMaxResults(pageSize);
				allOrders = query.list();
			} catch (Exception e) {
				e.printStackTrace();
			}
			session.close();
			return allOrders;
		}
}
