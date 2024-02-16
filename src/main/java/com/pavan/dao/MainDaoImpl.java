package com.pavan.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pavan.mapper.*;
import com.pavan.dto.Invest;
import com.pavan.dto.Posts;
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
			int rowCount = jdbcTemplate.update("insert into users values('"+user.getId()+"','"+user.getName()+"','"+user.getEmail()+"','"+user.getPwd()+"','"+user.getRole()+"')");
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
}
