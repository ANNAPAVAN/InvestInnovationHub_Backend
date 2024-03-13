package com.pavan.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pavan.mapper.*;
import com.pavan.dto.Invest;
import com.pavan.dto.Posts;
import com.pavan.dto.Response;
import com.pavan.dto.Result;
import com.pavan.dto.Users;

@Repository 
public class MainDaoImpl implements MainDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	

	@Override
	public String registerUser(Users user) {
		String status = "";
		Users usr = search(user.getId());
		if(usr==null) {
			int rowCount = jdbcTemplate.update("insert into users values('"+user.getId()+"','"+user.getName()+"','"+user.getEmail()+"','"+user.getPwd()+"','"+user.getRole()+"','"+user.getImage()+"')");
			if(rowCount==1) {
				status = "success";
			}else {
				status="failure";
			}
		}else {
			status = "existed";
		}
		return status;
	}
	

	
	
	@Override
	public Users search(String id) {
		Users user = null;
	    List<Users> userList = jdbcTemplate.query("SELECT * FROM users WHERE id = '"+id+"'", new UserRowMapper());
		
		if(userList.isEmpty()) {
			user = null;
		}else {
			user = userList.get(0);
		}
		
		return user;
	}
	
	@Override
	public String loginUser(Users user) {
		String status = "";
		Users usr = search(user.getId());
		if(usr!=null) {
			if(usr.getName().equals(user.getName()) && usr.getPwd().equals(user.getPwd()) && usr.getRole().equals(user.getRole())) {
				status="success";
			}else {
				status="failure";
			}
		}else {
			status = "notexisted";
		}
		return status;
	}
	

	
	@Override
	public String postProject(Posts post) {
		String status = "";
		int rC = jdbcTemplate.update("insert into posts (e_id,p_id,title,description) values('"+post.getE_id()+"','"+post.getP_id()+"','"+post.getP_title()+"','"+post.getP_desc()+"')");
		if(rC==1) {
			status="success";
		}else {
			status="failure";
		}
		return status;
	}
	
	@Override
	public List<Posts> selectAllPosts(){

		String query1 = "select * from posts";
		List<Posts> postList = jdbcTemplate.query(query1,new PostsRowMapper());
		return postList;
	}

	@Override 
	public String invest(Invest inv) {
		String stats = "";
	    int rC = jdbcTemplate.update("insert into inv_requests(e_id,p_id,p_title,p_desc,p_idea,request,amount,status) values('"+inv.getEid()+"','"+inv.getPid()+"','"+inv.getTitle()+"','"+inv.getDesc()+"','"+inv.getIdea()+"','"+inv.getReq()+"','"+inv.getAmt()+"','"+inv.getStatus()+"')");
		if(rC==1) {
			stats="success";
		}else {
			stats="failure";
		}
		return stats;
	}
	
	@Override
	public List<Invest> selectAllInvests(){
		String query1 = "select * from inv_requests";
		List<Invest> invList = jdbcTemplate.query(query1,new InvestsRowMapper());
		return invList;
	}
	
	@Override
	public String ideaSave(Response res) {
		System.out.println("dao");
		String status = "";
		int rC = jdbcTemplate.update("insert into studentresponse (std_id,e_id,p_id,p_title,idea) values('"+res.getStudent_id()+"','"+res.getEnt_id()+"','"+res.getP_id()+"','"+res.getP_title()+"','"+res.getIdea()+"')");
		if(rC==1) {
			status="success";
		}else {
			status="failure";
		}
		return status;
	}
	
	@Override
	public List<Response> selectAllIdeas(String id){
		
	    List<Response> ideas = jdbcTemplate.query("SELECT * FROM studentresponse where e_id = '"+id+"'", new IdeaMapper());

		return ideas;
	}
	
	@Override
	public String resultSave(Result res){
		String status = "";
		int rC = jdbcTemplate.update("insert into result values('"+res.getStd_id()+"','"+res.getEnt_id()+"','"+res.getInv_id()+"','"+res.getProj_id()+"','"+res.getProj_title()+"','"+res.getAmount()+"')");
		int d1 = jdbcTemplate.update("delete from posts where p_id = '"+res.getProj_id()+"'");
		int d2 = jdbcTemplate.update("delete from studentresponse where p_id = '"+res.getProj_id()+"'");
		int d3 = jdbcTemplate.update("delete from inv_requests where p_id = '"+res.getProj_id()+"'");
		if(rC==1) {
			status="success";
		}else {
			status="failure";
		}
		return status;
	}
	
	@Override
	public List<Result> selectAllResults(){
		List<Result> results = jdbcTemplate.query("select * from result", new ResultMapper());
		
		return results;
	}
	
	@Override 
	public List<Users> selectAllStudents(){
		List<Users> students = jdbcTemplate.query("select * from users where role='student'", new UserRowMapper());
		return students;
	}
	
	@Override
	public List<Users> selectAllEntrepreneurs(){
		List<Users> entrepreneurs = jdbcTemplate.query("select * from users where role='entrepreneur'", new UserRowMapper());
		return entrepreneurs;
	}
	
	@Override
	public List<Users> selectAllInvestors(){
		List<Users> investors = jdbcTemplate.query("select * from users where role='investor'", new UserRowMapper());
		return investors;
	}
	
	@Override
	public List<Users> getProfile(String uid){
		List<Users> investors = jdbcTemplate.query("select * from users where id='"+uid+"'", new UserRowMapper());
		return investors;
	}
	
	@Override
	public String updateProfile(Users user) {
		String status = "";
		int rowCount = jdbcTemplate.update("UPDATE users SET name = ?, email = ?, password = ?, image = ? WHERE id = ?",user.getName(), user.getEmail(),user.getPwd(), user.getImage(), user.getId());

		if(rowCount==1) {
			status = "success";
		}else {
			status="failure";
		}
		return status;
	}
	
	@Override
	public String deleteUser(String uid) {
		String status ="";
		int rC = jdbcTemplate.update("delete from users where id = ?",uid);
		if(rC==1){
			status="success";
		}else {
			status = "failure";
		}
		
		return status;
	}
	
}
