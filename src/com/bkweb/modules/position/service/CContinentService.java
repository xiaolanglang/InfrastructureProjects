package com.bkweb.modules.position.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bkweb.common.service.impl.CrudService;
import com.bkweb.modules.position.dao.CContinentDao;
import com.bkweb.modules.position.entity.Continent;

@Service
@Transactional
public class CContinentService extends CrudService<CContinentDao, Continent> {

}
