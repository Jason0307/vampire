/**
 * 
 */
package org.zhubao.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.zhubao.model.User;
import org.zhubao.service.UserService;

/**
 * @author Jason.Zhu
 * @date   2013-10-30
 * @email jasonzhu@augmentum.com.cn
 */
@Controller
@SessionAttributes("_LOGIN_USER")
public class UserController {
	@Autowired
	private UserService userServiceImpl;
	private Logger log = Logger.getLogger(UserController.class);

	@RequestMapping(value = "/user/register",method = RequestMethod.POST)
	public String register(String cpass,String address,@Valid User user,BindingResult br,Model model) throws Exception{
		System.out.println("ISO8859: "+new String(address.getBytes("ISO-8859-1"), "UTF-8"));
		System.out.println("GBK: "+new String(address.getBytes("GBK"), "UTF-8"));
		System.out.println("Address :"+address);
		System.out.println("User : "+user);
		if(br.hasErrors()){
			System.out.println("error");
			return "register";
		}
		try {
			userServiceImpl.register(user,cpass);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			log.error(e.getMessage(), e);
			return "register";
		}
		System.out.println(user);
		model.addAttribute("_LOGIN_USER", user);
		return "redirect:/dashboard/index";
	}
}
