package com.bkweb.modules.menu.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bkweb.common.service.impl.CrudService;
import com.bkweb.modules.menu.dao.CMenuSortDao;
import com.bkweb.modules.menu.entity.MenuSort;

@Service
@Transactional(readOnly = true)
public class CMenuSortService extends CrudService<CMenuSortDao, MenuSort> {

	public List<MenuSort> findAllParentList() {
		return dao.findAllParentList();
	}

	public List<MenuSort> findAllSortList() {
		return dao.findAllSortList();
	}

}
