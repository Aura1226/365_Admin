package org.kkk.security;

import org.kkk.domain.MemberVO;
import org.kkk.mapper.MemberMapper;
import org.kkk.security.domain.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private MemberMapper memberMapper;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		log.warn("load user by UserName : " + userName);
		
		MemberVO vo = memberMapper.read(userName);
		
		log.warn("queried by member mapper : " + vo);
		
		return vo == null? null : new CustomUser(vo);
	}

	
	
}
