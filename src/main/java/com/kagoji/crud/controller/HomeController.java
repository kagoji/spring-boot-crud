package com.kagoji.crud.controller;

import java.util.ArrayList;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kagoji.crud.model.Biodata;
import com.kagoji.crud.repository.BiodataRepo;


@Controller
public class HomeController {
	
	@ModelAttribute
	public void Welcome(Model m) {
		m.addAttribute("msg","Crud Tutorial");
		
	}
	
	@Autowired
	BiodataRepo bio;
	
	@GetMapping("/")
	public String HomePage() {
		return "HomePage.html";
	}
	
	@GetMapping("/home")
	public String HomePagevV2() {
		return "HomePage.html";
	}
	
	@PostMapping("/add")
	public String AddBioData(@ModelAttribute Biodata biodata) {
		bio.save(biodata);
		return "redirect:/list";
	}
	
	@GetMapping("/list")
	public String AllBioList(Model model) {
		ArrayList<Biodata> biodataList = new ArrayList<Biodata>();
		biodataList = (ArrayList<Biodata>) bio.findAll();

        if (biodataList != null && !biodataList.isEmpty()) {
            model.addAttribute("biodataList", biodataList);
        } else {
            
            model.addAttribute("message", "No biodata found.");
        }

        return "AllProfilePage.html"; // Assuming the template name is "ProfilePage.html"
	}
	
	@GetMapping("/search")
	public String SearchPage(@RequestParam int id, Model model) {
		Biodata biodata= bio.findById(id)
                .orElse(null);
		
		if (biodata != null) {
            model.addAttribute("biodata", biodata);
        } else {
            model.addAttribute("message", "No Data found");
        }
		return "ProfilePage.html";
	}
	
	@GetMapping("/findByAge")
	public String findByAgePage(@RequestParam int age, Model model) {
		
		ArrayList<Biodata> biodataList= bio.findByAge(age);             
		
		if (biodataList != null && !biodataList.isEmpty()) {
            model.addAttribute("biodataList", biodataList);
        } else {
            model.addAttribute("message", "No Data found");
        }
		return "AllProfilePage.html";
	}
	
	@GetMapping("/findByName")
	public String findByNamePage(@RequestParam String name, Model model) {
		
		ArrayList<Biodata> biodataList= bio.findName(name);             
		
		if (biodataList != null && !biodataList.isEmpty()) {
            model.addAttribute("biodataList", biodataList);
        } else {
            model.addAttribute("message", "No Data found");
        }
		return "AllProfilePage.html";
	}
	
	@GetMapping("/edit/{id}")
	public String EditPage(@PathVariable  int id, Model model) {
		Biodata biodata= bio.findById(id)
                .orElse(null);
		
		if (biodata != null) {
            model.addAttribute("biodata", biodata);
        } else {
            model.addAttribute("message", "Invalid Biodata ID");
        }
		
		return "EditPage.html";
	}
	
	@PostMapping("/edit/{id}")
	public String updateBio(@PathVariable  int id,@ModelAttribute Biodata biodata) {
		Biodata updateData= bio.getOne(biodata.getId());
		updateData.setName(biodata.getName());
		updateData.setAge(biodata.getAge());
		bio.save(updateData);
		return "redirect:/list";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBioInfo(@PathVariable  int id, Model model) {
		Biodata biodata= bio.findById(id)
                .orElse(null);
		
		if (biodata != null) {
            bio.deleteById(id);
        } else {
            model.addAttribute("message", "Invalid Biodata ID");
        }
		
		return "redirect:/list";
	}
	
	
	
}
