package com.pavan.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pavan.dto.Result;

public class ResultMapper implements RowMapper<Result> {
	@Override
	public Result mapRow(ResultSet rs, int rowNum) throws SQLException {
		Result result = new Result();
		result.setStd_id(rs.getString("std_id"));
		result.setEnt_id(rs.getString("ent_id"));
		result.setInv_id(rs.getString("inv_id"));
		result.setProj_id(rs.getString("proj_id"));
		result.setProj_title(rs.getString("proj_title"));
		result.setAmount(rs.getString("amount"));
		return result;
	}
}

//
//mysql> create table result(
//	    -> std_id varchar(30),
//	    -> ent_id varchar(30),
//	    -> inv_id varchar(30),
//	    -> proj_id varchar(30),
//	    -> proj_title varchar(300),
//	    -> amount varchar(30));
//	Query OK, 0 rows affected (0.02 sec)