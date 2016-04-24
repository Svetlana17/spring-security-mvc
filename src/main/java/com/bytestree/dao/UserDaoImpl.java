package com.bytestree.dao;

import org.springframework.stereotype.Repository;

import com.bytestree.model.Users;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Users> implements UserDao {


}
