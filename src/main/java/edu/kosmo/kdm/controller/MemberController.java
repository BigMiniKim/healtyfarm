package edu.kosmo.kdm.controller;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.kosmo.kdm.service.MemberService;
import edu.kosmo.kdm.service.ProductService;
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