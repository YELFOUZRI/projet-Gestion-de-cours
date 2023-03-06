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
import com.doranco.projet.model.Establishment;
import com.doranco.projet.repositories.IEstablishmentRepository;
import jakarta.validation.Valid;

@Controller
public class EstablishmentController {
	
	@Autowired
	private IEstablishmentRepository er;
	
	
	//========================Establishment==============================
	
	@GetMapping(path = "/admin/create-establishment")
	public String createEstablishment(Model model) {
		model.addAttribute("establishment", new Establishment());
		
		return "/admin/createEstablishment"; 
	}
	
	@GetMapping(path = "/admin/update-establishment")
	public String updateEstablishment(Model model, Long id, int page, String keyword) {
		
		Establishment establishment = er.findById(id).get();
		model.addAttribute("establishment", establishment);
		model.addAttribute("page", page);
		model.addAttribute("keyword", keyword);
		
		return "/admin/updateEstablishment"; 
	}
	
	@GetMapping(path = "/admin/establishment-management")  
	public String establishmentManag(Model model, 
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size,
			@RequestParam(name = "keyword", defaultValue = "") String keyword) {
		Page<Establishment> establishmentsList = er.EstablishmentSearch("%"+keyword+"%",PageRequest.of(page, size));
		
		int previousP = page-1;
		int nextP = page+1;
		model.addAttribute("establishmentsList", establishmentsList.getContent());
		model.addAttribute("keyword", keyword);
		model.addAttribute("pages", new int[establishmentsList.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("previous", previousP);
		model.addAttribute("next", nextP);		
		
		return "/admin/establishmentsManagement";
	}
	
	@GetMapping("/admin/deleteE")
	public String deleteEstablishment(Long id, int page, String keyword) {
		er.deleteById(id);
		
		return "redirect:/admin/establishment-management?page="+page+"&keyword="+keyword;
	}
	
	@PostMapping("/admin/saveE")
	public String saveE(Model model,@Valid Establishment establishment, BindingResult br,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "") String keyword) {
		if (br.hasErrors()) {
			return "/admin/createEstablishment";			
		}
		er.save(establishment);
		
		return "redirect:/admin/establishment-management";
	}
	
	@PostMapping("/admin/updateE")
	public String updateE(Model model,@Valid Establishment establishment, BindingResult br,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "") String keyword) {
		if (br.hasErrors()) {
			return "/admin/createEstablishment";			
		}
		er.save(establishment);
		
		return "redirect:/admin/establishment-management?page="+page+"&keyword="+keyword;
	}

}
