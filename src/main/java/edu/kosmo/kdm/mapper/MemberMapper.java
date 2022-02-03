package edu.kosmo.kdm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import edu.kosmo.kdm.vo.AuthVO;
import edu.kosmo.kdm.vo.MemberVO;

@Mapper
public interface MemberMapper {
	
	public MemberVO getMember(String id);	
	
	@Insert("insert into member(id,password, enabled) values(#{id},#{password}, #{enabled})")
	public int insertMember(MemberVO memberVO);
	
	@Select("select member_id , case when member_id = 'admin' then 'ROLE_ADMIN' else 'ROLE_USER' end authority from authorities where member_id = #{member_id})")
		public List<AuthVO> readAuthority(String id);
	
	@Insert("insert into authorities (authority ,member_id) values( 'ROLE_ADMIN', #{id})")
	public void insertAuthorities(MemberVO memberVO);


	
}