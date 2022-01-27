package edu.kosmo.kdm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kosmo.kdm.mapper.BoardMapper;
import edu.kosmo.kdm.page.Criteria;
import edu.kosmo.kdm.vo.BoardVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper boardMapper;

	@Override
	public List<BoardVO> getList() {
		
		log.info("getList() ..");
		
		return boardMapper.getList();
	}

	@Override
	public BoardVO get(int id) {
		log.info("get() ..");
		
		upHit(id);
		return boardMapper.read(id);
	}

	@Override
	public void register(BoardVO board) {
		log.info("register() ..");
		boardMapper.insert(board);
	}

	@Override
	public void registerReply(BoardVO board) {
		log.info("registerReply() ..");
		boardMapper.updateShape(board); // 업데이트 성공
		boardMapper.insertReply(board); //여기서 에러가 남 
	
	}

	@Override
	public void remove(int id) {
		log.info("remove() ..");
		boardMapper.delete(id);
		
	}

	@Override
	public void modify(BoardVO boardVO) {
		log.info("modify() ..");
		boardMapper.update(boardVO);
		
	}

	@Override
	public void upHit(int id) {
		log.info("upHit() ..");
		boardMapper.updateHit(id);
		
	}
	@Override
	public int getTotal() {
		log.info("getTotal()...");
		return boardMapper.getTotalCount();
	}

	@Override
	public List<BoardVO> getList(Criteria criteria) {
		log.info("getList()...");
		return boardMapper.getListWithPaging(criteria);
	}
	

	
}