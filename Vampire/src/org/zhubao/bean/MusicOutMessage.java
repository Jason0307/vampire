package org.zhubao.bean;
/* 
 * jeasyPro
 * (c) 2012-2013 ____′↘夏悸 <wmails@126.cn>, MIT Licensed
 * http://www.jeasyuicn.com/
 * 2013-8-11 下午3:32:28
 */


/**
 * 输出音乐消息
 * 
 * 
 */
public class MusicOutMessage extends OutMessage {
	private String	MsgType	= "music";
	private Music Music;

	public String getMsgType() {
		return MsgType;
	}

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	
}
