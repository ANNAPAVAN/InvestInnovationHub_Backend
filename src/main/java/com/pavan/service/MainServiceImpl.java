package com.pavan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pavan.dao.MainDao;
import com.pavan.dto.Invest;
import com.pavan.dto.Posts;
import com.pavan.dto.Response;
import com.pavan.dto.Result;
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
	
	@Override
	public String postIdea(Response idea){
		System.out.println("service");
		String status = mainDao.ideaSave(idea);
		return status;
	}
	
	@Override
	public List<Response> getAllIdeas(String id){
		List<Response> list = mainDao.selectAllIdeas(id);
		return list;
	}

	@Override
	public String postResult(Result result) {
		String status = mainDao.resultSave(result);
		return status;
	}
	
	@Override
	public List<Result> getAllResults(){
		List<Result> list = mainDao.selectAllResults();
		return list;
	}
}
