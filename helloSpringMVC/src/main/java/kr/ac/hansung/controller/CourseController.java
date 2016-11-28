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
		courseInfoList_2017_1.add(new Course(2017, 1, "CSE0051", "DB시스템구현", "전선", 3));
		courseInfoList_2017_1.add(new Course(2017, 1, "CSE0039",  "IOS프로그래밍2", "전선", 3));
		courseInfoList_2017_1.add(new Course(2017, 1, "CSE0052", "SW설계및테스트", "전선", 3));
		courseInfoList_2017_1.add(new Course(2017, 1, "CSE0055", "고급DB설계", "전선", 3));
		courseInfoList_2017_1.add(new Course(2017, 1, "CSE0054", "고급SW설계", "전선", 3));
		courseInfoList_2017_1.add(new Course(2017, 1, "CSE0044", "디지털콘텐츠기획및제작", "전선", 3));
		courseInfoList_2017_1.add(new Course(2017, 1, "CSE0043", "빅데이터프로그래밍", "전선", 3));
		courseInfoList_2017_1.add(new Course(2017, 1, "CSE0053", "사용자어플리케이션구현", "전선", 3));
		courseInfoList_2017_1.add(new Course(2017, 1, "CSE0050", "서버시스템구현", "전선", 3));
		courseInfoList_2017_1.add(new Course(2017, 1, "CSE0041", "안드로이드프로그래밍2", "전선", 3));
		courseInfoList_2017_1.add(new Course(2017, 1, "CSE0037", "오픈소스소프트웨어", "전선", 3));
		courseInfoList_2017_1.add(new Course(2017, 1, "CSE0042", "웹프레임워크2", "전선", 3));
		courseInfoList_2017_1.add(new Course(2017, 1, "CSE0038", "정보보안", "전선", 3));
		courseInfoList_2017_1.add(new Course(2017, 1, "CSE0040", "컴파일러", "전선", 3));
		courseInfoList_2017_1.add(new Course(2017, 1, "CSE0036", "캡스톤디자인2", "전지", 3));
		courseInfoList_2017_1.add(new Course(2017, 1, "CSE0056", "캡스톤디자인3", "전지", 3));
	}

	public void intoHashMap() {
		for(int i=0; i<courseInfoList_2017_1.size(); i++){
			courseInfo_2017_1.put(courseInfoList_2017_1.get(i).getCode(), courseInfoList_2017_1.get(i));
		}
	}
}
