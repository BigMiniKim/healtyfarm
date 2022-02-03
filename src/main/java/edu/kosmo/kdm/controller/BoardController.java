package edu.kosmo.kdm.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.kosmo.kdm.page.Criteria;
import edu.kosmo.kdm.page.PageVO;
import edu.kosmo.kdm.service.BoardService;
import edu.kosmo.kdm.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@Controller
public class BoardController {
	
	@Inject
	private BoardService boardService;
	

	//http://localhost:8282/ex/content_view?bid=27
	@GetMapping("board/content_view")
	public String content_view(BoardVO boardVO, Model model) {
		
		log.info("content_view()...");
		log.info("BoardVO" + boardVO);
		
		int id = boardVO.getId();
		//boardService.upHit(bid);
		model.addAttribute("content_view", boardService.get(id)) ;
		
		return "board/content_view";
			
			
		}
	@GetMapping("board/write_view")
	public String write_view() {
		
		log.info("write_view()...");
				
		return "board/write_view";
			
			
		}
	
	@PostMapping("board/write")
	public String write(BoardVO boardVO) {
		
		log.info("write()...");
		boardService.register(boardVO);
		
		return "redirect:list";
			
			
		}
	@GetMapping("board/reply_view")
	public String reply_view(BoardVO boardVO, Model model) {
		
		log.info("reply_view()...");
		
		model.addAttribute("reply_view", boardService.get(boardVO.getId()));
		
		return "board/reply_view";
			
			
		}
	
	@PostMapping("board/reply")
	public String reply(BoardVO boardVO, Model model) {
		
		log.info("reply()...");
		
		 boardService.registerReply(boardVO);
		
		return "redirect:list";
			
			
		}
	
	@GetMapping("board/delete")
	public String delete(BoardVO boardVO, Model model) {
		
		log.info("delete()...");
		
		boardService.remove(boardVO.getId());
		
		return "redirect:list";
	}
	@PostMapping("board/modify")
	public String modify(BoardVO boardVO, Model model) {
		
		log.info("modify()...");
		
		 boardService.modify(boardVO);
		
		return "redirect:list";
			
			
		}
	// /http:/localhost:8282/ex/list2?pageNum1&amount=10
	@GetMapping("board/list")
	public String list2 (Criteria cri,Model model) {
		
		log.info("list()...");
		log.info("Criteira" + cri);
		model.addAttribute("boardList", boardService.getList(cri));
		int total = boardService.getTotal();
		
		log.info("total" + total);
		
		model.addAttribute("pageMaker", new PageVO(cri, total));
		
		return "board/list";
	}
}