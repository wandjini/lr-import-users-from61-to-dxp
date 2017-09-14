package com.liferay.suez.user.synch.service.persistence.impl;

import java.math.BigInteger;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.liferay.portal.dao.orm.custom.sql.CustomSQLUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.suez.user.synch.model.ExtUser;
import com.liferay.suez.user.synch.model.impl.ExtUserImpl;
import com.liferay.suez.user.synch.service.persistence.ExtUserFinder;

public class ExtUserFinderImpl extends ExtUserFinderBaseImpl  implements ExtUserFinder{
	
	public List<ExtUser> findUsersByCompanyAndRole(long companyId, long roleId, 
			Date startDate, Date endDate, int start, int end ){
		 Session session = null;
		    try {
		        session = openSession();

		        String sql = CustomSQLUtil.get(getClass(),
		        		FIND_BY_ROLE_COMPANY );
		        
		        if(startDate !=null && endDate != null){
		        	sql+= " AND (u.createdate BETWEEN "+startDate + "AND "+ endDate+")";
		        }
		        SQLQuery q = session.createSQLQuery(sql);
		        q.setCacheable(false);
		        q.addEntity(ExtUserImpl.TABLE_NAME, ExtUserImpl.class);

		        QueryPos qPos = QueryPos.getInstance(q);
		        qPos.add(roleId);
		        qPos.add(companyId);
		        return (List<ExtUser>) QueryUtil.list(q, getDialect(), start, end);
		    }
		    catch (Exception e) {
		        try {
		            throw new SystemException(e);
		        }
		        catch (SystemException se) {
		            se.printStackTrace();
		        }
		    }
		    finally {
		        closeSession(session);
		    }

		    return null;
		
	}
	
	public int countUsersByCompanyAndRole(long companyId, long roleId,
			Date startDate, Date endDate){
		 Session session = null;
		    try {
		        session = openSession();

		        String sql = CustomSQLUtil.get(getClass(),
		        		COUNT_BY_ROLE_COMPANY);
		        if(startDate !=null && endDate != null){
		        	sql+= " AND (u.createdate BETWEEN "+startDate + "AND "+ endDate+")";
		        }
		        SQLQuery q = session.createSQLQuery(sql);
		        q.setCacheable(false);
		       
		        QueryPos qPos = QueryPos.getInstance(q);
		        qPos.add(roleId);
		        qPos.add(companyId);
		        Iterator<Long> itr = q.iterate();
		        if (itr.hasNext()) {
					Object count = itr.next();

					if (count != null) {
						return ((BigInteger)count).intValue();
					}
				}

				return 0;
		    }
		    catch (Exception e) {
		        try {
		            throw new SystemException(e);
		        }
		        catch (SystemException se) {
		            se.printStackTrace();
		        }
		    }
		    finally {
		        closeSession(session);
		    }

		    return 0;
		
	}

	public static final String FIND_BY_ROLE_COMPANY =
			ExtUser.class.getName() +
		        ".findUsersByCompanyAndRole";
	public static final String COUNT_BY_ROLE_COMPANY =
			ExtUser.class.getName() +
		        ".countUsersByCompanyAndRole";
	
}