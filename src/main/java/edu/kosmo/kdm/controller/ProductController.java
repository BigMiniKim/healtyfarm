package edu.kosmo.kdm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kosmo.kdm.service.ProductService;
import edu.kosmo.kdm.vo.ProductVO;
import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Log4j
@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	//상품등록
	@PostMapping("/productRegister")
	public void productRegister(ProductVO productVO, RedirectAttributes rttr) {
		log.info("register product..." +  productVO);
		
		productService.registerProduct(productVO);
	}
	@RequestMapping(value = "/goods/register", method = RequestMethod.GET)
	public void getGoodsRegister() throws Exception {
	 log.info("get goods register");
	}
	
}
