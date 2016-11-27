package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.CourseDAO;
import kr.ac.hansung.model.Course;

@Service
public class CourseService {
	private CourseDAO courseDAO;

	@Autowired
	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	// get all records in DB
	public List<Course> getCurrent() {
		return courseDAO.getAllCourses();
	}

	// the tltal number of records per semester
	public int getSumCredit() {
		return courseDAO.getSumCredit();
	}

	// get course per semester
	public List<Course> getCoursePerSemester() {
		return courseDAO.getCoursePerSemester();
	}

	// get subjectList per semester
	public List<Course> getSubjectListPerSemester(int year, int semester) {
		return courseDAO.getSubjectListPerSemester(year, semester);
	}

	// get total credit and detail
	public List<Course> getCreditsDetails() {
		return courseDAO.getCreditsDetails();
	}
	
	// get registered record
	public List<Course> getRegistrationDetails(){
		return courseDAO.getRegistrationDetails();
	}

	public void insert(Course course) {
		courseDAO.insert(course);
	}

}
