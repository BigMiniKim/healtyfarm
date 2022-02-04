package edu.kosmo.kdm.service;

import javax.inject.Inject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kosmo.kdm.mapper.MemberMapper;
import edu.kosmo.kdm.vo.MemberVO;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor
@Service
public class MemberService {

	@Inject
	private BCryptPasswordEncoder passEncoder;

	@Inject
	private MemberMapper memberMapper;
	
	@Transactional(rollbackFor = Exception.class)
	public void addMember(MemberVO memberVO) {
		String password = memberVO.getPassword();
		String encode = passEncoder.encode(password);

		memberVO.setPassword(encode);

		memberMapper.insertMember(memberVO);
		memberMapper.insertAuthorities(memberVO);
		
	}
}