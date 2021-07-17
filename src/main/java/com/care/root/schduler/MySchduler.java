package com.care.root.schduler;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class MySchduler {
	//@Scheduled(cron = "*/10 * * * *")
	public void scheduled() {
		System.out.println("=== 실 행 ===");
	}
}
