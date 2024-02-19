package com.pavan.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pavan.dto.Response;

public class IdeaMapper implements RowMapper<Response> {
	
	@Override
	public Response mapRow(ResultSet rs, int rowNum) throws SQLException {
		Response res = new Response();
		res.setStudent_id(rs.getString("std_Id"));
		res.setEnt_id(rs.getString("e_id"));
		res.setP_id(rs.getString("p_id"));
		res.setP_title(rs.getString("p_title"));
		res.setIdea(rs.getString("idea"));
		return res;
	}
}
