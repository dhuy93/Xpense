/**
 * 
 */
package com.huyld.xpense.repository;

import org.springframework.stereotype.Component;

import com.huyld.xpense.model.User;

/**
 * @author ldhuy
 * Created on: 07/01/2017
 *
 */
@Component
public interface UserRepository {

	public User findOne(String username);

}
