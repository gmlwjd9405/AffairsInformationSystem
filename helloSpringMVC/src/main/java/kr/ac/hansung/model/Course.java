package kr.ac.hansung.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Course {
	private int year;
	private int semester;
	
	@Size(min=7, max=7, message="The Code Number must be 7 chars")
	@NotEmpty(message="The Code Number Cannot Be Empty")
	private String code;
	private String subject;
	private String division;
	private int credit;

	public Course() {
	}
	
	public Course(int year, int semester, String subject, String division, int credit) {
		this.year = year;
		this.semester = semester;
		this.code = null;
		this.subject = subject;
		this.division = division;
		this.credit = credit;
	}

	public Course(int year, int semester, String code, String subject, String division, int credit) {
		this.year = year;
		this.semester = semester;
		this.code = code;
		this.subject = subject;
		this.division = division;
		this.credit = credit;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String toString() {
		return "Course [year=" + year + ", semester=" + semester + ", code=" + code + ", subject=" + subject
				+ ", division=" + division + ", credit=" + credit + "]";
	}

}
