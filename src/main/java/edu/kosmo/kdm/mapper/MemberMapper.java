package edu.kosmo.kdm.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import edu.kosmo.kdm.vo.MemberVO;

@Mapper
public interface MemberMapper {
	
	public MemberVO getMember(String id);	
	
	@Insert("insert into member(id,password, enabled) values(#{id},#{password}, #{enabled})")
	public int insertUser(MemberVO memberVO);

	@Insert("insert into authorities (role,authority ,member_id) values(0, 'ROLE_USER', #{id})")
	public void insertAuthorities(MemberVO memberVO);

	
}