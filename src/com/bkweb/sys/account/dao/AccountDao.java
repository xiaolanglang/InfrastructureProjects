package com.bkweb.sys.account.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.bkweb.common.dao.impl.CrudDao;
import com.bkweb.sys.account.entity.Account;

/**
 * User Dao
 * 
 * @author yourName
 * @version 2015-6-19
 */
@Repository
public class AccountDao extends CrudDao<Account> {

	public Account login(String userName, String passWord) {
		Criteria criteria = getCriteria(Account.class);
		criteria.add(Restrictions.eq("username", userName));
		criteria.add(Restrictions.eq("password", passWord));
		criteria.setCacheable(false);
		@SuppressWarnings("unchecked")
		List<Account> list = criteria.list();
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public Account getAccountByUsername(Account account) {
		Criteria criteria = getCriteria(Account.class);
		criteria.add(Restrictions.eq("username", account.getUsername()));
		@SuppressWarnings("unchecked")
		List<Account> list = criteria.list();
		if (list != null && list.size() == 1) {
			return list.get(0);
		}
		return null;
	}

}
