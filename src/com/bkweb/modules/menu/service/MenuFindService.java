package com.bkweb.modules.menu.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bkweb.common.service.impl.CrudService;
import com.bkweb.modules.menu.dao.MenuFindDao;
import com.bkweb.modules.menu.entity.MenuFind;

@Service
@Transactional(readOnly = true)
public class MenuFindService extends CrudService<MenuFindDao, MenuFind> {

}
