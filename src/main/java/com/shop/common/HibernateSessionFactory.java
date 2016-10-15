package com.shop.common;
//
import org.hibernate.HibernateException;//����Զ���ʾ���ܸ����ǰ�,��Щ��Ա��Ҫ����鿴.
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	private static String CONFIG_FILE_LOCATION ="/hibernate.cfg.xml";//�Լ�����ĳ���
	private static final ThreadLocal<Session> threadLocal=
			new ThreadLocal<Session>();//ʵ����ThreadLocal
	private static Configuration configuration=new Configuration();//��hibernate��������
	private static SessionFactory sessionFactory;//����sessionFactory�ӿ�,�ӿ�û�й��캯��,���ܿ��Լ�ʵ����..
	private static String configFile=CONFIG_FILE_LOCATION;
	
	static{
		try{
			configuration.configure(configFile);
			//ʵ����sessionFactory��       buildSessionFactory();���صĻ���һ���ӿ�
			sessionFactory = configuration.buildSessionFactory();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private HibernateSessionFactory(){//˽��
		//��һ���޲������캯��
	}
	public static Session getSession()throws HibernateException{
		Session session = (Session)threadLocal.get();//�Ȼ�ȡ�������session
		//�Ƿ����session���Ѿ���,���ж�sessionΪ��,�����Ϊ���ж���û�д�.
		if(session == null||!session.isOpen()){
			if(sessionFactory == null){
				rebuildSessionfactory();
			}
			//��������sessionFactory��,����������ǿ�,�ʹ�session,������,���򷵻ؿյ�session
			//.openSession()���ص���һ���򿪵�session�ӿ�
			session = (sessionFactory != null) ? sessionFactory.openSession()
					:null;//
			threadLocal.set(session);//���浽�߳�����
			
		}
		return session;
	}
	public static void rebuildSessionfactory(){
		try{
			configuration.configure(configFile);
			sessionFactory = configuration.buildSessionFactory();//��H��������ļ���buildSessionFactory����
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void closeSession() throws HibernateException {
		Session session =(Session)threadLocal.get();//��ȡ��
		threadLocal.set(null);//���߳�������Ϊ��
		if(session != null){//�ر�
			session.close();
		}
		
	}
	
   
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	//���¼��������ļ�ʱ,Ҫ�ѹ���ֵΪ��.
	public static void setConfigFile(String configFile){
		HibernateSessionFactory.configFile = configFile;
		sessionFactory = null;
	}
	public static Configuration getConfiguration(){
		return configuration;
	}
	
	
	
}
