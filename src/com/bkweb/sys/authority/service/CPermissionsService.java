package com.bkweb.sys.authority.service;

import org.springframework.stereotype.Service;

import com.bkweb.common.service.impl.CrudService;
import com.bkweb.sys.authority.dao.CPermissionsDao;
import com.bkweb.sys.authority.entity.Permissions;

@Service
public class CPermissionsService extends CrudService<CPermissionsDao, Permissions> {

}
