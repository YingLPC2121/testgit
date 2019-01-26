package com.dao;

import java.util.List;

import com.beans.UserInfo;

public interface TestDao {

	//查询所有
	public List<UserInfo> queryAll();
	//修改
	public boolean updateSq(int id,String userName,int versionNo);
}
