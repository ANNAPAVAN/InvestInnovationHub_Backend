package com.pavan.service;

import java.util.List;

import com.pavan.dto.Invest;
import com.pavan.dto.Posts;
import com.pavan.dto.Users;
import com.pavan.dto.Response;
import com.pavan.dto.Result;

public interface MainService {
	public String register(Users user);
	public String login(Users user);
	public String posts(Posts post);
	public List<Posts> getAllPosts();
	public String pushInvest(Invest inv);
	public List<Invest> getAllInvests();
	public String postIdea(Response idea);
	public List<Response> getAllIdeas(String id);
	public String postResult(Result result);
	public List<Result> getAllResults();
	public List<Users> getAllStudents();
	public List<Users> getAllEntrepreneurs();
	public List<Users> getAllInvestors();
}
