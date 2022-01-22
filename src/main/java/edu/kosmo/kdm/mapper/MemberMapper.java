package edu.kosmo.kdm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import edu.kosmo.kdm.vo.AuthVO;
import edu.kosmo.kdm.vo.MemberVO;

@Mapper
public interface MemberMapper {
	
	public MemberVO getUser(String id);	
	
	@Select("select * from member where id = #{id}")
	   public MemberVO readUser(String id);
	   
	
	 @Select("select id,case when role='0' then 'ROLE_ADMIN' else  'ROLE_USER' end authority from authorities where id = #{id}")
	   public List<AuthVO> readAuthority(String id);
	  


	
}