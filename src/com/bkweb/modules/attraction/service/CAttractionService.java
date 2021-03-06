package com.bkweb.modules.attraction.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bkweb.common.service.impl.CrudService;
import com.bkweb.modules.attraction.dao.CAttractionDao;
import com.bkweb.modules.attraction.entity.Attraction;

@Service
@Transactional(readOnly = true)
public class CAttractionService extends CrudService<CAttractionDao, Attraction> {

}
