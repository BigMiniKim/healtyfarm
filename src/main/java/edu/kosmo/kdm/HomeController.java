package edu.kosmo.kdm;

import java.security.Principal;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;


@Log4j
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@GetMapping("/user/userHome")
	public void userHome() {
		log.info("userHome ...");
	}
	
	
	@GetMapping("/board/list")
	public void userlist() {
		log.info("userlist ...");
	}
	
	@GetMapping("/admin/adminHome")
	public void adminHome() {
		log.info("adminHome ...");
	}
	
	
	@GetMapping("/login/loginForm")
	public String loginForm() {
		log.info("Welcome Login Form");
		return "login/loginForm";
	}
	
	@GetMapping("/rest/ajaxList")
	public void board() {
		log.info("restBoard ...");
	}
	
	
	
	@RequestMapping(value = "/loginInfo", method = RequestMethod.GET)
	public String loginInfo(Principal principal,Model model) {
		
		//1.Controller를 통하여 Pincipal객체로 가져오는 방법
		String user_id = principal.getName();
		System.out.println("유저 아이디:" + user_id   );
		
		//2.SpringContextHolder를 통하여 가져오는 방법(일반적인 빈에서 사용 할수있음 )
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        user_id = auth.getName();
        System.out.println("유저 아이디:" + user_id   );
        
        //3.
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        System.out.println(userDetails.getUsername());

        
        return "home";
	}
	
}