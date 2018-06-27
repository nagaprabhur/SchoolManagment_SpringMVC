package com.ServiceImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.vo.StudentPersonalDetailsVO;

public class CustomRowMapper implements RowMapper<StudentPersonalDetailsVO> {
	
	public StudentPersonalDetailsVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		StudentPersonalDetailsVO studentPersonalDetailsVO = new StudentPersonalDetailsVO();
		
		studentPersonalDetailsVO.setStudentID(rs.getInt("ID"));
		studentPersonalDetailsVO.setStudentName(rs.getString("NAME"));
		studentPersonalDetailsVO.setStudentAge(rs.getInt("AGE"));
		studentPersonalDetailsVO.setAddress(rs.getString("ADDRESS"));
		studentPersonalDetailsVO.setClassName(rs.getString("CLASSNAME"));
		
		return studentPersonalDetailsVO;
	}

	

}
