package com.DaoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Dao.SchoolDao;
import com.ServiceImpl.CustomRowMapper;
import com.ServiceImpl.StudentAcadamicRowMapper;
import com.vo.ClassPerformVO;
import com.vo.ResponseVO;
import com.vo.StudentAcadamicDetailsVO;
import com.vo.StudentPerformVO;
import com.vo.StudentPersonalDetailsVO;
import com.vo.TeacherDetailsVO;

@Repository("SchoolDao")
public class SchoolDaoImpl implements SchoolDao {
	
	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbcTemplate;

	public ResponseVO resgisterStudentDetails(StudentPersonalDetailsVO studentPersonalDetailsVO) throws SQLException,Exception {
		// TODO Auto-generated method stub
		
		ResponseVO responseVO=null;
		
		String sql1 = "INSERT INTO STUDENTPERSONALDETAILS " +
				"(NAME, AGE,ADDRESS,CLASSNAME,YEAR) VALUES (?, ?, ?, ?,?)";
		
		String sql2 = "INSERT INTO STUDENTACADAMICDETAILS " +
				"(NAME,YEAR) VALUES (?,?)";
					 
			jdbcTemplate = new JdbcTemplate(dataSource);
					
			jdbcTemplate.update(sql1, new Object[] { 
					studentPersonalDetailsVO.getStudentName(),studentPersonalDetailsVO.getStudentAge(), 
					studentPersonalDetailsVO.getAddress(),studentPersonalDetailsVO.getClassName(),studentPersonalDetailsVO.getYear()
			});
			
			jdbcTemplate.update(sql2, new Object[] { studentPersonalDetailsVO.getStudentName(),studentPersonalDetailsVO.getYear()});
			
			responseVO=new ResponseVO();
			responseVO.setSuccess("Success");
			
		return responseVO;
	}

	public ResponseVO resgisterTeacherDetails(TeacherDetailsVO teacherDetailsVO) throws Exception {
		// TODO Auto-generated method stub
			ResponseVO responseVO=null;
		
		String sql = "INSERT INTO TEACHERDETAILS " +
				"(TEACHER_NAME, TEACHER_AGE,TEACHER_ADDRESS,TEACHER_CLASSNAME,TEACHER_SALARY,TEACHER_SUBJECT) VALUES (?, ?, ?, ?, ?, ?, ?)";
					 
			jdbcTemplate = new JdbcTemplate(dataSource);
					
			jdbcTemplate.update(sql, new Object[] {
					teacherDetailsVO.getEmpName(),teacherDetailsVO.getEmpAge(), 
					teacherDetailsVO.getEmpAddress(),teacherDetailsVO.getClassName(),
					teacherDetailsVO.getSalary(),teacherDetailsVO.getSubject()
			});
			
			responseVO=new ResponseVO();
			responseVO.setSuccess("Success");
			
		return responseVO;
	}

	public StudentPersonalDetailsVO fetchStudentDetailsByID(int id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM STUDENTPERSONALDETAILS WHERE ID = ?";
		jdbcTemplate = new JdbcTemplate(dataSource);
		

		StudentPersonalDetailsVO studentPersonalDetailsVO = (StudentPersonalDetailsVO)jdbcTemplate.queryForObject(
				sql, new Object[] { id }, new CustomRowMapper());
			
		return studentPersonalDetailsVO;
	}

	public ResponseVO updateStudentMarks(StudentAcadamicDetailsVO studentAcadamicDetailsVO) throws Exception {
		// TODO Auto-generated method stub
		
		ResponseVO responseVO=null;
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		String updateQuery = "update STUDENTACADAMICDETAILS set ENGLISH_MARKS= ?,MATHS_MARKS=? ,SCIENCE_MARKS   =?,SOCIAL_MARKS=?,PYSICS_MARKS=? FIRSTLANGUAGE_MARKS=? TOTAL_MARKS =?,PERCENTAGE=?,MARKS_TYPE=?,GRADE=? where id = ?";
		jdbcTemplate.update(updateQuery, studentAcadamicDetailsVO.getEnglish(), studentAcadamicDetailsVO.getMaths(),studentAcadamicDetailsVO.getScience(),
				studentAcadamicDetailsVO.getSocial(),studentAcadamicDetailsVO.getPhysics(),studentAcadamicDetailsVO.getFirstLanguage(),studentAcadamicDetailsVO.getTotalMarks(),
				studentAcadamicDetailsVO.getMarksType(),studentAcadamicDetailsVO.getGrade(),studentAcadamicDetailsVO.getStudentID());
		
		responseVO=new ResponseVO();
		responseVO.setSuccess("Success");
		return null;
	}

	public StudentAcadamicDetailsVO fetchStudentPerformanceReportDetails(int id,String markType) throws Exception {
		// TODO Auto-generated method stub

		
		String sql = "SELECT * FROM STUDENTACADAMICDETAILS WHERE ID = ? and MARKS_TYPE=?";
		jdbcTemplate = new JdbcTemplate(dataSource);
		

		StudentAcadamicDetailsVO studentAcadamicDetailsVO = (StudentAcadamicDetailsVO)jdbcTemplate.queryForObject(
				sql, new Object[] { id,markType }, new StudentAcadamicRowMapper());
			
		return studentAcadamicDetailsVO;
	}
	
