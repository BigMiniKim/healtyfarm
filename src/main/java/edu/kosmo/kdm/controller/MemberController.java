package edu.kosmo.kdm.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.kosmo.kdm.service.MemberService;
import edu.kosmo.kdm.vo.MemberVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@Controller
public class MemberController {

	@Inject
	private MemberService userService;

	@GetMapping("/add/addForm")
	public void userForm() {
		log.info("Welcome userForm");
	}

	@PostMapping("/add/addUser")
	public String addUser(MemberVO membervo) {
		log.info("post resister");
		userService.addUser(membervo);

		return "redirect:/";
	}
}