package com.prodapt.app.model;

import java.util.List;

public class UserInfoResponse {

	private List<UserInfo> result;

	public List<UserInfo> getUserInfos() {
		return result;
	}

	public void setUserInfos(List<UserInfo> userInfos) {
		this.result = userInfos;
	}
	
}
