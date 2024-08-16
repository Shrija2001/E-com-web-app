package com.MainApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.MainApp.Pojo.BuyProduct;
import com.MainApp.Pojo.Cart;
import com.MainApp.Pojo.Product;
import com.MainApp.Pojo.Users;
import com.MainApp.Repository.BuyProductRepository;
import com.MainApp.Repository.CartRepository;
import com.MainApp.Repository.ProductRepository;
import com.MainApp.Repository.UsersRepository;

@Controller
public class UserController {

	@Autowired
	UsersRepository uRepo;
	
	@Autowired
	ProductRepository pRepo;
	
	@Autowired
	CartRepository cRepo;
	
	@Autowired
	BuyProductRepository bpRepo;
	
	//direct access
	@RequestMapping("/ecom")
	public ModelAndView showUserHome() {
		
		List<Product> lallp = pRepo.findAll();
		ModelAndView mv = new ModelAndView("userhome");
		mv.addObject("lallp", lallp);
		return mv;
		
	}
	
	@RequestMapping("/usersignup")
	public ModelAndView processUsersignup(@ModelAttribute Users u) {
		
		Users tempad = uRepo.findByUname(u.getUname());
		
		if(tempad == null)
		{
			uRepo.save(u);
			return new ModelAndView("userlogin", "msg", "account created successfully");
		}
		else
		{
			return new ModelAndView("usersignup", "msg", "account creation failed");
		}
	}
	
	@RequestMapping("/userlogin")
	public ModelAndView processUserlogin(@RequestParam("uname") String uname, @RequestParam("upass") String upass) {
		
		Users ad = uRepo.findByUnameAndUpass(uname, upass);
		
		if(ad != null)
		{
			List<Product> lallp = pRepo.findAll();
			List<Cart> lcp = cRepo.findByUname(uname);
			List<BuyProduct> lbp = bpRepo.findByUname(uname);
			
			ModelAndView mv = new ModelAndView("userhome", "check", uname);
			mv.addObject("lallp", lallp);
			mv.addObject("lcp", lcp);
			mv.addObject("lbp", lbp);
			
			return mv;
		}
		else
		{
			return new ModelAndView("userlogin", "msg", "Invalid Credential");
		}
		
	}
	
	@RequestMapping("/addtocart")
	public ModelAndView processAddtocart(@ModelAttribute Cart c) {
		
		cRepo.save(c);
		List<Cart> lcp = cRepo.findByUname(c.getUname());
		List<Product> lallp = pRepo.findAll();
		List<BuyProduct> lbp = bpRepo.findByUname(c.getUname());
		
		ModelAndView mv = new ModelAndView("userhome", "check", c.getUname());
		mv.addObject("lcp", lcp);
		mv.addObject("lallp", lallp);
		mv.addObject("lbp", lbp);
		
		return mv;
		
	}
	
	@RequestMapping("/buyproduct")
	public ModelAndView processBuyproduct(@ModelAttribute BuyProduct b) {
		
		bpRepo.save(b);
		
		//update product quantity
		Product p = pRepo.findByUnameAndPname(b.getAdname(), b.getPname());
		int pq = Integer.valueOf(p.getPq())-1;
	
		String npq = String.valueOf(pq);
		
		p.setPq(npq);
		
		pRepo.save(p);
		//update q complete
		
		List<Cart> lcp = cRepo.findByUname(b.getUname());
		List<Product> lallp = pRepo.findAll();
		List<BuyProduct> lbp = bpRepo.findByUname(b.getUname());
		
		
		ModelAndView mv = new ModelAndView("userhome", "check", b.getUname());
		mv.addObject("lcp", lcp);
		mv.addObject("lallp", lallp);
		mv.addObject("lbp", lbp);
		
		return mv;
		
		
	}
}
