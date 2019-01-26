package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.beans.UserInfo;

public class Test {

	public static void main(String[] args) {

		//创建读取配置文件的对象
		Configuration cfx=new Configuration();
		//读取配置文件
		cfx.configure();  //会默认读取hibernate主配置文件,括号中也可以写上名字
		
		//创建session工厂
		SessionFactory sessionFactory=cfx.buildSessionFactory();
		
		//拿到连接对象session
		Session session=sessionFactory.openSession();
		
		UserInfo userInfo = (UserInfo)session.get(UserInfo.class, 3);
		
		Transaction tx=session.beginTransaction();
		
		//删除
		session.delete(userInfo);
		/*UserInfo user=new UserInfo();
		user.setUserName("测试");
		user.setPassword("123");
		
		session.save(user);   //如果没有事务的话，会产生SQL语句，但是会发生回滚，可以得到当前存入数据的id，数据并没有存到数据库中，
		session.persist(user);//如果没有事务的话，不会产生SQL语句
		 */		
		//提交事务
		tx.commit();
		//关闭资源
		session.close();
		//System.out.println(user.getId()); //注意:当使用save方法时候,最后可以拿到真正的数据库id
		System.out.println("操作成功");
		
	}

}
