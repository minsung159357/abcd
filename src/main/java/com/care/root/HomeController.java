package com.care.root;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@GetMapping("non_ajax")
	public String test() {
		System.out.println("non ajax 실행");
		return "non_ajax";
	}
	
	@GetMapping("ajax")
	public String ajax() {
		System.out.println("ajax 실행");
		return "ajax";
	}
	
	static int cnt = 0;
	@GetMapping("ajax_result")
	@ResponseBody
	public String ajaxResult() {
		return ++cnt +"";
	}
	
	@GetMapping("ajax01")
	public String ajax01() {
		return "ajax01";
	}
	
	@RequestMapping(value="ajax_result01", produces="application/json; charset=utf-8")
	@ResponseBody
	public Map ajax_result01(@RequestBody Map info) {//(@RequestBody InfoDTO info)
//		System.out.println("사용자가 넘겨준 값"+info.getAge());
//		System.out.println("사용자가 넘겨준 값"+info.getName());
//		info.setName("서버에서 변경한 값");
//		info.setAge(2000);
		System.out.println(info.get("name"));
		System.out.println(info.get("age"));
		System.out.println(info.get("addr"));
		return info;
	}
	
	@GetMapping("rest01")
	public String rest01() {
		return "rest01";
	}
	
	@RequestMapping("getuser")
	public String getuser() {
		return "getuser";
	}
}
