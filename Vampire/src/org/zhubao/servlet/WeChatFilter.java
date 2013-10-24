package org.zhubao.servlet;

/**
 * 微信公众平台开发模式(JAVA) SDK
 * (c) 2012-2013MIT Licensed
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Date;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.zhubao.bean.Articles;
import org.zhubao.bean.InMessage;
import org.zhubao.bean.Music;
import org.zhubao.bean.OutMessage;
import org.zhubao.bean.TextOutMessage;
import org.zhubao.model.TextMessage;
import org.zhubao.util.MessageProcessingHandler;
import org.zhubao.util.Tools;
import org.zhubao.util.XStreamFactory;

import com.thoughtworks.xstream.XStream;

/**
 * 请求拦截
 * 
 * @author GodSon
 * 
 */
public class WeChatFilter implements Filter {

	private final Logger logger = Logger.getLogger(WeChatFilter.class);
	private String _token;
	private String conf = "classPath:wechat.properties";
	private String defaultHandler = "com.gson.inf.DefaultMessageProcessingHandlerImpl";
	private Properties p;

//	private MessageService messageService = (MessageService) BeanUtil.getBean("messageService");
	public void destroy() {
		logger.info("WeChatFilter已经销毁");
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		Boolean isGet = request.getMethod().equals("GET");

		String path = request.getServletPath();
		String pathInfo = path.substring(path.lastIndexOf("/"));

		if (pathInfo == null) {
			response.getWriter().write("error");
		} else {
			_token = pathInfo.substring(1);
			if (isGet) {
				doGet(request, response);
			} else {
				try {
					doPost(request, response);
				} catch (Exception e) {
				}
			}
		}
	}

	private void doPost(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml");

		OutMessage oms = new OutMessage();
		ServletInputStream in = request.getInputStream();
		// 转换微信post过来的xml内容
		XStream xs = XStreamFactory.init(false);
		xs.alias("xml", InMessage.class);
		String xmlMsg = Tools.inputStream2String(in);

		System.out.println("Input:[" + xmlMsg + "]");
		InMessage msg = (InMessage) xs.fromXML(xmlMsg);
		System.out.println("Msg : " + msg);
		String content = msg.getContent();
		// 获取自定消息处理器，如果自定义处理器则使用默认处理器。
		String handler = p.getProperty("MessageProcessingHandlerImpl");
		if (handler == null)
			handler = defaultHandler;

		String type = msg.getMsgType();
		String event = msg.getEvent();
		if (type.equals("event")) {
			if (event.equals("subscribe")) {// 此为关注事件
				content = "您好，欢迎关注我！";
			}
			oms = initTextMessage(msg, content);
		} else if (type.equals("text")) {
			if (content.equals("help") || content.equals("帮助")
					|| content.equals("?") || content.equals("？")) {
				content = "帮助中心\n\n";
			} else if (content.equals("bind") || content.equals("绑定")) {
				content = "点击 <a target=\"_blank\" href=\"\'\'\">绑定账户</a>";
			}else if(content.equals("新闻")){
				    URL newsurl = new URL("http://news.baidu.com/ns?word=title%3A%B2%FA%BF%C6%CA%C2%B9%CA&tn=newsrss&sr=0&cl=2&rn=20&ct=0");  
				    InputStream news=newsurl.openStream();  
	                SAXReader newsReader = new SAXReader();  
	                Document newsdocument = null;
					try {
						newsdocument = newsReader.read(news);
					} catch (DocumentException e) {
						e.printStackTrace();
					}  
					 
	                content = newsdocument.selectSingleNode("/rss/channel/item[3]/description").getText();
			}
			oms = initTextMessage(msg, content);
			TextMessage tms = new TextMessage();
			tms.setContent(content);
			tms.setCreatedDate(oms.getCreateTime());
			tms.setFuncFlag(oms.getFuncFlag());
			tms.setOpenId(oms.getFromUserName());
			tms.setMsgId(msg.getMsgId());
			System.out.println(tms);
			//System.out.println(messageService);
			//messageService.save(tms);
			System.out.println("1234");
		} else if (type.equals("image")) {
			msg.setMsgType("news");
			oms = initMessage(msg, handler);
		}else{
			oms = initMessage(msg, handler);
		}
		// 把发送发送对象转换为xml输出
		xs = XStreamFactory.init(true);
		xs.alias("xml", oms.getClass());
		xs.alias("item", Articles.class);
		xs.alias("music", Music.class);
		String xml = xs.toXML(oms);

		System.out.println("OutPut:[" + xml + "]");
		response.getWriter().write(xml);
		response.getWriter().flush();
	}

