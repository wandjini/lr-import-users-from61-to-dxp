package com.liferay.suez.synch.users.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;


@ExtendedObjectClassDefinition(category = "collaboration")
@Meta.OCD(
	id = "com.liferay.suez.synch.users.configuration.SynchSuezUsersConfiguration",
	localization = "content/Language",
	name = "suez.users.synch.configuration.name"
)
public interface SynchSuezUsersConfiguration {
	@Meta.AD(
			deflt = "1", description = "synch-suez-users-interval-help",
			required = false
		)
	public int synchSuezUsersInterval();
	
	@Meta.AD(
			deflt = "50", description = "itens-per-page",
			required = false
		)
	public int itemsPerPage();
	@Meta.AD(
			deflt = "20156", description = "synch-suez-users-creator-user-id",
			required = false
		)
	public long creatorUserId();
	@Meta.AD(
			deflt = "20116", description = "synch-suez-users-company-id",
			required = false
		)
	public long companyId();

}

