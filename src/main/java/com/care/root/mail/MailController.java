package com.care.root.mail;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MailController {
	@Autowired MailService ms;
	@GetMapping("sendmail")
	public void sensSimpleMail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		StringBuffer sb = new StringBuffer();
		sb.append("<htm><body>");
		sb.append("<h1>제품소개</h1>");
		sb.append("<a href='https://maplestory.nexon.com/Home/Main'>");
		sb.append("<img src='https://ssl.nx.com/s2/game/maplestory/renewal/common/maple_image01.jpg'>");
		sb.append("</a></body></html>");
		String str = sb.toString();
		
		ms.sendMail("minsung159357@gmail.com", "테스트 메일(제목)", str);
		out.print("메일을 보냈습니다");
	}
	
	@GetMapping("auth_form")
	public String authForm() {
		return "authentication";
	}
	
	@GetMapping("auth")
	public String auth(HttpServletRequest request) {
		ms.auth(request);
		return "redirect:http://www.google.com";
	}
	
	@GetMapping("auth_check")
	public String auth_check(@RequestParam String userid, @RequestParam String userkey, HttpSession session) {
		String sessionkey = (String)session.getAttribute(userid);
		if(sessionkey != null) {
			if(sessionkey.equals(userkey)) {
				session.setAttribute("userid", userid);
			}
		}
		return "redirect:auth_form";
	}
}
