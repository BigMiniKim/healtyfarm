package edu.kosmo.kdm.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.kosmo.kdm.page.Criteria;
import edu.kosmo.kdm.vo.BoardVO;

@Mapper
public interface BoardMapper {

	List<BoardVO> getList();

	BoardVO read(int id);

	void insert(BoardVO board);

	void delete(int id);
	void update( BoardVO board);
	//void update(@Param("board") BoardVO board); //BoardMapper.xml 에서 #{board.bname}, #{board.btitle}, #{board.bcontent}....
	//void update(@Param("board") BoardVO board, @paran("emp") Emp emp) #{board.bname} #{emp.salary}
	//void update(@Param("bid") int bid, @Param("bcontent") String bcontent, @Param("btitle") String btitle);//단일이 아닌 다수 객체 @Param

	void updateHit(int id);
	
	//댓글관련
	void updateShape(BoardVO boardVO);

	void insertReply(BoardVO boardVO);
	
	int getTotalCount();
	List<BoardVO> getListWithPaging(Criteria criteria);

}