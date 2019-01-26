package com.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.beans.Student;
import com.beans.Teacher;
import com.util.HibUtil;

public class Test4 {

	public static void main(String[] args) {
		
		Teacher t1 = new Teacher();
		t1.setTeaName("����ʦ");
		Teacher t2 = new Teacher();
		t2.setTeaName("Ǯ��ʦ");
		
		Student stu1 = new Student();
		stu1.setStuName("��ͬѧ");
		Student stu2 = new Student();
		stu2.setStuName("��ͬѧ");
		Student stu3 = new Student();
		stu3.setStuName("��ͬѧ");
		
		Set<Student> stuSet = new HashSet<Student>();
		stuSet.add(stu1);
		stuSet.add(stu2);
		stuSet.add(stu3);
		
		//����ά����ϵ  --- ��ʦ��ѧ��
		t1.setStuSet(stuSet);
		t2.setStuSet(stuSet);
		
		Session s = HibUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.save(t1);
		s.save(t2);
		s.save(stu1);
		s.save(stu2);
		s.save(stu3);
		tx.commit();
		s.close();
	}

}
