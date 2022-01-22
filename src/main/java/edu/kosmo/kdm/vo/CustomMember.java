package edu.kosmo.kdm.vo;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Getter
@Setter
public class CustomMember extends User {
	
	@Setter(onMethod_ = @Autowired)
	private MemberVO member;
	
	//기본적으로 부모의 생성자를 호출해야만 정상적으로 작동
	public CustomMember(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		
	}
	
	public CustomMember(MemberVO memberVO) {
		super(memberVO.getId(), memberVO.getPassword(),getAuth(memberVO));
		// TODO Auto-generated constructor stub
		this.member = memberVO;
	}
	
	//유저가 갖고 있는 권한 목록
	public static Collection<? extends GrantedAuthority> getAuth(MemberVO memberVO) { 

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for (AuthVO auth: memberVO.getAuthList()) {
			authorities.add(new SimpleGrantedAuthority(auth.getAuthority()));
		}
		
		return authorities;
	}	
}