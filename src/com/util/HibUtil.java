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
		//创建读取配置文件的对象
		Configuration cfx=new Configuration();
		//读取配置文件
		cfx.configure();  //会默认读取hibernate主配置文件,括号中也可以写上名字
		//创建session工厂
		sessionFactory=cfx.buildSessionFactory();
	}
	
	//得到session
	public static Session getSession(){
		return sessionFactory.openSession();
	}
	
	//得到工厂
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	//关闭资源
	public static void close(Session s){
		//避免出现空指针异常
		if(s!=null){
			s.close();
		}
	}
	
	//标准的添加方法
	public static int add(Object obj){
		Session session = null;
		Transaction tx = null;
		Serializable sli = null;
		try{
			session = HibUtil.getSession();
			tx = session.beginTransaction();
			sli = session.save(obj); //返回值为当前数据库id
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
