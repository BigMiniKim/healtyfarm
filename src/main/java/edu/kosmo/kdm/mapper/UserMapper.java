package edu.kosmo.kdm.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import edu.kosmo.kdm.vo.MemberVO;

@Mapper
public interface UserMapper {
	
	public MemberVO getMember(String id);	
	
	@Insert("insert into member(id,password,resident_registration_number, name, email, phone_number, address, enabled) values(#{id},#{password},#{resident_registration_number},#{name}, #{enabled}, #{email}, #{phone_number}, #{address}, #{enabled}")
	public int insertUser(MemberVO memberVO);

	@Insert("insert into AUTHORITIES (role,AUTHORITY,member_id) values(#{role},'ROLE_USER', #{member_id})")
	public void insertAuthorities(MemberVO memberVO);

	
}