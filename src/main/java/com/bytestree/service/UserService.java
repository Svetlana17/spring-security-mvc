/**
 * 
 */
package com.bytestree.service;

import com.bytestree.model.Users;

/**
 * @author bytestree
 *
 */
public interface UserService {

	void saveLastLoginDate(String username);

	Users getUser(String username);

	void saveUser(Users user);
}
