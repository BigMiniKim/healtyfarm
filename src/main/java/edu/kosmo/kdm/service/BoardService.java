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

	// 페이징 처리 함수 (위에랑똑같은거기때문에 함수 오버로딩을 적용시켰다)
	public int getTotal();
	public List<BoardVO> getList(Criteria criteria);
}
