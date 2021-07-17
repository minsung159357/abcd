package com.care.root.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
	@Bean
	public JavaMailSender mailSender() {
		JavaMailSenderImpl jms = new JavaMailSenderImpl();
		jms.setHost("smtp.gmail.com"); //google smtp(메일)서버 설정
		jms.setPort(587);	// google smtp 메일 서버 포트
		jms.setUsername("minsung159357@gmail.com");
		jms.setPassword("kmsxyz1784");
		// 메일 전달 프로토콜 세부 설정
		Properties prop = new Properties();
		// 메일 프로토콜 지정
		prop.setProperty("mail.transport.protocol", "smtp");
		// 사용자 인증을 통한 전송
		prop.setProperty("mail.smtp.auth", "true");
		// tls 보안 처리. 암시적은 ssl 이다.
		prop.setProperty("mail.smtp.starttls.enable", "true");
		jms.setJavaMailProperties(prop);
		return jms;
	}
}
