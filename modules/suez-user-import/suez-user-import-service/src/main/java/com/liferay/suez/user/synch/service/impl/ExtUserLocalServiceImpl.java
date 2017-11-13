/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.suez.user.synch.service.impl;

import aQute.bnd.annotation.ProviderType;

import java.util.Date;
import java.util.List;

import com.liferay.suez.user.synch.model.ExtUser;
import com.liferay.suez.user.synch.service.base.ExtUserLocalServiceBaseImpl;

/**
 * The implementation of the ext user local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.suez.user.synch.service.ExtUserLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExtUserLocalServiceBaseImpl
 * @see com.liferay.suez.user.synch.service.ExtUserLocalServiceUtil
 */
@ProviderType
public class ExtUserLocalServiceImpl extends ExtUserLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.suez.user.synch.service.ExtUserLocalServiceUtil} to access the ext user local service.
	 */

	/**
	 * <p> This method return users</p>
	 * 
	 * @return -> List of external users  
	 */
	public List<ExtUser> findExtUsers(int start, int end){
		
		return extUserPersistence.findAll(start, end);
	}
	
	/**
	 * This method return the total number of external users
	 */
	public int countExtUsers(){
		
		return extUserPersistence.countAll();
	}
	
	/**
	 * This method returns the list of external users filtered by company and role
	 * 
	 * 
	 */
	public List<ExtUser> findExtUsersByCompanyAndRole(long companyId, long roleId, 
			Date startDate, Date endDate, int start, int end){
		
		return extUserFinder.findUsersByCompanyAndRole(companyId, roleId, startDate, endDate, start, end);
	}
	
	/**
	 * This method returns the number of external users filtered by company and role
	 * 
	 * 
	 */
	public int countExtUsersByCompanyAndRole(long companyId, long roleId, 
			Date startDate, Date endDate){
		
		return extUserFinder.countUsersByCompanyAndRole(companyId, roleId, startDate, endDate);
	}
	
	/**
	 * This method returns the number of external users filtered by company and list of roles
	 * 
	 * 
	 */
	public int countExtUsersByCompanyAndRoleIds(long companyId, Long[] roleIds, 
			Date startDate, Date endDate){
		
		return extUserFinder.countUsersByCompanyAndRoleIds(companyId, roleIds, startDate, endDate);
	}
}