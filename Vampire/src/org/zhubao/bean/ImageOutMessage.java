package org.zhubao.bean;

public class ImageOutMessage extends OutMessage {

	private String MsgType = "image";
	private String picUrl;

	public ImageOutMessage() {
		super();
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

}
