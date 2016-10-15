package com.shop.common;
//
import org.hibernate.HibernateException;//点号自动提示功能给的是包,这些成员需要另外查看.
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	private static String CONFIG_FILE_LOCATION ="/hibernate.cfg.xml";//自己定义的常量
	private static final ThreadLocal<Session> threadLocal=
			new ThreadLocal<Session>();//实例化ThreadLocal
	private static Configuration configuration=new Configuration();//用hibernate的配置类
	private static SessionFactory sessionFactory;//声明sessionFactory接口,接口没有构造函数,不能靠自己实例化..
	private static String configFile=CONFIG_FILE_LOCATION;
	
	static{
		try{
			configuration.configure(configFile);
			//实例化sessionFactory。       buildSessionFactory();返回的还是一个接口
			sessionFactory = configuration.buildSessionFactory();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private HibernateSessionFactory(){//私有
		//给一个无参数构造函数
	}
	public static Session getSession()throws HibernateException{
		Session session = (Session)threadLocal.get();//先获取容器里的session
		//是否存在session且已经打开,先判断session为空,如果不为空判断有没有打开.
		if(session == null||!session.isOpen()){
			if(sessionFactory == null){
				rebuildSessionfactory();
			}
			//经过创建sessionFactory后,如果工厂不是空,就打开session,并返回,否则返回空的session
			//.openSession()返回的是一个打开的session接口
			session = (sessionFactory != null) ? sessionFactory.openSession()
					:null;//
			threadLocal.set(session);//保存到线程容器
			
		}
		return session;
	}
	public static void rebuildSessionfactory(){
		try{
			configuration.configure(configFile);
			sessionFactory = configuration.buildSessionFactory();//用H里的配置文件的buildSessionFactory方法
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void closeSession() throws HibernateException {
		Session session =(Session)threadLocal.get();//先取得
		threadLocal.set(null);//把线程容器置为空
		if(session != null){//关闭
			session.close();
		}
		
	}
	
   
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	//重新加载配置文件时,要把工厂值为空.
	public static void setConfigFile(String configFile){
		HibernateSessionFactory.configFile = configFile;
		sessionFactory = null;
	}
	public static Configuration getConfiguration(){
		return configuration;
	}
	
	
	
}
