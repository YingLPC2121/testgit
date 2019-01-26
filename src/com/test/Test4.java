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
		t1.setTeaName("张老师");
		Teacher t2 = new Teacher();
		t2.setTeaName("钱老师");
		
		Student stu1 = new Student();
		stu1.setStuName("李同学");
		Student stu2 = new Student();
		stu2.setStuName("孙同学");
		Student stu3 = new Student();
		stu3.setStuName("王同学");
		
		Set<Student> stuSet = new HashSet<Student>();
		stuSet.add(stu1);
		stuSet.add(stu2);
		stuSet.add(stu3);
		
		//建立维护关系  --- 老师对学生
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
