package com.MainApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.servlet.ModelAndView;

import com.MainApp.Repository.ProductRepository;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.Part;

@Controller
@MultipartConfig
public class AdminProductController {

	@Autowired
	ProductRepository pRepo;
	
	@RequestMapping("/addProduct")
	public ModelAndView processAddProcess(@ModelAttribute Producer p,@RequestParam("pimg") Part img) {
		
		String piname = img.getSubmittedFileName();
		
		
		return new ModelAndView("adminhome", "check", "temp");
		
	}
	
}
