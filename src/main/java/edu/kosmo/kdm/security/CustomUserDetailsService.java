package edu.kosmo.kdm.security;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.kosmo.kdm.mapper.MemberMapper;
import edu.kosmo.kdm.vo.CustomMember;
import edu.kosmo.kdm.vo.MemberVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;


/*
 * username을 가지고 사용자 정보를 조회하고 session에 저장될 사용자 주체 정보인 UserDetails를 반환하는 Interface다.
 */

@Log4j
@Service
public class CustomUserDetailsService implements UserDetailsService  {
   
   @Setter(onMethod_ = @Autowired)
   private MemberMapper memberMapper;

   /*
   loadUserByUsername()에서 하는 일
   - username을 가지고 사용자 정보를 조회
   - 사용자의 Role과 권한(Privilege)을 조회하여, SimpleGrantedAuthority 목록을 authorities에 세팅한다.
   - Authentication 내부 principal 객체에 UserDetails 객체가 저장된다.
   - Authentication 내부 authorities 객체에 사용자의 Role과 권한(Privilege) 정보가 저장된다.
   - UserDetails에 authorities가 세팅되어 있어야, API별 role이나 권한 체크를 진행할 수 있다.
   */
   @Override
   public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
      
      log.warn("Load User By Employee number: " + id);   
      
      MemberVO vo = memberMapper.readUser(id);
      vo.setAuthList(memberMapper.readAuthority(id));
      
      
      
      log.warn("queried by MemberVO mapper: " + vo);      
      
      return vo == null ? null : new CustomMember(vo);      
      //return vo == null ? null : new CustomUserDetails(vo);
      
   }   

}