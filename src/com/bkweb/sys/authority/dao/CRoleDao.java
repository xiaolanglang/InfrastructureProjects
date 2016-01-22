package com.bkweb.sys.authority.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bkweb.common.dao.impl.CrudDao;
import com.bkweb.sys.account.entity.Account;
import com.bkweb.sys.authority.entity.Role;

@Repository
public class CRoleDao extends CrudDao<Role> {

	@SuppressWarnings("unchecked")
	public List<Role> findRoleListByAccount(Account account) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("select * from sys_role r ");
		buffer.append("join sys_account_role ar on ar.role_id = r.id ");
		buffer.append("where ar.account_id = :id ");
		return getSession().createSQLQuery(buffer.toString()).addEntity(Role.class).setString("id", account.getId())
				.list();
	}

}
