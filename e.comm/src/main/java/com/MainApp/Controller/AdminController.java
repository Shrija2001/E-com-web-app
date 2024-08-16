package com.MainApp.Controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.MainApp.Pojo.Admin;
import com.MainApp.Pojo.BuyProduct;
import com.MainApp.Pojo.Product;
import com.MainApp.Repository.AdminRepository;
import com.MainApp.Repository.BuyProductRepository;
import com.MainApp.Repository.ProductRepository;

import jakarta.transaction.Transactional;

@Controller
@Transactional
public class AdminController {

	@Autowired
	ProductRepository pRepo;
	
	@Autowired
	BuyProductRepository bpRepo;
	
	@RequestMapping("/addproduct")
	public ModelAndView processAddProcess(@ModelAttribute Product p, @RequestParam("pimg") MultipartFile img) throws IOException {
		
		String piname = img.getOriginalFilename();
		
		p.setPimgname(piname);
		pRepo.save(p);
		
		InputStream is = img.getInputStream();
		byte[] b = is.readAllBytes();
		
		String path = "C:\\Users\\Shrija Dange\\Desktop\\Adv Java 17 jun\\Spring boot\\e.comm\\src\\main\\webapp\\productimg"+piname;
		
		FileOutputStream fos = new FileOutputStream(path);
		fos.write(b);
		
		List<BuyProduct> lbp = bpRepo.findByAdname(p.getUname());
		
		ModelAndView mv = new ModelAndView("adminhome", "check", p.getUname());
		mv.addObject("lp", pRepo.findByUname(p.getUname()));
		mv.addObject("lbp", lbp);
		return mv;
		
	}
	
	@RequestMapping("/delProduct")
	public ModelAndView delProductProcess(@RequestParam("uname") String uname, @RequestParam("pname") String pname) {
		
		ModelAndView mv = new ModelAndView("adminhome", "check", uname);
		pRepo.deleteById(pname);
		mv.addObject("lp", pRepo.findByUname(uname));
		
		List<BuyProduct> lbp = bpRepo.findByAdname(uname);
		mv.addObject("lbp", lbp);
		return mv;
		
		
	}
	
}
	

