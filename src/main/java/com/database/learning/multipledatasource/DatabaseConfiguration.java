package com.database.learning.multipledatasource;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatabaseConfiguration {
	
	/*
	 * @Bean("dbProfileService")
	 * 
	 * @ConfigurationProperties("spring.db-profile-service")
	 * 
	 * @Primary public HikariDataSource createProfileDataSource() { return
	 * DataSourceBuilder.create().type(HikariDataSource.class).build(); }
	 * 
	 * @Bean("dbTaskService")
	 * 
	 * @ConfigurationProperties("spring.db-task-service") public HikariDataSource
	 * createTaskServiceDataSource() { return
	 * DataSourceBuilder.create().type(HikariDataSource.class).build(); }
	 */

	@Bean("dbProfileService")
	@ConfigurationProperties("spring.db-profile-service")
	@Primary
	public DataSource createProfileDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean("dbTaskService")
	@ConfigurationProperties("spring.db-task-service")
	public DataSource createTaskServiceDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	
	@Bean("jdbcProfileService")
	@Autowired
	public JdbcTemplate jdbcTemplateForProfileService(@Qualifier("dbProfileService") DataSource profileServiceDS) {
		return new JdbcTemplate(profileServiceDS);
	}
	
	@Bean("jdbcTaskService")
	@Autowired
	public JdbcTemplate jdbcTemplateForTaskService(@Qualifier("dbTaskService") DataSource taskServiceDS) {
		return new JdbcTemplate(taskServiceDS);				
	}
	
	
	
	
	
}
