/**
 * 
 */
package org.zhubao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Jason.Zhu
 * @date   2013-10-31
 * @email jasonzhu@augmentum.com.cn
 */
@Controller
public class DashboardController {

	
	@RequestMapping(value = {"/index","/"},method = RequestMethod.GET)
	public String dashboard(){
		
		return "main";
	}
	
}
