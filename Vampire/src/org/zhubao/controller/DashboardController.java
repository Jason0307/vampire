/**
 * 
 */
package org.zhubao.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zhubao.model.UserLine;
import org.zhubao.service.MailService;
import org.zhubao.service.UserLineService;

/**
 * @author Jason.Zhu
 * @date   2013-10-31
 * @email jasonzhu@augmentum.com.cn
 */
@Controller
public class DashboardController {

	@Autowired
	private MailService mailServiceImpl;
	@Autowired
	private UserLineService userLineServiceImpl;
	
	@RequestMapping(value = {"/index","/"},method = RequestMethod.GET)
	public String dashboard(){
		return "index";
	}
	
	@RequestMapping(value = {"/email/send"},method = RequestMethod.POST)
	public void sendMessage(String name,String email,String message,HttpServletResponse response,HttpServletRequest request) throws Exception{
	    
		
		System.out.println("No UTF-8 : "+message);
		request.setCharacterEncoding("UTF-8");
		System.out.println("Already UTF-8 :" + message);
		int status = 1;
		mailServiceImpl.sendEmail(email, "Message From "+name, message);
		UserLine userLine = new UserLine();
		userLine.setName(name);
		userLine.setEmail(email);
		userLine.setMessage(message);
		userLine.setCreatdDate(new Date());
		userLineServiceImpl.save(userLine);
		response.getWriter().print(status);
		response.getWriter().flush();
		response.getWriter().close();
	}
	
}
