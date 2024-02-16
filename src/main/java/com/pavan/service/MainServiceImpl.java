package com.pavan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pavan.dao.MainDao;
import com.pavan.dto.Invest;
import com.pavan.dto.Posts;
import com.pavan.dto.Users;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	MainDao mainDao;
	
	@Override
	public String register(Users user) {
		String status = mainDao.registerUser(user);
		return status;
	}
	
	@Override
	public String login(Users user) {
		String status = mainDao.loginUser(user);
		return status;
	}
	
	@Override
	public String posts(Posts post) {
		String status = mainDao.postProject(post);
		return status;
	}
	
	@Override
	public List<Posts> getAllPosts(){
		List<Posts> list = mainDao.selectAllPosts();
		return list;
	}
	
	@Override
	public String pushInvest(Invest inv) {
		String status = mainDao.invest(inv);
		return status;
	}
	
	@Override
	public List<Invest> getAllInvests(){
		List<Invest> list = mainDao.selectAllInvests();
		return list;
	}

}
