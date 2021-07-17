package com.care.root;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import oracle.jdbc.proxy.annotation.Post;

@RestController
public class ReController {
	@GetMapping(value="rest", produces="application/json;charset=utf-8")
	public String get() {
		return "{\"execute\" : \"get 데이터 요청시 사용\"}";
	}
	
	@PostMapping(value="rest", produces="application/json;charset=utf-8")
	public String post() {
		return "{\"execute\" : \"post 데이터 추가\"}";
	}
	
	@PutMapping(value="rest", produces="application/json;charset=utf-8")
	public String put() {
		return "{\"execute\" : \"put 데이터 수정\"}";
	}
	
	@DeleteMapping(value="rest", produces="application/json;charset=utf-8")
	public String delete() {
		return "{\"execute\" : \"delete 데이터 삭제\"}";
	}
	
	static int cnt = 0;
	static Map<String, InfoDTO> DBMap = new HashMap<String, InfoDTO>();
	@GetMapping(value="users", produces="application/json;charset=utf-8")
	public ArrayList<InfoDTO> users(){
		ArrayList<InfoDTO> list = new ArrayList<InfoDTO>();
		for(int i=cnt; i<cnt+10; i++) {
			InfoDTO info = new InfoDTO();
			info.setName("홍길동"+i);
			info.setAge(10+i);
			list.add(info);
			DBMap.put("홍길동"+i, info);
		}
		cnt+=10;
		return list;
	}
	
	@GetMapping(value="user", produces="application/json;charset=utf-8")
	public InfoDTO user(@RequestParam String id) {
		System.out.println(id);
		// select * from table where id=#{id}
		return DBMap.get(id);
	}
	
	// user/홍길동14
	@GetMapping(value="user/{uId}", produces="application/json;charset=utf-8")
	public InfoDTO user1(@PathVariable String uId) {
		// select * from table where id=#{id}
		return DBMap.get(uId);
	}
	
	@PutMapping(value="modify", produces="application/json;charset=utf-8")
	public InfoDTO modify(@RequestBody InfoDTO dto) {
		System.out.println("name : " +dto.getName());
		System.out.println("age : "+dto.getAge());
		// update table set age=#{age} where id=#{id}
		DBMap.replace(dto.getName(), dto);
		return DBMap.get(dto.getName());
	}
	
	@PostMapping(value="membership", produces="application/json;charset=utf-8")
	public String membership(@RequestBody Map<String, Object> map) {
		System.out.println("uId");
		System.out.println("id : " + map.get("uId"));
		System.out.println("uAge : " + map.get("uAge"));
		System.out.println("uName : " + map.get("uName"));
		System.out.println("uAddr : " + map.get("uAddr"));
		System.out.println("uPhone : " + map.get("uPhone"));
		return "{\"result\" : true }";
	}
}
