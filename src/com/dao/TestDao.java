package com.dao;

import java.util.List;

import com.beans.UserInfo;

public interface TestDao {

	//��ѯ����
	public List<UserInfo> queryAll();
	//�޸�
	public boolean updateSq(int id,String userName,int versionNo);
}
