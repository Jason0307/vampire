package org.zhubao.dao;

import org.hibernate.Session;
import org.junit.Test;
import org.zhubao.model.ImageMessage;
import org.zhubao.util.HibernateSessionFactory;

public class DaoTest {
	
	
	@Test
	public void add(){
		
		Session session = HibernateSessionFactory.getSession();
		ImageMessage ims = new ImageMessage();
		ims.setPicUrl("http://www.aa.jpg");
		session.beginTransaction();
		session.save(ims);
		session.getTransaction().commit();
		
	}
}
