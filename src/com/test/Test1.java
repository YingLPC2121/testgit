package com.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.beans.UserInfo;
import com.util.HibUtil;

//��ѯ
public class Test1 {

	public static void main(String[] args) {

		/*UserInfo user = queryTest02(); 
		System.out.println(user.getPassword());*/
		
		/*UserInfo userInfo = queryOne();
		System.out.println(userInfo.getId());*/
		
		/*List<UserInfo> userList = queryAll();
		for(UserInfo u:userList){
			System.out.println(u.getId());
		}*/
		
		//queryAll1(); //һ��SQL���
		//queryAll2(); //n+1��SQL���
		query1();
		
	}

	//Criteria �ӿڽ��в�ѯ
	public static void query1(){
		Session s = HibUtil.getSession();
		Criteria c = s.createCriteria(UserInfo.class);
		c.add(Restrictions.eq("userName", "����2"));
		c.add(Restrictions.eq("password", "123"));
		UserInfo userInfo = (UserInfo)c.uniqueResult();
		System.out.println(userInfo);
		
	}
	
	
	public static UserInfo queryTest01(){
		Session s = null;
		try{
			s = HibUtil.getSession();
			UserInfo user = (UserInfo)s.get(UserInfo.class, 1);
			System.out.println(user.getUserName());
			return user;
		}finally{
			HibUtil.close(s);
		}
	}
	
	public static UserInfo queryTest02(){
		Session s = null;
		try{
			s = HibUtil.getSession();
			UserInfo user = (UserInfo)s.load(UserInfo.class, 1);
			//System.out.println(user.getUserName()); // org.hibernate.LazyInitializationException: could not initialize proxy - no Session �����س�ʼ���쳣
			return user; //���ص��Ǵ�����󣬲�����ʵ����
		}finally{
			HibUtil.close(s);
		}
	}
	
	//��ѯ����
	public static UserInfo queryOne(){
		Session s = HibUtil.getSession();
		String hql = "select u from UserInfo u where u.userName=? and u.password=?";
		return (UserInfo)s.createQuery(hql).setParameter(0, "456").setParameter(1, "456").uniqueResult();
	}
	//��ѯ����
	public static List<UserInfo> queryAll(){
		Session s = HibUtil.getSession();
		String hql = "select u from UserInfo u";  //������from UserInfo
		return s.createQuery(hql).list();
	}
	
	//��ѯ���� -- List
	public static void queryAll1(){
		Session s = HibUtil.getSession();
		String hql = "select u from UserInfo u";  //������from UserInfo
		Query q = s.createQuery(hql);
		List<UserInfo> userList = q.list();
		Iterator<UserInfo> item = userList.iterator();
		while(item.hasNext()){
			UserInfo userInfo = item.next();
			System.out.println(userInfo);
		}
	}
	
	//��ѯ���� -- Iterator
	public static void queryAll2(){
		Session s = HibUtil.getSession();
		String hql = "select u from UserInfo u";  //������from UserInfo
		Query q = s.createQuery(hql);
		Iterator<UserInfo> item = q.iterate();
		while(item.hasNext()){
			UserInfo userInfo = item.next();
			System.out.println(userInfo);
		}
		HibUtil.close(s);
	}
}
