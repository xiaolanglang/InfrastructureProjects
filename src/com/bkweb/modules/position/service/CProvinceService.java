package com.bkweb.modules.position.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bkweb.common.service.impl.CrudService;
import com.bkweb.modules.position.dao.CProvinceDao;
import com.bkweb.modules.position.entity.Province;

@Service
@Transactional
public class CProvinceService extends CrudService<CProvinceDao, Province> {

}
