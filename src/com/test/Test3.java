package com.test;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import com.beans.NiGu;
import com.util.HibUtil;

public class Test3 {

	public static void main(String[] args) {
		NiGu nigu = searchNiGu2();
		System.out.println(nigu.getFaHao());
		//System.out.println(nigu.getNiguan().getName()); //���ֱ�ӵõ���������ֵĻ�����������س�ʼ���쳣

	}

	public static NiGu searchNiGu1(){
		/*Session s = HibUtil.getSession();
		NiGu nigu = (NiGu) s.get(NiGu.class, 1);
		//������sessionû�ر�֮ǰ,ʹ������,��ѹ����Ĵ��������г�ʼ��,��session֮����ʱ��,û���κ�����
		System.out.println(nigu.getNiguan().getName());
		HibUtil.close(s);
		return nigu;*/
		
		return null;
		
	}
	
	public static NiGu searchNiGu2(){
		/*Session s = HibUtil.getSession();
		NiGu nigu = (NiGu) s.get(NiGu.class, 1);
		//������֪ͨHinernateֱ�Ӱѹ��������ݲ����
		Hibernate.initialize(nigu.getNiguan());
		HibUtil.close(s);
		return nigu;*/
		
		return null;
	}
}
