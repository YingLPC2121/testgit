package com.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.beans.NiGu;
import com.beans.NiGuAn;
import com.util.HibUtil;

public class Test2 {

	public static void main(String[] args) {

	//���һ����
		/*NiGuAn niguan = new NiGuAn();
		niguan.setName("��ü");
		
		NiGu nigu1 = new NiGu();
		nigu1.setFaHao("���");
		//��������������Ĺ���
		//nigu1.setNiguan(niguan);
		
		Session s = HibUtil.getSession();
		//��������
		Transaction tx = s.beginTransaction();
		
		s.save(niguan);
		s.save(nigu1);	
		tx.commit();
		s.close();*/
		
	//һ�Զ�����
		NiGu nigu1 = new NiGu();
		nigu1.setFaHao("���111");
		
		NiGu nigu2 = new NiGu();
		nigu2.setFaHao("���222");
		
		/*Set<NiGu> niguSet = new HashSet<NiGu>();
		niguSet.add(nigu1);
		niguSet.add(nigu2);*/
		List<NiGu> niguList = new ArrayList<NiGu>();
		niguList.add(nigu1);
		niguList.add(nigu2);
		
		NiGuAn niguan = new NiGuAn();
		niguan.setName("��ü11");
		//������ϵ
		//niguan.setNiguSet(niguSet);
		niguan.setNiguList(niguList);
		
		Session s = HibUtil.getSession();
		//��������
		Transaction tx = s.beginTransaction();
		
		s.save(niguan);
		s.save(nigu1);	
		s.save(nigu2);
		tx.commit();
		s.close();
	}

}
