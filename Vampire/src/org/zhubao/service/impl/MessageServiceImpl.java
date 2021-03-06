package org.zhubao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zhubao.dao.MessageDAO;
import org.zhubao.model.Message;
import org.zhubao.service.MessageService;

@Service("messageServiceImpl")
@Transactional(rollbackFor=Exception.class)
public class MessageServiceImpl extends BaseServiceImpl<Message> implements
		MessageService {

	private MessageDAO messageDAO;

	@Autowired
	public void setMessageDAO(MessageDAO messageDAO) {
		this.setBaseDao(messageDAO);
		this.messageDAO = messageDAO;
	}

}
