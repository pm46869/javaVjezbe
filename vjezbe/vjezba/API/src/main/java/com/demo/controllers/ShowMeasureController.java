package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.demo.entities.Measure;

@Controller
public class ShowMeasureController {
	RestTemplate restTemplate=new RestTemplate();
	
	@GetMapping("/")
	public String showMeasures(Model model) {
		Measure[] response=restTemplate.getForObject("http://localhost:8081/listmeasures/",Measure[].class);
		for (Measure m:response) {
			System.out.println(m);
		}
		model.addAttribute("measures", response);
		return "frontpage";
	}
	@GetMapping("/addMeasure")
	public String showNewMeasureForm(Model model) {
		var measure=new Measure();
		model.addAttribute("measure",measure);
		return "new_measure";
	}
}
