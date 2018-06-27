package com.Dao;

import org.springframework.stereotype.Repository;

import com.vo.ClassPerformVO;
import com.vo.ResponseVO;
import com.vo.StudentAcadamicDetailsVO;
import com.vo.StudentPerformVO;
import com.vo.StudentPersonalDetailsVO;
import com.vo.TeacherDetailsVO;

@Repository
public interface SchoolDao {

	public ResponseVO resgisterStudentDetails(StudentPersonalDetailsVO studentPersonalDetailsVO) throws Exception;

	public ResponseVO resgisterTeacherDetails(TeacherDetailsVO teacherDetailsVO) throws Exception;

	public StudentPersonalDetailsVO fetchStudentDetailsByID(int id) throws Exception;

	public ResponseVO updateStudentMarks(StudentAcadamicDetailsVO studentAcadamicDetailsVO) throws Exception;

	public StudentAcadamicDetailsVO fetchStudentPerformanceReportDetails(int id, String marksType) throws Exception;

	public StudentPerformVO studentGivenYearPerformance(int id, int year) throws Exception;

	public ClassPerformVO classGivenYearPerformance(String className, int year) throws Exception;

}
