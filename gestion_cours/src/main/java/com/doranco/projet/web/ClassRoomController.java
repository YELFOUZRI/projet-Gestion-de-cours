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
import com.doranco.projet.model.ClassRoom;
import com.doranco.projet.repositories.IClassRoomRepository;
import jakarta.validation.Valid;

@Controller
public class ClassRoomController {
	@Autowired
	private IClassRoomRepository crr;
	
	//=========================ClassRoom==========================
	
	@GetMapping(path = "/admin/create-classRoom")
	public String createClassRoom(Model model) {
		model.addAttribute("classRoom", new ClassRoom());
		
		return "/admin/createClassRoom"; 
	}
	
	@GetMapping(path = "/admin/update-classRoom")
	public String updateClassRoom(Model model, Long id, int page, String keyword) {
		
		ClassRoom classRoom = crr.findById(id).get();
		model.addAttribute("classRoom", classRoom);
		model.addAttribute("page", page);
		model.addAttribute("keyword", keyword);
		
		return "/admin/updateClassRoom"; 
	}
	
	@GetMapping(path = "/admin/classRoom-management")  
	public String classRoomManag(Model model, 
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size,
			@RequestParam(name = "keyword", defaultValue = "") String keyword) {
		Page<ClassRoom> classRoomsList = crr.ClassRoomSearch(keyword,PageRequest.of(page, size));		

			
		int previousP = page-1;
		int nextP = page+1;
		model.addAttribute("classRoomsList", classRoomsList.getContent());		
		model.addAttribute("keyword", keyword);
		model.addAttribute("pages", new int[classRoomsList.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("previous", previousP);
		model.addAttribute("next", nextP);		
		
		return "/admin/classRoomsManagement";
	}
	
	@GetMapping("/admin/deleteCRR")
	public String deleteClassRoom(Long id, int page, String keyword) {
		crr.deleteById(id);
		
		return "redirect:/admin/classRoom-management?page="+page+"&keyword="+keyword;
	}
	
	@PostMapping("/admin/saveCR")
	public String saveE(Model model,@Valid ClassRoom classRoom, BindingResult br,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "") String keyword) {
		if (br.hasErrors()) {
			return "/admin/createClassRoom";			
		}
		crr.save(classRoom);
		
		return "redirect:/admin/classRoom-management";
	}
	
	@PostMapping("/admin/updateCR")
	public String updateCR(Model model,@Valid ClassRoom classRoom, BindingResult br,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "") String keyword) {
		if (br.hasErrors()) {
			return "/admin/createClassRoom";			
		}
		crr.save(classRoom);
		
		return "redirect:/admin/classRoom-management?page="+page+"&keyword="+keyword;
	}

}
