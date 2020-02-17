package com.database.learning.multipledatasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileServiceDAO {

	@Qualifier("jdbcProfileService")
	@Autowired
	private JdbcTemplate profileServieTemplate;
	
	public int getCount() {
		return profileServieTemplate.queryForObject("select count(*) from users", Integer.class);
	}
}
