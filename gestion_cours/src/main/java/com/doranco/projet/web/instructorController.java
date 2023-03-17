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
import com.doranco.projet.model.Instructor;
import com.doranco.projet.repositories.IEstablishmentRepository;
import com.doranco.projet.repositories.IInstructorRepository;
import jakarta.validation.Valid;

@Controller
public class instructorController {
	
	@Autowired
	private IInstructorRepository ir;
	@Autowired
	private IEstablishmentRepository er;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	//========================INSTRUCTOR=============================
	
		@GetMapping(path = "/admin/create-instructor")
		public String createInstructor(Model model) {
			model.addAttribute("instructor", new Instructor());
			model.addAttribute("establishment", er.findAll());
			
			return "/admin/createInstructor"; 
		}
		
		@GetMapping(path = "/admin/update-instructor")
		public String updateInstructor(Model model, Long id, int page, String keyword) {
			
			Instructor instructor = ir.findById(id).get();
			model.addAttribute("establishment", er.findAll());
			model.addAttribute("instructor", instructor);
			model.addAttribute("page", page);
			model.addAttribute("keyword", keyword);
			
			return "/admin/updateInstructor"; 
		}
		
		@GetMapping(path = "/admin/instructor-management")  
		public String instructorManag(Model model, 
				@RequestParam(name = "page", defaultValue = "0") int page,
				@RequestParam(name = "size", defaultValue = "10") int size,
				@RequestParam(name = "keyword", defaultValue = "") String keyword) {
			Page<Instructor> instructorsList = ir.InstructorSearch("%"+keyword+"%",PageRequest.of(page, size));
			
			int previousP = page-1;
			int nextP = page+1;
			model.addAttribute("instructorsList", instructorsList.getContent());
			model.addAttribute("keyword", keyword);
			model.addAttribute("pages", new int[instructorsList.getTotalPages()]);
			model.addAttribute("currentPage", page);
			model.addAttribute("previous", previousP);
			model.addAttribute("next", nextP);
			model.addAttribute("instructor", new Instructor());
			
			return "/admin/instructorsManagement";
		}
		
		@GetMapping("/admin/deleteI")
		public String deleteInstructor(Long id, int page, String keyword) {
			ir.deleteById(id);
			
			return "redirect:/admin/instructor-management?page="+page+"&keyword="+keyword;
		}
		
		@PostMapping("/admin/saveI")
		public String saveI(Model model,@Valid Instructor instructor, BindingResult br,
				@RequestParam(defaultValue = "0") int page,
				@RequestParam(defaultValue = "") String keyword) {
			if (br.hasErrors()) {
				return "/admin/createInstructor";			
			}
			
			String encodedPassword = passwordEncoder.encode(instructor.getPassword());
			instructor.setPassword(encodedPassword);
			
			ir.save(instructor);
			
			return "redirect:/admin/instructor-management";
		}
		
		@PostMapping("/admin/updateI")
		public String updateI(Model model,@Valid Instructor instructor, BindingResult br,
				@RequestParam(defaultValue = "0") int page,
				@RequestParam(defaultValue = "") String keyword) {
			if (br.hasErrors()) {
				return "/admin/createInstructor";			
			}
			
			String encodedPassword = passwordEncoder.encode(instructor.getPassword());
			instructor.setPassword(encodedPassword);
			
			ir.save(instructor);
			
			return "redirect:/admin/instructor-management?page="+page+"&keyword="+keyword;
		}


}
