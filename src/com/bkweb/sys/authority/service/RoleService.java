package com.bkweb.sys.authority.service;

import org.springframework.stereotype.Service;

import com.bkweb.common.service.impl.CrudService;
import com.bkweb.sys.authority.dao.RoleDao;
import com.bkweb.sys.authority.entity.Role;

@Service
public class RoleService extends CrudService<RoleDao, Role> {

}
