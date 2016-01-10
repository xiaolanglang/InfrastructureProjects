package com.bkweb.modules.menu.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.bkweb.common.dao.impl.CrudDao;
import com.bkweb.modules.menu.entity.MenuSort;

@Component
public class MenuSortDao extends CrudDao<MenuSort> {

	public List<MenuSort> findAllParentList() {
		Criteria criteria = getCriteria(MenuSort.class);
		Criterion c = Restrictions.eqOrIsNull("parent", null);
		criteria.add(c);
		criteria.addOrder(Order.asc("ord"));
		@SuppressWarnings("unchecked")
		List<MenuSort> list = criteria.list();
		return list;
	}
}
