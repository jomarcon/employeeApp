package com.bootapps.employee.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

public class MessageSourceConfig {
	@Bean(name="messageSource")
	public ReloadableResourceBundleMessageSource messageSource() {
	  ReloadableResourceBundleMessageSource messageBundle = new ReloadableResourceBundleMessageSource();
	  messageBundle.setBasename("classpath:messages");
	  messageBundle.setDefaultEncoding("UTF-8");
	  return messageBundle;
	}
}