	private OutMessage initTextMessage(InMessage msg, String content) {
		OutMessage oms;
		oms = new TextOutMessage();
		((TextOutMessage) oms).setContent(content);
		((TextOutMessage) oms).setMsgType("text");
		try {
			setMsgInfo(oms, msg);
		} catch (Exception e) {
		}
		return oms;
	}

	private OutMessage initMessage(InMessage msg, String handler) {
		OutMessage oms;
		try {
			// 加载处理器
			Class<?> clazz = Class.forName(handler);
			MessageProcessingHandler processingHandler = (MessageProcessingHandler) clazz
					.newInstance();
			// 取得消息类型
			String type = msg.getMsgType();
			Method mt = clazz.getMethod(type + "TypeMsg", InMessage.class);
			oms = (OutMessage) mt.invoke(processingHandler, msg);
			if (oms == null) {
				oms = new TextOutMessage();
				((TextOutMessage) oms).setContent("系统错误!");
			}
			setMsgInfo(oms, msg);
		} catch (Exception e) {
			logger.error(e);
			oms = new TextOutMessage();
			((TextOutMessage) oms).setContent("系统错误!");
			try {
				setMsgInfo(oms, msg);
			} catch (Exception e1) {
				logger.error(e);
			}
		}
		return oms;
	}

	private void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String signature = request.getParameter("signature");// 微信加密签名
		String timestamp = request.getParameter("timestamp");// 时间戳
		String nonce = request.getParameter("nonce");// 随机数
		String echostr = request.getParameter("echostr");//
		// 验证
		if (Tools.checkSignature(_token, signature, timestamp, nonce)) {
			response.getWriter().write(echostr);
		}
	}

	private void setMsgInfo(OutMessage oms, InMessage msg) throws Exception {
		// 设置发送信息
		Class<?> outMsg = oms.getClass().getSuperclass();
		Field CreateTime = outMsg.getDeclaredField("CreateTime");
		Field ToUserName = outMsg.getDeclaredField("ToUserName");
		Field FromUserName = outMsg.getDeclaredField("FromUserName");

		ToUserName.setAccessible(true);
		CreateTime.setAccessible(true);
		FromUserName.setAccessible(true);

		CreateTime.set(oms, new Date().getTime());
		ToUserName.set(oms, msg.getFromUserName());
		FromUserName.set(oms, msg.getToUserName());
	}

	/**
	 * 启动的时候加载wechat.properties配置 可以在过滤器配置wechat.properties路径
	 */
	public void init(FilterConfig config) throws ServletException {
		String cf = config.getInitParameter("conf");
		if (cf != null) {
			conf = cf;
		}
		String classPath = this.getClass().getResource("/").getPath()
				.replaceAll("%20", " ");
		conf = conf.replace("classPath:", classPath);
		p = new Properties();
		File pfile = new File(conf);
		if (pfile.exists()) {
			try {
				p.load(new FileInputStream(pfile));
			} catch (FileNotFoundException e) {
				logger.error("未找到wechat.properties", e);
			} catch (IOException e) {
				logger.error("wechat.properties读取异常", e);
			}
		}
		
		logger.info("WeChatFilter已经启动！");
	}

}
