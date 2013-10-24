package org.zhubao.service;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zhubao.model.TextMessage;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = "classpath:applicationContext.xml")  
public class MessageServiceTest {

	@Autowired
	private MessageService messageService;
	
	@Test
	public void save() throws Exception{
		TextMessage tms = new TextMessage();
		tms.setContent("test");
		tms.setCreatedDate(new Date().getTime());
		tms.setFuncFlag(0);
		tms.setOpenId("hhhhhh");
		tms.setMsgId(12L);
		messageService.save(tms);
		
	}
	
	
	
}
