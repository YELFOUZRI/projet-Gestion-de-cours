package com.doranco.projet.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.doranco.projet.model.Student;
import com.doranco.projet.repositories.IEstablishmentRepository;
import com.doranco.projet.repositories.IStudentRepository;
import jakarta.validation.Valid; 

@Controller
public class studentController { 
		
	@Autowired
	private IStudentRepository sr;
	@Autowired
	private IEstablishmentRepository er;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	//====================STUDENT============================================
	
	@GetMapping(path = "/admin/create-student")
	public String createStudent(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("establishment", er.findAll());
		
		return "/admin/createStudent"; 
	}
	
	@GetMapping(path = "/admin/update-student")
	public String updateStudent(Model model, Long id, int page, String keyword) {
		
		Student student = sr.findById(id).get();
		model.addAttribute("establishment", er.findAll());
		model.addAttribute("student", student);
		model.addAttribute("page", page);
		model.addAttribute("keyword", keyword);
		
		return "/admin/updateStudent"; 
	}
	
	@GetMapping(path = "/admin/student-management")  
	public String studentManag(Model model, 
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size,
			@RequestParam(name = "keyword", defaultValue = "") String keyword) {
		Page<Student> studentsList = sr.StudentSearch(keyword,PageRequest.of(page, size));
		
		
		int previousP = page-1;
		int nextP = page+1;
		model.addAttribute("studentsList", studentsList.getContent());
		model.addAttribute("keyword", keyword);
		model.addAttribute("pages", new int[studentsList.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("previous", previousP);
		model.addAttribute("next", nextP);		
		
		
		
		return "/admin/studentsManagement";
	}
	
	@GetMapping("/admin/deleteS")
	public String deleteStudent(Long id, int page, String keyword) {
		sr.deleteById(id);
		
		return "redirect:/admin/student-management?page="+page+"&keyword="+keyword;
	}
	
	@PostMapping("/admin/saveS")
	public String save(Model model,@Valid Student student, BindingResult br,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "") String keyword) {
		if (br.hasErrors()) {
			return "/admin/createStudent";			
		}
		
		String encodedPassword = passwordEncoder.encode(student.getPassword());
		student.setPassword(encodedPassword);
		
		sr.save(student);
		
		return "redirect:/admin/student-management";
	}
	
	@PostMapping("/admin/updateS")
	public String updateS(Model model,@Valid Student student, BindingResult br,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "") String keyword) {
		if (br.hasErrors()) {
			return "/admin/createStudent";			
		}
		
		String encodedPassword = passwordEncoder.encode(student.getPassword());
		student.setPassword(encodedPassword);
		
		sr.save(student);
		
		return "redirect:/admin/student-management?page="+page+"&keyword="+keyword;
	}

	

	


}
