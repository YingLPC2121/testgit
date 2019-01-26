package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.beans.UserInfo;

public class Test {

	public static void main(String[] args) {

		//������ȡ�����ļ��Ķ���
		Configuration cfx=new Configuration();
		//��ȡ�����ļ�
		cfx.configure();  //��Ĭ�϶�ȡhibernate�������ļ�,������Ҳ����д������
		
		//����session����
		SessionFactory sessionFactory=cfx.buildSessionFactory();
		
		//�õ����Ӷ���session
		Session session=sessionFactory.openSession();
		
		UserInfo userInfo = (UserInfo)session.get(UserInfo.class, 3);
		
		Transaction tx=session.beginTransaction();
		
		//ɾ��
		session.delete(userInfo);
		/*UserInfo user=new UserInfo();
		user.setUserName("����");
		user.setPassword("123");
		
		session.save(user);   //���û������Ļ��������SQL��䣬���ǻᷢ���ع������Եõ���ǰ�������ݵ�id�����ݲ�û�д浽���ݿ��У�
		session.persist(user);//���û������Ļ����������SQL���
		 */		
		//�ύ����
		tx.commit();
		//�ر���Դ
		session.close();
		//System.out.println(user.getId()); //ע��:��ʹ��save����ʱ��,�������õ����������ݿ�id
		System.out.println("�����ɹ�");
		
	}

}
