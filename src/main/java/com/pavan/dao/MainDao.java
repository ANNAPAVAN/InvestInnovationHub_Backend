package com.pavan.dao;

import java.util.List;

import com.pavan.dto.Invest;
import com.pavan.dto.Posts;
import com.pavan.dto.Response;
import com.pavan.dto.Result;
import com.pavan.dto.Users;

public interface MainDao {
	public String registerUser(Users user);
	public Users search(String id);
	public String loginUser(Users user);
	public String postProject(Posts post);
	public List<Posts> selectAllPosts();
	public String invest(Invest inv);
	public List<Invest> selectAllInvests();
	public String ideaSave(Response res);
	public List<Response> selectAllIdeas(String id);
	public String resultSave(Result res);
	public List<Result> selectAllResults();
	public List<Users> selectAllStudents();
	public List<Users> selectAllEntrepreneurs();
	public List<Users> selectAllInvestors();
	public List<Users> getProfile(String uid);
	public String updateProfile(Users user);
	public String deleteUser(String uid);
	
}
