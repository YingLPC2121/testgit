package com.test;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import com.beans.NiGu;
import com.util.HibUtil;

public class Test3 {

	public static void main(String[] args) {
		NiGu nigu = searchNiGu2();
		System.out.println(nigu.getFaHao());
		//System.out.println(nigu.getNiguan().getName()); //如果直接得到尼姑庵名字的话会出现懒加载初始化异常

	}

	public static NiGu searchNiGu1(){
		/*Session s = HibUtil.getSession();
		NiGu nigu = (NiGu) s.get(NiGu.class, 1);
		//这样在session没关闭之前,使用以下,会把关联的代理对象进行初始化,在session之外在时候,没有任何问题
		System.out.println(nigu.getNiguan().getName());
		HibUtil.close(s);
		return nigu;*/
		
		return null;
		
	}
	
	public static NiGu searchNiGu2(){
		/*Session s = HibUtil.getSession();
		NiGu nigu = (NiGu) s.get(NiGu.class, 1);
		//主动的通知Hinernate直接把关联的数据查出来
		Hibernate.initialize(nigu.getNiguan());
		HibUtil.close(s);
		return nigu;*/
		
		return null;
	}
}
