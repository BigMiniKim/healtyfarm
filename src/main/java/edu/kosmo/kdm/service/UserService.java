package edu.kosmo.kdm.service;

import javax.inject.Inject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kosmo.kdm.mapper.UserMapper;
import edu.kosmo.kdm.vo.MemberVO;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor
@Service
public class UserService {

	@Inject
	private BCryptPasswordEncoder passEncoder;

	@Inject
	private UserMapper userMapper;

	@Transactional(rollbackFor = Exception.class)
	public void addUser(MemberVO memberVO) {
		String password = memberVO.getPassword();
		String encode = passEncoder.encode(password);

		memberVO.setPassword(encode);

		userMapper.insertUser(memberVO);
		userMapper.insertAuthorities(memberVO);
	}
}