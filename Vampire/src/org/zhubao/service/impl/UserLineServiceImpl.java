/**
 * 
 */
package org.zhubao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhubao.dao.UserLineDAO;
import org.zhubao.model.UserLine;
import org.zhubao.service.UserLineService;

/**
 * @author Jason.Zhu
 * @date   2013-11-11
 * @email jasonzhu@augmentum.com.cn
 */
@Service
public class UserLineServiceImpl extends BaseServiceImpl<UserLine> implements UserLineService{

	private UserLineDAO userLineDAO;

	@Autowired
	public void setUserLineDAO(UserLineDAO userLineDAO) {
		this.setBaseDao(userLineDAO);
		this.userLineDAO = userLineDAO;
	}
	
	
}
