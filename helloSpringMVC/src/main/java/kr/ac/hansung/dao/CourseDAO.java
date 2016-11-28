package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Course;

@Repository
public class CourseDAO {
	private JdbcTemplate jdbcTemplateObject;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	// the total number of records
	public int getRowCount() {
		String sqlStatement = "select count(*) from course";
		return jdbcTemplateObject.queryForObject(sqlStatement, Integer.class);
	}

	// the total number of records per semester
	public int getSumCredit() {
		String sqlStatement = "select sum(credit) from course";
		return jdbcTemplateObject.queryForObject(sqlStatement, Integer.class);
	}

	// querying and returning a single object
	// return record by code
	public Course getCourse(String code) {
		String sqlStatement = "select * from course where code=?";
		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] { code }, new CourseMapper());
	}

	// return record by code
	public Course getCourseByYear(String year) {
		String sqlStatement = "select * from course where year=?";
		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] { year }, new CourseMapper());
	}

	/* querying and returning a multiple object */
	// get all records in DB
	public List<Course> getAllCourses() {
		String sqlStatement = "select * from course where year<2017";
		return jdbcTemplateObject.query(sqlStatement, new CourseMapper());
	}

	// get courses per semester
	public List<Course> getCoursePerSemester() {
		String sqlStatement = "select year, semester, sum(credit) from course group by year, semester";
		return jdbcTemplateObject.query(sqlStatement, new RowMapper<Course>() {
			public Course mapRow(ResultSet resultSet, int rowNum) throws SQLException {
				Course course = new Course();
				course.setYear(resultSet.getInt("year"));
				course.setSemester(resultSet.getInt("semester"));
				course.setCredit(resultSet.getInt("sum(credit)"));
				return course;
			}
		});
	}

	// get subject list per semester
	public List<Course> getSubjectListPerSemester(int year, int semester) {
		String sqlStatement = "select * from course where year=? and semester=?";
		return jdbcTemplateObject.query(sqlStatement, new Object[] { year, semester }, new CourseMapper());
	}

	// get total credit and detail
	public List<Course> getCreditsDetails() {
		String sqlStatement = "select division, sum(credit) from course group by division";
		return jdbcTemplateObject.query(sqlStatement, new RowMapper<Course>() {
			public Course mapRow(ResultSet resultSet, int rowNum) throws SQLException {
				Course course = new Course();
				course.setDivision(resultSet.getString("division"));
				course.setCredit(resultSet.getInt("sum(credit)"));
				return course;
			}
		});
	}

	// get registered record
	public List<Course> getRegistrationDetails() {
		String sqlStatement = "select * from course where year=2017 and semester=1";
		return jdbcTemplateObject.query(sqlStatement, new CourseMapper());
	}

	// insert record
	public boolean insert(Course course) {
		int year = course.getYear();
		int semester = course.getSemester();
		String code = course.getCode();
		String subject = course.getSubject();
		String division = course.getDivision();
		int credit = course.getCredit();

		// year, semester, code, subject, division, credit
		String sqlStatement = "insert into course (year, semester, code, subject, division, credit) values (?,?,?,?,?,?)";
		return (jdbcTemplateObject.update(sqlStatement,
				new Object[] { year, semester, code, subject, division, credit }) == 1);
	}

	// update record
	public boolean update(Course course) {
		int year = course.getYear();
		int semester = course.getSemester();
		String code = course.getCode();
		String subject = course.getSubject();
		String division = course.getDivision();
		int credit = course.getCredit();

		// year, semester, code, subject, division, credit
		String sqlStatement = "update course set year=?, semester=?, subject=?, division=?, credit=? where code=?";
		return (jdbcTemplateObject.update(sqlStatement,
				new Object[] { year, semester, subject, division, credit, code }) == 1);
	}

	// delete record by code
	public boolean delete(String code) {
		String sqlStatement = "delete from course where code=?";
		return (jdbcTemplateObject.update(sqlStatement, new Object[] { code }) == 1);
	}
}
