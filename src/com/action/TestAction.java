package com.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.StaleObjectStateException;

import com.beans.UserInfo;
import com.util.HibUtil;

public class TestAction {

	private int id;
	private String userName;
	private int versionNo;

	public String update() {

		UserInfo user = (UserInfo) ServletActionContext.getRequest()
				.getSession().getAttribute("user");
		try {
			user.setUserName(userName);
			HibUtil.update(user);
			return "updateSuccess";
		} catch (StaleObjectStateException e) {
			System.out.println("数据已被修改,请放弃修改或者重新修改");
		}

		return "error";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(int versionNo) {
		this.versionNo = versionNo;
	}

}
