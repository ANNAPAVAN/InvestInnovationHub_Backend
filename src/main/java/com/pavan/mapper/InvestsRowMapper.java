package com.pavan.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pavan.dto.Invest;

public class InvestsRowMapper implements RowMapper<Invest> {

	@Override
	public Invest mapRow(ResultSet rs, int rowNum) throws SQLException {
		Invest inv = new Invest();
		inv.setEid(rs.getString("e_id"));
		inv.setPid(rs.getString("p_id"));
		inv.setTitle(rs.getString("p_title"));
		inv.setDesc(rs.getString("p_desc"));
		inv.setIdea(rs.getString("p_idea"));
		inv.setReq(rs.getString("request"));
		inv.setAmt(rs.getString("amount"));
		inv.setStatus(rs.getString("status"));
		return inv;
	}

}


