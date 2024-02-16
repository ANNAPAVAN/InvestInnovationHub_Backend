package com.pavan.service;

import java.util.List;

import com.pavan.dto.Invest;
import com.pavan.dto.Posts;
import com.pavan.dto.Users;

public interface MainService {
	public String register(Users user);
	public String login(Users user);
	public String posts(Posts post);
	public List<Posts> getAllPosts();
	public String pushInvest(Invest inv);
	public List<Invest> getAllInvests();
}
