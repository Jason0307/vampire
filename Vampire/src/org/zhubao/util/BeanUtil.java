package org.zhubao.util;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanUtil {

	public static Object getBean(String beanName) {
        
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");
		Object bean = ac.getBean(beanName);
		return bean;
	}
}
