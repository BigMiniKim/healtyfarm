package edu.kosmo.kdm.service;



import java.util.List;

import edu.kosmo.kdm.page.Criteria;
import edu.kosmo.kdm.vo.BoardVO;

public interface BoardService {
	List<BoardVO> getList();
	BoardVO get(int id);
	void register(BoardVO board);
	void registerReply(BoardVO board);
	void remove(int id);
	void modify(BoardVO boardVO);
	void upHit(int id);
	
	public int getTotal();
	public List<BoardVO> getList(Criteria criteria);
}