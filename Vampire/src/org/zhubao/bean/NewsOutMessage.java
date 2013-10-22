package org.zhubao.bean;
/* 
 * jeasyPro
 * (c) 2012-2013 ____′↘夏悸 <wmails@126.cn>, MIT Licensed
 * http://www.jeasyuicn.com/
 * 2013-8-11 下午3:32:55
 */


import java.util.ArrayList;
import java.util.List;

/**
 * 输出图文消息
 * 
 * 
 */
public class NewsOutMessage extends OutMessage {

	private String			MsgType	= "news";
	private Integer			ArticleCount;
	private List<Articles>	Articles;

	public String getMsgType() {
		return MsgType;
	}

	public int getArticleCount() {
		return ArticleCount;
	}


	public List<Articles> getArticles() {
		return Articles;
	}

	public void setArticles(List<Articles> articles) {
		if (articles != null) {
			if (articles.size() > 10)
				articles = new ArrayList<Articles>(articles.subList(0, 10));

			ArticleCount = articles.size();
		}
		Articles = articles;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public void setArticleCount(Integer articleCount) {
		ArticleCount = articleCount;
	}
	
	
}
