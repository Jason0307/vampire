package org.zhubao.util;
/**
 * 微信公众平台开发模式(JAVA) SDK
 * (c) 2012-2013 MIT Licensed
 */


import org.zhubao.bean.ImageOutMessage;
import org.zhubao.bean.InMessage;
import org.zhubao.bean.OutMessage;
import org.zhubao.bean.TextOutMessage;

/**
 * 自定义实现消息处理
 *
 */
public class MessageProcessingHandlerImpl implements MessageProcessingHandler {

	public OutMessage textTypeMsg(InMessage msg) {
		TextOutMessage oms = new TextOutMessage();
		oms.setContent(msg.getContent());
		return oms;
	}

	public OutMessage locationTypeMsg(InMessage msg) {
		// TODO Auto-generated method stub
		return null;
	}

	public OutMessage imageTypeMsg(InMessage msg) {
		ImageOutMessage ims = new ImageOutMessage();
		ims.setPicUrl(msg.getPicUrl());
		return ims;
	}

	public OutMessage linkTypeMsg(InMessage msg) {
		// TODO Auto-generated method stub
		return null;
	}

	public OutMessage eventTypeMsg(InMessage msg) {
		// TODO Auto-generated method stub
		return null;
	}

	public OutMessage voiceTypeMsg(InMessage msg) {
		// TODO Auto-generated method stub
		return null;
	}

}
