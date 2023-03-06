package com.doranco.projet.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.doranco.projet.model.Course;
import com.doranco.projet.repositories.IClassRoomRepository;
import com.doranco.projet.repositories.ICourseRepository;
import com.doranco.projet.repositories.IInstructorRepository;
import jakarta.validation.Valid;

@Controller
public class CourseController {
	
	@Autowired
	private ICourseRepository cr;
	@Autowired
	private IClassRoomRepository crr;
	@Autowired
	private IInstructorRepository ir;
	
	
//=======================COURSE===============================
	
	@GetMapping(path = "/admin/create-course")
	public String createCourse(Model model) {
		model.addAttribute("course", new Course());	
		model.addAttribute("classRooms", crr.findAll());
		model.addAttribute("instructor", ir.findAll());
		
		return "/admin/createCourse"; 
	}
	
	@GetMapping(path = "/admin/update-course")
	public String updateCourse(Model model, Long id, int page, String keyword) {
		
		Course course = cr.findById(id).get();
		model.addAttribute("course", course);
		model.addAttribute("page", page);
		model.addAttribute("keyword", keyword);
		model.addAttribute("classRooms", crr.findAll());
		model.addAttribute("instructor", ir.findAll());
		
		return "/admin/updateCourse"; 
	}
	
	
	@GetMapping(path = "/course-management")  
	public String courseManag(Model model, 
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size,
			@RequestParam(name = "keyword", defaultValue = "") String keyword) {
		Page<Course> coursesList = cr.CourseSearch(keyword,PageRequest.of(page, size));
		
			
		int previousP = page-1;
		int nextP = page+1;
		model.addAttribute("coursesList", coursesList.getContent());		
		model.addAttribute("keyword", keyword);
		model.addAttribute("pages", new int[coursesList.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("previous", previousP);
		model.addAttribute("next", nextP);		
		
		return "/admin/coursesManagement";
	}
	
	@GetMapping("/admin/deleteCR")
	public String deleteCourse(Long id, int page, String keyword) {
		cr.deleteById(id);
		
		return "redirect:/course-management?page="+page+"&keyword="+keyword;
	}
	
	@PostMapping("/admin/saveC")
	public String saveC(Model model,@Valid Course course, BindingResult br,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "") String keyword) {
		if (br.hasErrors()) {
			return "/admin/createCourse";			
		}
		
		cr.save(course);
		
		return "redirect:/course-management";
	}
	
	@PostMapping("/admin/updateC")
	public String updateC(Model model,@Valid Course course, BindingResult br,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "") String keyword) {
		if (br.hasErrors()) {
			return "/admin/createCourse";			
		}
		cr.save(course);
		
		return "redirect:/course-management?page="+page+"&keyword="+keyword;
	}

}
