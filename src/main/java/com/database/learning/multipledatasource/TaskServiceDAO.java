package com.database.learning.multipledatasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TaskServiceDAO {

	@Qualifier("jdbcTaskService")
	@Autowired
	private JdbcTemplate profileServiceTemplate;
	
	
	public int getCount() {
		return profileServiceTemplate.queryForObject("select count(*) from tasks", Integer.class);
	}
}
