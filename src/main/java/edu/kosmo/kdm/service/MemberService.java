package edu.kosmo.kdm.service;

import javax.inject.Inject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.kosmo.kdm.mapper.MemberMapper;
import edu.kosmo.kdm.vo.MemberVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class MemberService {
   
	@Inject
	private BCryptPasswordEncoder passEncoder;
	
   @Inject
   private MemberMapper memberMapper;
   
	/*
	 * public EmpVO getUser(String empNo){ log.info("readUser .. "); return
	 * empMapper.readUser(empNo); }
	 */
   public MemberVO getUser(String id){
	      log.info("readUser .. ");
	     
			/*
			 * Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			 * user_id = auth.getName(); System.out.println("유저 아이디:" + user_id );
			 */
	        
	      MemberVO memberVO = memberMapper.readUser(id);
	      memberVO.setAuthList(memberMapper.readAuthority(id));
	      
	      return memberVO;
	   }
}