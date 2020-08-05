package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserProfile;

@RestController
public class UserProfileController {
	
	private Map<String, UserProfile> userMap;
	
	@PostConstruct
	public void init() {
		userMap  = new HashMap<String, UserProfile>();
		userMap.put("1", new UserProfile("1","Hwang","111-1111-1111","seoul"));
		userMap.put("2", new UserProfile("2","Kim","222-1111-1111","seoul"));
		userMap.put("3", new UserProfile("3","Lee","333-1111-1111","seoul"));
	}
	
	@GetMapping("/user/{id}")
	public UserProfile getUserProfile(@PathVariable("id") String id) {
		return userMap.get(id);
	}
	
	@GetMapping("/user/all")
	public List<UserProfile> getUserProfileList(){
		return new ArrayList<UserProfile>(userMap.values());
	}
	
	@PostMapping("/user/{id}")
	public void postUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("addr") String addr) {
		UserProfile up = new UserProfile(id, name, phone, addr);
		userMap.put(id, up);
	}
	
	@PutMapping("/user/{id}")
	public void putUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("addr") String addr) {
		UserProfile up = userMap.get(id);
		up.setName(name);
		up.setPhone(phone);
		up.setAddress(addr);		
	}
	
	@DeleteMapping("user/{id}")
	public void deleteUserProfile(@PathVariable("id") String id) {
		userMap.remove(id);
	}

}
