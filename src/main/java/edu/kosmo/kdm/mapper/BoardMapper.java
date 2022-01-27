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
   void updateHit(int id);
   
   
   //댓글관련
   void updateShape(BoardVO boardVO);
   void insertReply(BoardVO boardVO);
   
 //페이징 처리 관련
 	int getTotalCount();
 	List<BoardVO> getListWithPaging(Criteria criteria);
}