package com.bkweb.modules.tourism.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bkweb.common.service.impl.CrudService;
import com.bkweb.modules.tourism.dao.CTourismImgDao;
import com.bkweb.modules.tourism.entity.TourismImg;

@Service
@Transactional
public class CTourismImgService extends CrudService<CTourismImgDao, TourismImg> {
}
