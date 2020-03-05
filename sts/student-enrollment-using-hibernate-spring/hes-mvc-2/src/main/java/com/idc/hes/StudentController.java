package com.idc.hes;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.idc.hes.dao.StudentDAO;
import com.idc.hes.model.Student;
import com.idc.hes.model.StudentLogin;

@Controller
@SessionAttributes("student")
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentDAO studentDAO;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String showIndex() {
        return "Just for testing...";
    }

	@RequestMapping(value="")
	public String home(Model model) {
		return "student/home";
	}

	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signup(Model model) {
		Student student = new Student();		
		model.addAttribute("student", student);		
		return "student/signup";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model) {		
		if (result.hasErrors()) return "student/signup";

		if (studentDAO.findByUserName(student.getUserName())) {
			model.addAttribute("message", "User Name exists. Try another user name");
			return "student/signup";
		}

		studentDAO.save(student);
		model.addAttribute("message", "Saved student details");
		model.addAttribute("student", student);	
		return "redirect:/student/login";
	}

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {			
		StudentLogin studentLogin = new StudentLogin();		
		model.addAttribute("studentLogin", studentLogin);
		return "student/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@Valid @ModelAttribute("studentLogin") StudentLogin studentLogin, BindingResult result, Model model) {
		if (result.hasErrors()) return "student/login";

		boolean found = studentDAO.findByLogin(studentLogin.getUserName(), studentLogin.getPassword());
		if (found) return "student/success";
//		return "student/failure";
		model.addAttribute("error", "Invalid username/password");
		return "student/login";
	}

	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list (Model model) {
		List<Student> allStudents = studentDAO.getAll();
		model.addAttribute("allStudents", allStudents);
		return "student/list";
	}

	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteUser(HttpServletRequest request) {
		int userId = Integer.parseInt(request.getParameter("id"));
		studentDAO.delete(userId);
		return new ModelAndView("redirect:/student");		
	}
}
