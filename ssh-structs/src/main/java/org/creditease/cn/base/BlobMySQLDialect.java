package org.creditease.cn.base;

import java.sql.Types;

import org.hibernate.Hibernate;
import org.hibernate.dialect.MySQLDialect;


public class BlobMySQLDialect extends MySQLDialect{
	public BlobMySQLDialect() {
		// TODO Auto-generated constructor stub
		super();
        registerHibernateType(Types.LONGVARCHAR, Hibernate.TEXT.getName());
	}
}
