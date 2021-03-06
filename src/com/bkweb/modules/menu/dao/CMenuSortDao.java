package com.bkweb.modules.menu.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.bkweb.common.dao.impl.CrudDao;
import com.bkweb.modules.menu.entity.MenuSort;

@Repository
public class CMenuSortDao extends CrudDao<MenuSort> {

	public List<MenuSort> findAllParentList() {
		Criteria criteria = getCriteria(MenuSort.class);
		Criterion c = Restrictions.eqOrIsNull("parent", null);
		criteria.add(c);
		criteria.addOrder(Order.asc("ord"));
		@SuppressWarnings("unchecked")
		List<MenuSort> list = criteria.list();
		return list;
	}

	public List<MenuSort> findAllSortList() {
		Criteria criteria = getCriteria(MenuSort.class);
		criteria.add(Restrictions.neOrIsNotNull("parent", null));
		@SuppressWarnings("unchecked")
		List<MenuSort> list = criteria.list();
		return list;
	}
}
