/**
 * 
 */
package com.huyld.xpense.service.user;

import com.huyld.xpense.model.User;

/**
 * @author ldhuy
 * Created on: 07/01/2017
 * 
 */
public interface UserSharedService {

	public User findOne(String username);
}
