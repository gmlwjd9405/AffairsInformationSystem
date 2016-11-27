package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.ac.hansung.model.Course;

public class CourseMapper implements RowMapper<Course> {

	public Course mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		Course course = new Course();
		course.setYear(resultSet.getInt("year")); 
		course.setSemester(resultSet.getInt("semester"));
		course.setCode(resultSet.getString("code"));
		course.setSubject(resultSet.getString("subject"));
		course.setDivision(resultSet.getString("division"));
		course.setCredit(resultSet.getInt("credit"));

		return course;
	}

}
