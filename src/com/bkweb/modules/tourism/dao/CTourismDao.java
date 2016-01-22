package com.bkweb.modules.tourism.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.bkweb.common.dao.impl.CrudDao;
import com.bkweb.common.utils.dict.DictData;
import com.bkweb.common.utils.hibernatepage.HPage;
import com.bkweb.modules.tourism.entity.Tourism;
import com.bkweb.modules.tourism.entity.TourismImg;

@Repository
public class CTourismDao extends CrudDao<Tourism> {

	public List<TourismImg> searchPageList(String content, boolean flag, HPage<TourismImg> page) {
		return search(content, flag, page, DictData.img_type_3);
	}

	public List<TourismImg> searchSortPageList(String content, boolean flag, HPage<TourismImg> page) {
		return search(content, flag, page, DictData.img_type_1);
	}

	private List<TourismImg> search(String content, boolean flag, HPage<TourismImg> page, String imageType) {
		Criteria criteria = getCriteria(TourismImg.class);
		Criterion a = Restrictions.like("title", content, MatchMode.ANYWHERE);
		Criterion b = Restrictions.like("subtitle", content, MatchMode.ANYWHERE);
		Criterion c = Restrictions.eq("type", imageType);
		criteria.createCriteria("tourism").add(Restrictions.or(a, b));
		criteria.add(c);
		criteria.setCacheable(flag);
		page.init(page, criteria);
		@SuppressWarnings("unchecked")
		List<TourismImg> list = criteria.list();
		page.setList(list);
		return list;
	}
}
