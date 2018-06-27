package com.ServiceImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.vo.StudentAcadamicDetailsVO;

public class StudentAcadamicRowMapper implements RowMapper<StudentAcadamicDetailsVO> {

	public StudentAcadamicDetailsVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		StudentAcadamicDetailsVO studentAcadamicDetailsVO=new StudentAcadamicDetailsVO();
		
		studentAcadamicDetailsVO.setStudentID(rs.getInt("ID"));
		studentAcadamicDetailsVO.setStudentName(rs.getString("NAME"));
		studentAcadamicDetailsVO.setEnglish(rs.getInt("ENGLISH_MARKS"));
		studentAcadamicDetailsVO.setFirstLanguage(rs.getInt("FIRSTLANGUAGE_MARKS"));
		studentAcadamicDetailsVO.setMaths(rs.getInt("MATHS_MARKS"));
		studentAcadamicDetailsVO.setPhysics(rs.getInt("PHYSICS_MARKS"));
		studentAcadamicDetailsVO.setScience(rs.getInt("SCIENCE_MARKS"));
		studentAcadamicDetailsVO.setSocial(rs.getInt("SOCIAL_MARKS"));
		studentAcadamicDetailsVO.setTotalMarks(rs.getLong("TOTAL_MARKS"));
		studentAcadamicDetailsVO.setGrade(rs.getString("GRADE"));
		studentAcadamicDetailsVO.setMarksType(rs.getString("MARKS_TYPE"));
		studentAcadamicDetailsVO.setPercentage(rs.getFloat("PERCENTAGE"));
	
		return studentAcadamicDetailsVO;
	}

}
