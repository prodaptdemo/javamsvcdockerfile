package com.prodapt.app.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.prodapt.app.model.UserInfo;

@Component
public interface UserInformationDao {

	public boolean insertUserInformation(UserInfo userInfo);

	public List<UserInfo> getUserInformation();
}
