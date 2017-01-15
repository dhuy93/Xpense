/**
 * 
 */
package com.huyld.xpense.service.user;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huyld.xpense.model.User;
import com.huyld.xpense.repository.UserRepository;

/**
 * @author ldhuy
 * Created on: 07/01/2017
 *
 */
@Service
public class UserSharedServiceImpl implements UserSharedService {

	@Inject
	private UserRepository userRepository;

	/* (non-Javadoc)
	 * @see com.huyld.xpense.service.user.UserSharedService#findOne(java.lang.String)
	 */
	@Transactional(readOnly = true)
	@Override
	public User findOne(String username) {
		User user = userRepository.findOne(username);
		return user;
	}

}
