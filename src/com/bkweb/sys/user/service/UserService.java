package com.bkweb.sys.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bkweb.common.service.impl.CrudService;
import com.bkweb.sys.user.dao.UserDao;
import com.bkweb.sys.user.entity.User;

@Service
@Transactional
public class UserService extends CrudService<UserDao, User> {

}
