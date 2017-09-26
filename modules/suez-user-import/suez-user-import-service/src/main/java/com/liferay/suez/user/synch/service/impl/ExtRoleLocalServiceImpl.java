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

import java.util.List;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.suez.user.synch.model.ExtRole;
import com.liferay.suez.user.synch.service.base.ExtRoleLocalServiceBaseImpl;

/**
 * The implementation of the ext role local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.suez.user.synch.service.ExtRoleLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExtRoleLocalServiceBaseImpl
 * @see com.liferay.suez.user.synch.service.ExtRoleLocalServiceUtil
 */
@ProviderType
public class ExtRoleLocalServiceImpl extends ExtRoleLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.suez.user.synch.service.ExtRoleLocalServiceUtil} to access the ext role local service.
	 */
	
	public List<ExtRole> getExtRoles(){
		return extRolePersistence.findAll();
	}
	
	public List<ExtRole> getExtRolesByCompany(long companyId){
		return extRolePersistence.findByCompanyId(companyId);
	}
	
	public List<ExtRole> getExtRolesByCompanyAndName(long companyId, String name){
		DynamicQuery rolesDynamicQuery = extRoleLocalService.dynamicQuery();
		rolesDynamicQuery.add(RestrictionsFactoryUtil.eq("companyId", companyId));
		if(Validator.isNotNull(name)){
			rolesDynamicQuery.add(RestrictionsFactoryUtil.ilike("name", "%"+name+"%"));
		}
		rolesDynamicQuery.addOrder(OrderFactoryUtil.asc("name"));
		return extRoleLocalService.dynamicQuery(rolesDynamicQuery);
	}
	
}