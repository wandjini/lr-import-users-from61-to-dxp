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
 * The extended model interface for the ExtUser service. Represents a row in the &quot;user_&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ExtUserModel
 * @see com.liferay.suez.user.synch.model.impl.ExtUserImpl
 * @see com.liferay.suez.user.synch.model.impl.ExtUserModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.suez.user.synch.model.impl.ExtUserImpl")
@ProviderType
public interface ExtUser extends ExtUserModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.suez.user.synch.model.impl.ExtUserImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ExtUser, Long> USER_ID_ACCESSOR = new Accessor<ExtUser, Long>() {
			@Override
			public Long get(ExtUser extUser) {
				return extUser.getUserId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ExtUser> getTypeClass() {
				return ExtUser.class;
			}
		};
}