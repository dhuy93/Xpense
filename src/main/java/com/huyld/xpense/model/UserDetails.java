/**
 * 
 */
package com.huyld.xpense.model;

import org.springframework.security.core.authority.AuthorityUtils;
import com.huyld.xpense.model.User;

/**
 * @author ldhuy
 * Created on: 07/01/2017
 * 
 * Class to store authenticated user information which is used in Spring Security.
 *
 */
public class UserDetails extends org.springframework.security.core.userdetails.User {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8623292913503812470L;
	private final com.huyld.xpense.model.User user;

	public UserDetails(User user) {
		super(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRoleName()));
		this.user = user;
	}
	
	public User getUser() {
		return this.user;
	}
}
