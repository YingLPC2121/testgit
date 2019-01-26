package com.util;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.beans.UserInfo;

public class HibUtil {

	private static SessionFactory sessionFactory;
	
	static{
		//������ȡ�����ļ��Ķ���
		Configuration cfx=new Configuration();
		//��ȡ�����ļ�
		cfx.configure();  //��Ĭ�϶�ȡhibernate�������ļ�,������Ҳ����д������
		//����session����
		sessionFactory=cfx.buildSessionFactory();
	}
	
	//�õ�session
	public static Session getSession(){
		return sessionFactory.openSession();
	}
	
	//�õ�����
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	//�ر���Դ
	public static void close(Session s){
		//������ֿ�ָ���쳣
		if(s!=null){
			s.close();
		}
	}
	
	//��׼����ӷ���
	public static int add(Object obj){
		Session session = null;
		Transaction tx = null;
		Serializable sli = null;
		try{
			session = HibUtil.getSession();
			tx = session.beginTransaction();
			sli = session.save(obj); //����ֵΪ��ǰ���ݿ�id
			tx.commit();
			//System.out.println("id="+sli);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			HibUtil.close(session);
		}
		return (Integer)sli;
	}
	
	public static Object get(Class clazz,Serializable id){
		Session s=null;
		try{
			s=HibUtil.getSession();
			return s.get(clazz, id);
		}finally{
			HibUtil.close(s);
		}
	}
	
	public static void update(Object obj){
		Session s=null;
		Transaction tx = null;
		try{
			s=HibUtil.getSession();
			tx = s.beginTransaction();
			s.update(obj);
			tx.commit();
		}finally{
			HibUtil.close(s);
		}
	}
	/*
	public static void main(String[] args) {
		UserInfo user = new UserInfo();
		user.setUserName("456");
		user.setPassword("456");
		
		System.out.println(HibUtil.add(user));
	}
*/
	
	
	
	
	
	
	
}
