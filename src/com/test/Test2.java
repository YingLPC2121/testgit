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

	//多对一例子
		/*NiGuAn niguan = new NiGuAn();
		niguan.setName("峨眉");
		
		NiGu nigu1 = new NiGu();
		nigu1.setFaHao("灭绝");
		//建立起两个对象的关联
		//nigu1.setNiguan(niguan);
		
		Session s = HibUtil.getSession();
		//开启事务
		Transaction tx = s.beginTransaction();
		
		s.save(niguan);
		s.save(nigu1);	
		tx.commit();
		s.close();*/
		
	//一对多例子
		NiGu nigu1 = new NiGu();
		nigu1.setFaHao("灭绝111");
		
		NiGu nigu2 = new NiGu();
		nigu2.setFaHao("灭绝222");
		
		/*Set<NiGu> niguSet = new HashSet<NiGu>();
		niguSet.add(nigu1);
		niguSet.add(nigu2);*/
		List<NiGu> niguList = new ArrayList<NiGu>();
		niguList.add(nigu1);
		niguList.add(nigu2);
		
		NiGuAn niguan = new NiGuAn();
		niguan.setName("峨眉11");
		//建立关系
		//niguan.setNiguSet(niguSet);
		niguan.setNiguList(niguList);
		
		Session s = HibUtil.getSession();
		//开启事务
		Transaction tx = s.beginTransaction();
		
		s.save(niguan);
		s.save(nigu1);	
		s.save(nigu2);
		tx.commit();
		s.close();
	}

}
