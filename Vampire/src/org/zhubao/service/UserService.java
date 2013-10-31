/**
 * 
 */
package org.zhubao.service;

import org.zhubao.model.User;

/**
 * @author Jason.Zhu
 * @date   2013-10-31
 * @email jasonzhu@augmentum.com.cn
 */
public interface UserService extends BaseService<User>{

	/**
	 * user regitser in this application
	 * @param user
	 * @param cpass confirm pass
	 * @throws Exception 
	 */
	void register(User user, String cpass) throws Exception;

}
