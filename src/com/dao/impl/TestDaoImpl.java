package com.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.StaleObjectStateException;

import com.beans.UserInfo;
import com.dao.TestDao;
import com.util.HibUtil;

public class TestDaoImpl implements TestDao {

	@Override
	public List<UserInfo> queryAll() {
		Session s = HibUtil.getSession();
		String hql = "from UserInfo";  //ªÚ’ﬂ”√from UserInfo
		return s.createQuery(hql).list();
	}

	@Override
	public boolean updateSq(int id,String userName,int versionNo) {
		return false;
	}

}
