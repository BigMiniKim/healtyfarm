package edu.kosmo.kdm.controller;

import java.awt.PageAttributes.MediaType;
import java.net.http.HttpHeaders;
import java.util.Iterator;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UrlPathHelper;

import edu.kosmo.kdm.service.MemberService;
import edu.kosmo.kdm.vo.MemberVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@Controller
public class MemberController {

	@Inject
	private MemberService memberService;

	@GetMapping("/add/addForm")
	public void memberForm() {
		log.info("Welcome memberForm");
	}

	@PostMapping("/add/addMember")
	public String addMember(MemberVO membervo) {
		log.info("post resister");
		memberService.addMember(membervo);

		return "redirect:/";

	}
	


}