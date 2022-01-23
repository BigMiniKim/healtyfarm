package edu.kosmo.kdm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.kosmo.kdm.vo.BoardVO;
import edu.kosmo.kdm.vo.MemberVO;

@Mapper
public interface BoardMapper {
	public BoardVO getlist(int id);	
   List<BoardVO> getList();
  
   

}