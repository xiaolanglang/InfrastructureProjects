package com.bkweb.sys.user.dao;

import org.springframework.stereotype.Repository;

import com.bkweb.common.dao.impl.CrudDao;
import com.bkweb.sys.user.entity.User;

@Repository
public class UserDao extends CrudDao<User> {
}
