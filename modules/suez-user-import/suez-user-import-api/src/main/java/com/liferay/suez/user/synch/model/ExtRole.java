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

package com.liferay.suez.user.synch.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the ExtRole service. Represents a row in the &quot;role_&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ExtRoleModel
 * @see com.liferay.suez.user.synch.model.impl.ExtRoleImpl
 * @see com.liferay.suez.user.synch.model.impl.ExtRoleModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.suez.user.synch.model.impl.ExtRoleImpl")
@ProviderType
public interface ExtRole extends ExtRoleModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.suez.user.synch.model.impl.ExtRoleImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ExtRole, Long> ROLE_ID_ACCESSOR = new Accessor<ExtRole, Long>() {
			@Override
			public Long get(ExtRole extRole) {
				return extRole.getRoleId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ExtRole> getTypeClass() {
				return ExtRole.class;
			}
		};

	public static final Accessor<ExtRole, String> NAME_ACCESSOR = new Accessor<ExtRole, String>() {
			@Override
			public String get(ExtRole extRole) {
				return extRole.getName();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<ExtRole> getTypeClass() {
				return ExtRole.class;
			}
		};
}