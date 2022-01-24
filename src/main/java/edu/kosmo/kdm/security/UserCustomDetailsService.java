package edu.kosmo.kdm.security;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.kosmo.kdm.mapper.MemberMapper;
import edu.kosmo.kdm.vo.MemberCustom;
import edu.kosmo.kdm.vo.MemberVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;


/*
 * username을 가지고 사용자 정보를 조회하고 session에 저장될 사용자 주체 정보인 
 * UserDetails를 반환하는 Interface다.
 */

@Log4j
@Service
public class UserCustomDetailsService implements UserDetailsService  {
	
	@Setter(onMethod_ = @Autowired)
	private MemberMapper memberMapper;

	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		
		log.warn("Load User By MemberVO number: " + id);
		MemberVO vo = memberMapper.getMember(id);

		log.warn("queried by MemberVO mapper: " + vo);

		return vo == null ? null : new MemberCustom(vo);		
	}
}