/**
 * 
 */
package org.zhubao.service;

/**
 * @author Jason.Zhu
 * @date   2013-11-11
 * @email jasonzhu@augmentum.com.cn
 */
public interface MailService {

	/**
	 * send email
	 * @param to
	 * @param subject
	 * @param content
	 */
	public void sendEmail(String to,String subject,String content);
}
