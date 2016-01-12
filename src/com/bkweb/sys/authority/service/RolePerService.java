package com.bkweb.sys.authority.service;

import org.springframework.stereotype.Service;

import com.bkweb.common.service.impl.CrudService;
import com.bkweb.sys.authority.dao.RolePermissionsDao;
import com.bkweb.sys.authority.entity.RolePermission;

@Service
public class RolePerService extends CrudService<RolePermissionsDao, RolePermission> {

}
