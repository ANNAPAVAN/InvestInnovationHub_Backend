package com.pavan.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pavan.dto.Posts;

public class PostsRowMapper implements RowMapper<Posts> {

	@Override
	public Posts mapRow(ResultSet rs, int rowNum) throws SQLException {
		Posts post = new Posts();
		post.setE_id(rs.getString("e_id"));
		post.setP_id(rs.getString("p_id"));
		post.setP_title(rs.getString("title"));
		post.setP_desc(rs.getString("description"));
		return post;
	}

}
