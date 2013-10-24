package org.zhubao.dao;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class TableCreate {

	@Test
	public void createTable(){
		
		new SchemaExport(new Configuration().configure("hibernate.xml")).create(true, true);
		
		
	}
}
