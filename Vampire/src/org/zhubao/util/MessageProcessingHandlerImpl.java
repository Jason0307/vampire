package org.zhubao.util;
/**
 * 微信公众平台开发模式(JAVA) SDK
 * (c) 2012-2013 MIT Licensed
 */


import java.util.ArrayList;
import java.util.List;

import org.zhubao.bean.Articles;
import org.zhubao.bean.InMessage;
import org.zhubao.bean.LocationMessage;
import org.zhubao.bean.Music;
import org.zhubao.bean.MusicOutMessage;
import org.zhubao.bean.NewsOutMessage;
import org.zhubao.bean.OutMessage;
import org.zhubao.bean.TextOutMessage;
import org.zhubao.bean.VoiceMessage;

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
		LocationMessage lms = new LocationMessage();
		lms.setLabel(msg.getLabel());
		lms.setLocation_X(msg.getLocationX());
		lms.setLocation_Y(msg.getLocationY());
		lms.setScale(msg.getScale());
		return lms;
	}

	public OutMessage imageTypeMsg(InMessage msg) {
		NewsOutMessage nms = new NewsOutMessage();
		Articles article = new Articles();
		List<Articles> list = new ArrayList<Articles>();
		article.setUrl("http://shiguangji0307.ap01.aws.af.cm");
		article.setDescription("Zhubao");
		article.setPicUrl(msg.getPicUrl());
		article.setTitle("Have a test");
		list.add(article);
		nms.setArticles(list);
		nms.setArticleCount(1);
		return nms;
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
		VoiceMessage vms = new VoiceMessage();
		vms.setMediaId(msg.getMediaId());
		vms.setFormat(msg.getFormat());
		return vms;
	}

	@Override
	public OutMessage musicTypeMsg(InMessage msg) {
		MusicOutMessage mms = new MusicOutMessage();
		Music music = msg.getMusic();
		mms.setMusic(music);
		return mms;
	}

}
