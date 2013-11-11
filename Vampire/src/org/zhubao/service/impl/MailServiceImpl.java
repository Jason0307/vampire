/**
 * 
 */
package org.zhubao.service.impl;

import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.zhubao.service.MailService;

/**
 * @author Jason.Zhu
 * @date   2013-11-11
 * @email jasonzhu@augmentum.com.cn
 */
@Component
public class MailServiceImpl implements MailService{

	private static final Logger logger = LoggerFactory
			.getLogger(MailServiceImpl.class);

	@Autowired
	private JavaMailSenderImpl mailSender;
	/* (non-Javadoc)
	 * @see org.zhubao.service.MailService#sendEmail(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void sendEmail(final String to, final String subject, final String content) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				StopWatch watch = new StopWatch();
				watch.start();
				MimeMessagePreparator preparator = new MimeMessagePreparator() {
					public void prepare(MimeMessage mimeMessage)
							throws Exception {
						MimeMessageHelper message = new MimeMessageHelper(
								mimeMessage);
						message.setTo(to);
						message.setSubject(subject);
						message.setText(content, true);
					}
				};
				mailSender.send(preparator);
				watch.stop();
				logger.info("Send mail to [{}] successfully! ({})", to, watch);
			}
		}).start();
	}

	
}
