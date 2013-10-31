/**
 * 
 */
package org.zhubao.service.impl;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zhubao.dao.UserDAO;
import org.zhubao.exception.ErrorCodeConstants;
import org.zhubao.exception.VampireException;
import org.zhubao.model.User;
import org.zhubao.service.UserService;

/**
 * @author Jason.Zhu
 * @date   2013-10-31
 * @email jasonzhu@augmentum.com.cn
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{
	
	private UserDAO userDAO;

	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.setBaseDao(userDAO);
		this.userDAO = userDAO;
	}

	/* (non-Javadoc)
	 * @see org.zhubao.service.UserService#register(org.zhubao.model.User, java.lang.String)
	 */
	@Override
	public void register(User user, String cpass) throws Exception {
		
		if(StringUtils.isBlank(cpass) || !cpass.equals(user.getPass())){
			throw new VampireException(ErrorCodeConstants.CONFIRM_PASS_ERROR);
		}
		user.setRegistedDate(new Date());
		user.setUpdatedDate(new Date());
		user.setLastLoginDate(new Date());
		userDAO.save(user);
	}
	
	

}
