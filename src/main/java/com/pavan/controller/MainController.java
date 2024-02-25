package com.pavan.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;


import com.pavan.dto.*;
import com.pavan.service.MainService;

@Controller
public class MainController {
	
	@Autowired
	MainService mainService;
	
//	REACT ADDED
	
	@PostMapping("/register")
	@ResponseBody // Include this annotation to indicate that the return value should be treated as the response body
	public Map<String, String> add(@RequestBody Users user) {
	 
	    String status = mainService.register(user);

	    Map<String, String> response = new HashMap<>();
	    response.put("status", status);

	    return response;
	}

//  REACT ADDED
	
	@PostMapping("/login")
	@ResponseBody
	public Map<String, Object> search(@RequestBody Users user) {
	    String status = mainService.login(user);

	    Map<String, Object> response = new HashMap<>();
	    response.put("status", status);

	    if ("success".equals(status)) {
	        // Depending on the user role, you may want to include additional information
	        if ("student".equals(user.getRole())) {
//	            List<Posts> allPosts = mainService.getAllPosts();
	            response.put("role", "student");
//	            response.put("posts", allPosts);
	        } else if ("entrepreneur".equals(user.getRole())) {
	        	response.put("id",user.getId());
	            response.put("role", "entrepreneur");
	        } else if ("investor".equals(user.getRole())) {
//	            List<Invest> allInvest = mainService.getAllInvests();
	            response.put("role", "investor");
//	            response.put("invests", allInvest);
	        }
	    }

	    return response;
	}

	

//	ADDED REACT
	
	@PostMapping("/posts")
	@ResponseBody
	public Map<String, String> postIn(@RequestBody Posts post) {
	    Map<String, String> response = new HashMap<>();
	    
//	    System.out.println(post.getP_title());
	    
	    String status = mainService.posts(post);

	    response.put("status", status);
	    return response;
	}

//    REACT ADDED
	
	@PostMapping("/toInvestor")
	@ResponseBody
	public Map<String, String> toInvest(@RequestBody Invest inv) {
	    Map<String, String> response = new HashMap<>();
	    
	    String status = mainService.pushInvest(inv);

	    response.put("status", status);
	    return response;
	}

//	--------------------------------------------------------------------------------------------
	
	@GetMapping("/getPosts")
	@ResponseBody 
	public Map<String, Object> getPost(){
//		System.out.println("getting posts to student");
	    Map<String, Object> response = new HashMap<>();
	    List<Posts> allPosts = mainService.getAllPosts();
	    response.put("role", "student");
	    response.put("posts", allPosts);
	    return response;
	}

	@GetMapping("/getInvests")
	@ResponseBody 
	public Map<String,Object> getInvest(){
		Map<String, Object> response = new HashMap<>();
		List<Invest> allInvest = mainService.getAllInvests();
		response.put("role","investor");
		response.put("posts",allInvest);
		return response;
	}
	
	@PostMapping("/studentsend")
	@ResponseBody
	public Map<String,Object> studentSend(@RequestBody Response idea){
		Map<String,Object> response = new HashMap<>();
	    System.out.println("controller");
		String status = mainService.postIdea(idea);

	    response.put("status", status);
	    
		return response;
	}
	
//	
//	@GetMapping("/getIdeas")
//	@ResponseBody
//	public Map<String,Object> getIdea(){
//		Map<String,Object> response = new HashMap<>();
//		List<Response> res = mainService.getAllIdeas();
//		response.put("ideas", res);
//		
//		return response;
//	}
	
	
	@GetMapping("/getIdeas")
	@ResponseBody
	public Map<String, Object> getIdeas(@RequestParam String entId) {
	    Map<String, Object> response = new HashMap<>();
	    List<Response> res = mainService.getAllIdeas(entId); // Assuming you have a method to fetch ideas by entrepreneur ID
	    response.put("ideas", res);
	    return response;
	}
	
	
	@PostMapping("/postresult")
	@ResponseBody
	public Map<String,Object> PostResult(@RequestBody Result result){
		Map<String,Object> response = new HashMap<>();
		String status = mainService.postResult(result);

	    response.put("status", status);
	    
		return response;
	}
	
	
	@GetMapping("/getResults")
	@ResponseBody
	public Map<String,Object> getResult(){
		Map<String,Object> response = new HashMap<>();
		List<Result> res = mainService.getAllResults();
		response.put("results", res);
		
		return response;
	}

}
