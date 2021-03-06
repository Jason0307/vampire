package org.zhubao.util;
/**
 * 微信公众平台开发模式(JAVA) SDK
 * (c) 2012-2013 MIT Licensed
 */


import org.zhubao.bean.InMessage;
import org.zhubao.bean.OutMessage;
import org.zhubao.bean.TextOutMessage;

public abstract class DefaultMessageProcessingHandlerImpl implements MessageProcessingHandler{

	private OutMessage allType(InMessage msg){
		TextOutMessage out = new TextOutMessage();
		out.setContent("你的消息已经收到！");
		return out;
	}
	public OutMessage textTypeMsg(InMessage msg) {
		return allType(msg);
	}

	public OutMessage locationTypeMsg(InMessage msg) {
		return allType(msg);
	}

	public OutMessage imageTypeMsg(InMessage msg) {
		return allType(msg);
	}

	public OutMessage linkTypeMsg(InMessage msg) {
		return allType(msg);
	}

	public OutMessage eventTypeMsg(InMessage msg) {
		return allType(msg);
	}

}
