/**
 * 
 */
package com.huyld.xpense.service.user;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huyld.xpense.model.User;
import com.huyld.xpense.model.UserDetails;

/**
 * @author ldhuy
 * Created on: 07/01/2017
 * 
 * Service to fetch authentication user information which is used in Spring Security.
 *
 */
@Service
public class UserDetailsServiceExt implements UserDetailsService {

	@Inject
	private UserSharedService userSharedService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 */
	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userSharedService.findOne(username);
		if (user == null) {
			throw new UsernameNotFoundException("Username not found: " + username);
		}
		return new UserDetails(user);
	}

}
