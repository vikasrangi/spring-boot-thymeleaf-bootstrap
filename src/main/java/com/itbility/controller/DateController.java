package com.itbility.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.itbility.form.DateForm;

@Controller
public class DateController {
	
	@Value("${error.message}")
	private String errorMessage;
	
	@GetMapping("/calculateDays")
	public String displayDateForm(Model model){
		
		DateForm dateForm = new DateForm();
		model.addAttribute("dateForm", dateForm);
		return "dateForm";
		
	}
    
    @PostMapping("/calculateDays")
	public String calculateDays(Model model, @ModelAttribute("dateForm") DateForm dateForm){
    	
    	
		LocalDate startDate = LocalDate.parse(dateForm.getStartDate());
		LocalDate endDate = LocalDate.parse(dateForm.getEndDate());
		
		long numberofDays = ChronoUnit.DAYS.between(startDate, endDate);
		if(numberofDays < 0) {
			model.addAttribute("message", errorMessage);
		}else {
			model.addAttribute("message", "Number of Days : "+numberofDays);
		}
		return "dateForm";
		
	}
    
    @ExceptionHandler(Throwable.class)
    public String handleException(Model model) {
    	return "redirect:/calculateDays";
    }

}
