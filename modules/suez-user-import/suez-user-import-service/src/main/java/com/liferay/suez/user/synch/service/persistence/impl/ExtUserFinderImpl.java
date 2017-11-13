package com.liferay.suez.user.synch.service.persistence.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.liferay.portal.dao.orm.custom.sql.CustomSQLUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.suez.user.synch.model.ExtUser;
import com.liferay.suez.user.synch.model.impl.ExtUserImpl;
import com.liferay.suez.user.synch.service.persistence.ExtUserFinder;

/**
 * 
 * Finder used to retrieve user to import to the new database portal
 * @author guy
 *
 */
public class ExtUserFinderImpl extends ExtUserFinderBaseImpl  implements ExtUserFinder{
	
	/**
	 * 
	 * This method retrieves users from an external database
	 * 
	 * @param companyId
	 * @param roleId
	 * @param startDate
	 * @param endDate
	 * @param start
	 * @param end
	 * @return list of users
	 */
	public List<ExtUser> findUsersByCompanyAndRole(long companyId, long roleId, 
			Date startDate, Date endDate, int start, int end ){
		 Session session = null;
		 List<ExtUser> extUsers = null;   
		 try {
		        session = openSession();
		        boolean isVAlidDates = startDate !=null && endDate != null;
		        String sql = CustomSQLUtil.get(getClass(),
		        		FIND_BY_ROLE_COMPANY );
		        
		        if(isVAlidDates){
		        	sql+= " AND (u.modifieddate BETWEEN ?  AND ? )";
		        }
		        SQLQuery q = session.createSQLQuery(sql);
		        q.setCacheable(false);
		        q.addEntity(ExtUserImpl.TABLE_NAME, ExtUserImpl.class);

		        QueryPos qPos = QueryPos.getInstance(q);
		        qPos.add(roleId);
		        qPos.add(companyId);
		        if(isVAlidDates){
		        	qPos.add(startDate);
		        	qPos.add(endDate);
		        }
		        extUsers =  (List<ExtUser>) QueryUtil.list(q, getDialect(), start, end);
		    }
		    catch (Exception e) {
		        log.debug("Error retrieving users ", e);
		    }
		    finally {
		        closeSession(session);
		    }

		    return extUsers;
		
	}
	
	/**
	 * 
	 * This method retrieves users number usefull for pagination
	 * 
	 * @param companyId
	 * @param roleId
	 * @param startDate
	 * @param endDate
	 * @return list of users
	 */
	
	public int countUsersByCompanyAndRole(long companyId, long roleId,
			Date startDate, Date endDate){
		 Session session = null;
		 int result = 0;
	    try {
	        session = openSession();
	        boolean isVAlidDates = startDate !=null && endDate != null;
	        String sql = CustomSQLUtil.get(getClass(),
	        		COUNT_BY_ROLE_COMPANY);
	        if(isVAlidDates){
	        	sql+= " AND (u.modifieddate BETWEEN ?  AND ? )";
	        }
	        SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);
	       
	        QueryPos qPos = QueryPos.getInstance(q);
	        qPos.add(roleId);
	        qPos.add(companyId);
	        if(isVAlidDates){
	        	qPos.add(startDate);
	        	qPos.add(endDate);
	        }
	        Iterator<Long> itr = q.iterate();
	        if (itr.hasNext()) {
				Object count = itr.next();

				if (count != null) {
					result =  ((Integer)count).intValue();
				}
			}

	    }
	    catch (Exception e) {
	        log.debug("Error retrieving total users", e);
	    }
	    finally {
	        closeSession(session);
	    }

	    return result;
		
	}

	/**
	 * 
	 * This method retrieves users number usefull for pagination
	 * 
	 * @param companyId
	 * @param roleIds
	 * @param startDate
	 * @param endDate
	 * @return list of users
	 */
	
	public int countUsersByCompanyAndRoleIds(long companyId, Long[] roleIds,
			Date startDate, Date endDate){
		 Session session = null;
		 int result = 0;
	    try {
	        session = openSession();
	        boolean isVAlidDates = startDate !=null && endDate != null;
	        String sql = CustomSQLUtil.get(getClass(),
	        		COUNT_BY_ROLEIDS_COMPANY);
	        if(isVAlidDates){
	        	sql+= " AND (u.modifieddate BETWEEN ?  AND ? )";
	        }
	        if(roleIds != null && roleIds.length > 0){
	        	StringBuilder list = new StringBuilder().append("(");
	        	for(int i = 0; i <roleIds.length; i++){
	        		list.append(Long.toString(roleIds[i]));
	        		if(i!= (roleIds.length -1))
	        			list.append(", ");
	        	}
	        	list.append(")");
	        	sql = sql.replace("[$ROLE_IDS$]", list.toString());
	        }
	        SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);
	       
	        QueryPos qPos = QueryPos.getInstance(q);
	        
	        qPos.add(companyId);
	        if(isVAlidDates){
	        	qPos.add(startDate);
	        	qPos.add(endDate);
	        }
	        Iterator<Long> itr = q.iterate();
	        if (itr.hasNext()) {
				Object count = itr.next();

				if (count != null) {
					result = ((Integer)count).intValue();
				}
			}

	    }
	    catch (Exception e) {
	        log.debug("Error getting total users ",e);
	    }
	    finally {
	        closeSession(session);
	    }

		return result;
		
	}

	public static final String FIND_BY_ROLE_COMPANY =
			ExtUserFinder.class.getName() +
		        ".findUsersByCompanyAndRole";
	public static final String COUNT_BY_ROLE_COMPANY =
			ExtUserFinder.class.getName() +
		        ".countUsersByCompanyAndRole";
	public static final String COUNT_BY_ROLEIDS_COMPANY =
			ExtUserFinder.class.getName() +
		        ".countUsersByCompanyAndRoleIds";
	private final Log log = LogFactoryUtil.getLog(ExtUserFinderImpl.class);
}
