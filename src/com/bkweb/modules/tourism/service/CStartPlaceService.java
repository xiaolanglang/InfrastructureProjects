package com.bkweb.modules.tourism.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bkweb.common.service.impl.CrudService;
import com.bkweb.modules.tourism.dao.CStartPlaceDao;
import com.bkweb.modules.tourism.entity.StartPlace;

@Service
@Transactional
public class CStartPlaceService extends CrudService<CStartPlaceDao, StartPlace> {

}