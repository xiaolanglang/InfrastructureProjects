package com.bkweb.modules.tourism.dao;

import org.springframework.stereotype.Repository;

import com.bkweb.common.dao.impl.CrudDao;
import com.bkweb.modules.tourism.entity.TourismImg;

@Repository
public class CTourismImgDao extends CrudDao<TourismImg> {

	public void clearCover(String tourismId) {
		getSession().createQuery(
				"update " + TourismImg.class.getSimpleName() + " set cover = '0' where tourism.id = '" + tourismId
						+ "'").executeUpdate();
	}
}