	public StudentPerformVO studentGivenYearPerformance(int id,int year) throws Exception {
		// TODO Auto-generated method stub
		
		float QPercentage = 0;
		float HPercentage= 0;
		float FPercentage= 0;
		float PercentageOfYear;
		String sName = null;
		
		
		String sql = "SELECT * FROM STUDENTACADAMICDETAILS WHERE ID = ? and YEAR=?";
		jdbcTemplate = new JdbcTemplate(dataSource);
		StudentPerformVO studentPerformVO=new StudentPerformVO();
		List<StudentAcadamicDetailsVO> studentAcadamicDetailsVOList = new ArrayList<StudentAcadamicDetailsVO>();
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map row : rows) {
			StudentAcadamicDetailsVO studentAcadamicDetailsVO = new StudentAcadamicDetailsVO();
			studentAcadamicDetailsVO.setStudentID((Integer)(row.get("ID ")));
			studentAcadamicDetailsVO.setStudentName((String)row.get("NAME"));
			studentAcadamicDetailsVO.setEnglish((Integer)row.get("ENGLISH_MARKS"));
			studentAcadamicDetailsVO.setMaths((Integer)row.get("MATHS_MARKS"));
			studentAcadamicDetailsVO.setScience((Integer)row.get("SCIENCE_MARKS"));
			studentAcadamicDetailsVO.setSocial((Integer)row.get("SOCIAL_MARKS"));
			studentAcadamicDetailsVO.setPhysics((Integer)row.get("PYSICS_MARKS"));
			studentAcadamicDetailsVO.setFirstLanguage((Integer)row.get("FIRSTLANGUAGE_MARKS"));
			studentAcadamicDetailsVO.setMarksType((String)row.get("MARKS_TYPE"));
			studentAcadamicDetailsVO.setPercentage((Integer)row.get("PERCENTAGE"));
			studentAcadamicDetailsVO.setTotalMarks((Long)row.get("TOTAL_MARKS"));
			studentAcadamicDetailsVO.setYear((Integer)row.get("YEAR"));
			
			studentAcadamicDetailsVOList.add(studentAcadamicDetailsVO);
		}
		
		for(StudentAcadamicDetailsVO studentAcadamicVO:studentAcadamicDetailsVOList){
			
			if(studentAcadamicVO.getMarksType().trim()=="Quaterly"){
				sName=studentAcadamicVO.getStudentName();
				QPercentage= studentAcadamicVO.getPercentage();
						
			}else if(studentAcadamicVO.getMarksType().trim()=="HalfYearly"){
				
				HPercentage= studentAcadamicVO.getPercentage();
				
			}else if(studentAcadamicVO.getMarksType().trim()=="Final"){
				
				FPercentage= studentAcadamicVO.getPercentage();
				
			}	
		}
		
		PercentageOfYear= ((QPercentage+HPercentage+FPercentage)/3);
		
		if(PercentageOfYear >= 90){
			studentPerformVO.setGrade("A");
		}else if(PercentageOfYear >= 75){
			studentPerformVO.setGrade("B");
		}else if(PercentageOfYear >= 50){
			studentPerformVO.setGrade("C");
		}else{
			studentPerformVO.setGrade("D");
		}
		
		studentPerformVO.setStudentID(id);
		studentPerformVO.setStudentName(sName);
		studentPerformVO.setYear(year);
		studentPerformVO.setPerformance(PercentageOfYear);
		
		return studentPerformVO;
	}
	
	public ClassPerformVO classGivenYearPerformance(String className,int year) throws Exception {
		// TODO Auto-generated method stub
		
		int totalNoOfStudents=0;
		float totalPercentage=0;
		
		
		String sql = "SELECT PERCENTAGE FROM STUDENTACADAMICDETAILS WHERE CLASSNAME=? and YEAR=?";
		jdbcTemplate = new JdbcTemplate(dataSource);
		ClassPerformVO classPerformVO=new ClassPerformVO();
		List<StudentAcadamicDetailsVO> studentAcadamicDetailsVOList = new ArrayList<StudentAcadamicDetailsVO>();
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map row : rows) {
			StudentAcadamicDetailsVO studentAcadamicDetailsVO = new StudentAcadamicDetailsVO();
			
			studentAcadamicDetailsVO.setPercentage((Integer)row.get("PERCENTAGE"));
			
			studentAcadamicDetailsVOList.add(studentAcadamicDetailsVO);
		}
		
		totalNoOfStudents=studentAcadamicDetailsVOList.size();
		classPerformVO.setTotalNoOfStudents(totalNoOfStudents);
		
		for(StudentAcadamicDetailsVO studentAcadamicVO:studentAcadamicDetailsVOList){
			
			totalPercentage=totalPercentage+studentAcadamicVO.getPercentage();
		}
		
		totalPercentage=(totalPercentage)/(totalNoOfStudents);
		
		classPerformVO.setClassPercentage(totalPercentage);
		
		if(totalPercentage >= 90){
			classPerformVO.setClassGrade("A");
		}else if(totalPercentage >= 75){
			classPerformVO.setClassGrade("B");
		}else if(totalPercentage >= 50){
			classPerformVO.setClassGrade("C");
		}else{
			classPerformVO.setClassGrade("D");
		}
		

		
		return classPerformVO;
	}


}
