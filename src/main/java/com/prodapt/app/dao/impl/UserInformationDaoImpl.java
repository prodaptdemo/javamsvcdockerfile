package com.prodapt.app.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.prodapt.app.dao.UserInformationDao;
import com.prodapt.app.model.UserInfo;

@Component
public class UserInformationDaoImpl implements UserInformationDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean insertUserInformation(UserInfo userInfo) {
		int isInserted = jdbcTemplate.update("INSERT INTO contactinfo(name, location, phone) VALUES (?,?,?)",
				 userInfo.getName(), userInfo.getLocation(), userInfo.getPhone());
		if(isInserted != 0){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<UserInfo> getUserInformation() {
		List<UserInfo> userInfomrations = new ArrayList<UserInfo>();
		
		String sql = "SELECT * FROM contactinfo";

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		
		for (Map<String, Object> row : rows) {
			UserInfo uInfo = new UserInfo();
			uInfo.setPhone((String) row.get("phone"));
			uInfo.setLocation((String) row.get("location"));
			uInfo.setName((String) row.get("name"));
			userInfomrations.add(uInfo);
		}
		return userInfomrations;

	}

}
