package com.controller;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.SchoolService;
import com.vo.ClassPerformVO;
import com.vo.ResponseVO;
import com.vo.StudentAcadamicDetailsVO;
import com.vo.StudentPerformVO;
import com.vo.StudentPersonalDetailsVO;
import com.vo.TeacherDetailsVO;


@CrossOrigin(origins="*",  allowedHeaders="*")
@RestController
public class SchoolController {
	
	
	@Autowired
	SchoolService schoolService;
	

	@RequestMapping(value="/student/Register" ,method=RequestMethod.POST,consumes = { "application/JSON",})
	public @ResponseBody ResponseVO registerStudent(@RequestBody String StudentDetails) {
		
		StudentPersonalDetailsVO  studentPersonalDetailsVO=new StudentPersonalDetailsVO();
		ResponseVO responseVO=null;
		
		ObjectMapper mapper=new ObjectMapper();
		
		try {
			
			studentPersonalDetailsVO=mapper.readValue(StudentDetails,StudentPersonalDetailsVO.class);
			responseVO=schoolService.resgisterStudentDetails(studentPersonalDetailsVO);
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			responseVO=new ResponseVO();
			responseVO.setExceptionMesg(e.getMessage());
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			responseVO=new ResponseVO();
			responseVO.setExceptionMesg(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			responseVO=new ResponseVO();
			responseVO.setExceptionMesg(e.getMessage());
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
			responseVO=new ResponseVO();
			responseVO.setExceptionMesg(e.getMessage());
		}
		
		
		
		return responseVO;
	}
	
	
	@RequestMapping(value="/teacher/Register" ,method=RequestMethod.POST,consumes = { "application/JSON",})
public @ResponseBody ResponseVO registerTeacher(@RequestBody String TeacherDetails) {
		
		TeacherDetailsVO  teacherDetailsVO=new TeacherDetailsVO();
		ResponseVO responseVO=null;
		
		ObjectMapper mapper=new ObjectMapper();
		
		try {
			
			teacherDetailsVO=mapper.readValue(TeacherDetails,TeacherDetailsVO.class);
			responseVO=schoolService.resgisterTeacherDetails(teacherDetailsVO);
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			responseVO=new ResponseVO();
			responseVO.setExceptionMesg(e.getMessage());
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			responseVO=new ResponseVO();
			responseVO.setExceptionMesg(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			responseVO=new ResponseVO();
			responseVO.setExceptionMesg(e.getMessage());
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
			responseVO=new ResponseVO();
			responseVO.setExceptionMesg(e.getMessage());
		}
		
		
		
		return responseVO;
	}
	
	
	@RequestMapping(value="/student/fetchById/{id}" ,method=RequestMethod.POST,consumes = { "application/JSON",})
	public @ResponseBody StudentPersonalDetailsVO fetchStudentByID(@PathVariable(value="id") int id) {
		
		StudentPersonalDetailsVO  studentPersonalDetailsVO=null;

		
		try {
			

			studentPersonalDetailsVO=schoolService.fetchStudentDetailsByID(id);
			
		} catch(Exception e){
			e.printStackTrace();
			studentPersonalDetailsVO=new StudentPersonalDetailsVO();
			studentPersonalDetailsVO.setExceptionMesg(e.getMessage());
		}
		
		
		
		return studentPersonalDetailsVO;
	}
	
	@RequestMapping(value="/teacher/updateStudentMarks" ,method=RequestMethod.POST,consumes = { "application/JSON",})
	public @ResponseBody ResponseVO updateStudentMarks(@RequestBody String StudentMarksUpdateDetails) {
		
		StudentAcadamicDetailsVO studentAcadamicDetailsVO=new StudentAcadamicDetailsVO();
		ResponseVO responseVO=null;
		
		ObjectMapper mapper=new ObjectMapper();
		
		try {
			
			studentAcadamicDetailsVO=mapper.readValue(StudentMarksUpdateDetails,StudentAcadamicDetailsVO.class);
			responseVO=schoolService.updateStudentMarks(studentAcadamicDetailsVO);
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			responseVO=new ResponseVO();
			responseVO.setExceptionMesg(e.getMessage());
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			responseVO=new ResponseVO();
			responseVO.setExceptionMesg(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			responseVO=new ResponseVO();
			responseVO.setExceptionMesg(e.getMessage());
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
			responseVO=new ResponseVO();
			responseVO.setExceptionMesg(e.getMessage());
		}
			
		return responseVO;
	}
	
	@RequestMapping(value="/teacher/fetchStudentPerformanceReport/{id}/{marksType}" ,method=RequestMethod.GET,consumes = { "application/JSON",})
	public @ResponseBody StudentAcadamicDetailsVO fetchStudentPerformanceReport(@PathVariable(value="id") int id,@PathVariable(value="marksType") String marksType) {
		
		StudentAcadamicDetailsVO studentAcadamicDetailsVO=null;
	
		
		try {
			
			studentAcadamicDetailsVO=schoolService.fetchStudentPerformanceReportDetails(id,marksType);
			
		} catch(Exception e){
			e.printStackTrace();
			studentAcadamicDetailsVO=new StudentAcadamicDetailsVO();
			studentAcadamicDetailsVO.setExceptionMesg(e.getMessage());
		}
			
		return studentAcadamicDetailsVO;
	}
	
	@RequestMapping(value="/teacher/fetchStudentPerformanceReportForGivenYear/{id}/{year}" ,method=RequestMethod.GET,consumes = { "application/JSON",})
	public @ResponseBody StudentPerformVO fetchStudentPerformanceReportForGivenYear(@PathVariable(value="id") int id,@PathVariable(value="year") int year) {
		
		StudentPerformVO studentPerformVO=null;
	
		
		try {
			
			studentPerformVO=schoolService.studentGivenYearPerformance(id,year);
			
		} catch(Exception e){
			e.printStackTrace();
			studentPerformVO=new StudentPerformVO();
			studentPerformVO.setExceptionMesg(e.getMessage());
		}
			
		return studentPerformVO;
	}
	
	@RequestMapping(value="/teacher/fetchClassPerformanceReportForGivenYear/{className}/{year}" ,method=RequestMethod.GET,consumes = { "application/JSON",})
	public @ResponseBody ClassPerformVO fetchStudentPerformanceReportForGivenYear(@PathVariable(value="className") String className,@PathVariable(value="year") int year) {
		
		ClassPerformVO classPerformVO=null;
	
		
		try {
			
			classPerformVO=schoolService.classGivenYearPerformance(className,year);
			
		} catch(Exception e){
			e.printStackTrace();
			classPerformVO=new ClassPerformVO();
			classPerformVO.setExceptionMesg(e.getMessage());
		}
			
		return classPerformVO;
	}
	
}
