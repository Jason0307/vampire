package org.zhubao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhubao.dao.MessageDAO;
import org.zhubao.model.Message;
import org.zhubao.service.MessageService;

@Service("messageServiceImpl")
public class MessageServiceImpl extends BaseServiceImpl<Message> implements
		MessageService {

	private MessageDAO messageDAO;

	@Autowired
	public void setMessageDAO(MessageDAO messageDAO) {
		this.setBaseDao(messageDAO);
		this.messageDAO = messageDAO;
	}

}
