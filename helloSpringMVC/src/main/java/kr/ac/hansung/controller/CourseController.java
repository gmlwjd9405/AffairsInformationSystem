package kr.ac.hansung.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.model.Course;
import kr.ac.hansung.service.CourseService;

/* client request processing (at home) */
@Controller
public class CourseController {

	private ArrayList<Course> courseInfoList_2017_1 = new ArrayList<Course>();
	private HashMap<String, Course> courseInfo_2017_1 = new HashMap<String, Course>();
	private ArrayList<String> registeredCode_2017_1 = new ArrayList<String>();
	private CourseService courseService;

	@Autowired
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	@RequestMapping("/course")
	public String showAllCourse(Model model) {
		List<Course> course = courseService.getCurrent();

		model.addAttribute("course", course);
		return "course";
	}

	@RequestMapping("/coursePerSemester")
	public String showCoursePerSemester(Model model) {
		List<Course> coursePerSemester = courseService.getCoursePerSemester();

		model.addAttribute("coursePerSemester", coursePerSemester);
		return "coursePerSemester";
	}

	@RequestMapping("/subjectListPerSemester")
	public String showSubjectListPerSemester(Model model, int year, int semester) {

		System.out.println("subjectListPerSemester");
		System.out.println("year: " + year);
		System.out.println("semester: " + semester);

		List<Course> subjectListPerSemester = courseService.getSubjectListPerSemester(year, semester);

		model.addAttribute("subjectListPerSemester", subjectListPerSemester);
		return "subjectListPerSemester";
	}

	@RequestMapping("/creditDetails")
	public String showCreditDetails(Model model) {
		int totalCredits = courseService.getSumCredit();
		List<Course> creditDetails = courseService.getCreditsDetails();

		model.addAttribute("totalCredits", totalCredits);
		model.addAttribute("creditDetails", creditDetails);
		return "creditDetails";
	}

	@RequestMapping("/registerForCourse")
	public String registerForCourse(Model model) {
		// return Empty instance to save user input text
		// model.addAttribute(new Course());
		intoList();
		intoHashMap();
		
		model.addAttribute("courseInfoList", courseInfoList_2017_1);
		model.addAttribute(new Course());
		return "registerForCourse";
	}

	@RequestMapping("/doRegister")
	public String doRegister(Model model, @Valid Course course, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Form data does not validate");
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "registerForCourse";
		}
		
		String reqCode = course.getCode();

		if (courseInfo_2017_1.containsKey(reqCode)) {
			if (registeredCode_2017_1.contains(reqCode)) {
				model.addAttribute("message", "You already registered this code");
				return "registerFail";
			} else {
				Course reqRegisterCourse = courseInfo_2017_1.get(reqCode);
				reqRegisterCourse.setCode(reqCode);

				courseService.insert(reqRegisterCourse);
				registeredCode_2017_1.add(reqCode);
				model.addAttribute("message",
						"If you want to show your successful result, then click /'show my registration/'");
				return "registerSuccess";
			}
		} else {
			model.addAttribute("message", "This course is not offer this semester");
			return "registerFail";
		}
	}

	@RequestMapping("/registrationDetails")
	public String showRegistration(Model model) {
		List<Course> registrationDetails = courseService.getRegistrationDetails();

		model.addAttribute("registrationDetails", registrationDetails);
		return "registrationDetails";
	}
	
	public void intoList(){
		courseInfoList_2017_1.add(new Course(2017, 1, "CSE0051", "DB�ý��۱���", "����", 3));
		courseInfoList_2017_1.add(new Course(2017, 1, "CSE0039",  "IOS���α׷���2", "����", 3));
		courseInfoList_2017_1.add(new Course(2017, 1, "CSE0052", "SW������׽�Ʈ", "����", 3));
		courseInfoList_2017_1.add(new Course(2017, 1, "CSE0055", "���DB����", "����", 3));
		courseInfoList_2017_1.add(new Course(2017, 1, "CSE0054", "���SW����", "����", 3));
		courseInfoList_2017_1.add(new Course(2017, 1, "CSE0044", "��������������ȹ������", "����", 3));
		courseInfoList_2017_1.add(new Course(2017, 1, "CSE0043", "���������α׷���", "����", 3));
		courseInfoList_2017_1.add(new Course(2017, 1, "CSE0053", "����ھ��ø����̼Ǳ���", "����", 3));
		courseInfoList_2017_1.add(new Course(2017, 1, "CSE0050", "�����ý��۱���", "����", 3));
		courseInfoList_2017_1.add(new Course(2017, 1, "CSE0041", "�ȵ���̵����α׷���2", "����", 3));
		courseInfoList_2017_1.add(new Course(2017, 1, "CSE0037", "���¼ҽ�����Ʈ����", "����", 3));
		courseInfoList_2017_1.add(new Course(2017, 1, "CSE0042", "�������ӿ�ũ2", "����", 3));
		courseInfoList_2017_1.add(new Course(2017, 1, "CSE0038", "��������", "����", 3));
		courseInfoList_2017_1.add(new Course(2017, 1, "CSE0040", "�����Ϸ�", "����", 3));
		courseInfoList_2017_1.add(new Course(2017, 1, "CSE0036", "ĸ���������2", "����", 3));
		courseInfoList_2017_1.add(new Course(2017, 1, "CSE0056", "ĸ���������3", "����", 3));
	}

	public void intoHashMap() {
		for(int i=0; i<courseInfoList_2017_1.size(); i++){
			courseInfo_2017_1.put(courseInfoList_2017_1.get(i).getCode(), courseInfoList_2017_1.get(i));
		}
	}
}
