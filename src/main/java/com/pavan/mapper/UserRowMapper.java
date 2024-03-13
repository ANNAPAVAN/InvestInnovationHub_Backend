package com.pavan.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pavan.dto.Users;

public class UserRowMapper implements RowMapper<Users> {

	@Override
	public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
		Users user = new Users();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		user.setPwd(rs.getString("password"));
		user.setRole(rs.getString("role"));
		user.setImage(rs.getString("image"));
		return user;
	}
	
}
