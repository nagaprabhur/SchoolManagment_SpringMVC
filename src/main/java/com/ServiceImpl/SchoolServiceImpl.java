package com.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dao.SchoolDao;
import com.service.SchoolService;
import com.vo.ClassPerformVO;
import com.vo.ResponseVO;
import com.vo.StudentAcadamicDetailsVO;
import com.vo.StudentPerformVO;
import com.vo.StudentPersonalDetailsVO;
import com.vo.TeacherDetailsVO;

@Service("SchoolService")
public class SchoolServiceImpl implements SchoolService {
	
	@Autowired
	SchoolDao schoolDao;

	public ResponseVO resgisterStudentDetails(StudentPersonalDetailsVO studentPersonalDetailsVO) throws Exception {
		// TODO Auto-generated method stub
		return schoolDao.resgisterStudentDetails(studentPersonalDetailsVO);
	}

	public ResponseVO resgisterTeacherDetails(TeacherDetailsVO teacherDetailsVO) throws Exception {
		// TODO Auto-generated method stub
		return schoolDao.resgisterTeacherDetails(teacherDetailsVO);
	}

	public StudentPersonalDetailsVO fetchStudentDetailsByID(int id) throws Exception {
		// TODO Auto-generated method stub
		return schoolDao.fetchStudentDetailsByID(id);
	}

	public ResponseVO updateStudentMarks(StudentAcadamicDetailsVO studentAcadamicDetailsVO) throws Exception {
		// TODO Auto-generated method stub
		
		Long totalMarks=(long) (studentAcadamicDetailsVO.getEnglish()+studentAcadamicDetailsVO.getMaths()+studentAcadamicDetailsVO.getPhysics()+
								studentAcadamicDetailsVO.getScience()+studentAcadamicDetailsVO.getSocial()+studentAcadamicDetailsVO.getFirstLanguage());
		int percentage=(int) ((totalMarks/600)*100);
		studentAcadamicDetailsVO.setTotalMarks(totalMarks);
		studentAcadamicDetailsVO.setPercentage(percentage);
		
		if(percentage >= 90){
			studentAcadamicDetailsVO.setGrade("A");
		}else if(percentage >= 75){
			studentAcadamicDetailsVO.setGrade("B");
		}else if(percentage >= 50){
			studentAcadamicDetailsVO.setGrade("C");
		}else{
			studentAcadamicDetailsVO.setGrade("D");
		}
		
		return schoolDao.updateStudentMarks(studentAcadamicDetailsVO);
	}

	public StudentAcadamicDetailsVO fetchStudentPerformanceReportDetails(int id,String marksType) throws Exception {
		// TODO Auto-generated method stub
		return schoolDao.fetchStudentPerformanceReportDetails(id,marksType);
	}

	public StudentPerformVO studentGivenYearPerformance(int id, int year) throws Exception {
		// TODO Auto-generated method stub
		return schoolDao.studentGivenYearPerformance(id,year);
	}

	public ClassPerformVO classGivenYearPerformance(String className, int year) throws Exception {
		// TODO Auto-generated method stub
		return schoolDao.classGivenYearPerformance(className,year);
	}

	

}
