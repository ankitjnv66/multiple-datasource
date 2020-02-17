package com.database.learning.multipledatasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataSourceRestController {

	@Autowired
	private ProfileServiceDAO profileSvcsDAO;
	
	@Autowired
	private TaskServiceDAO taskSvcsDAO;
	
	@GetMapping("/user-count")
	public String userCOuntFormProfileService() {
		return "count from user table is : "+profileSvcsDAO.getCount();
	}
	
	@GetMapping("/task-count")
	public String taskCountFromTaskService() {
		return "count from task table is : "+taskSvcsDAO.getCount();
	}
}
