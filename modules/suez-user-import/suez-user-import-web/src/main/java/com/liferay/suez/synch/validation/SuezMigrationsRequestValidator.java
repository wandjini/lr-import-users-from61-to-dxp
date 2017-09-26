package com.liferay.suez.synch.validation;

import java.util.List;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.suez.synch.users.util.SuezMigrationRequest;

/**
 * This class is used to validate the request object
 * @author guy
 *
 */
public class SuezMigrationsRequestValidator {

public static boolean isSuezMigrationRequestValid(SuezMigrationRequest  suezMigrationRequest, int extRolesSize, List<String> errors){
		boolean result = true;
		
		if(suezMigrationRequest.getExtCompanyId() <=0){
			errors.add("invalid-ext-company");
			result = false;
		}
		if(suezMigrationRequest.getDestinationGroupId() <=0){
			errors.add("invalid-destination-site");
			result = false;
		}
		if(!Validator.isDate(suezMigrationRequest.getStartDate().getMonth(),
				suezMigrationRequest.getStartDate().getDate(),
				suezMigrationRequest.getStartDate().getYear())){
			errors.add("invalid-start-date");
			result = false;
		}
		if(!Validator.isDate(suezMigrationRequest.getEndDate().getMonth(),
				suezMigrationRequest.getEndDate().getDate(),
				suezMigrationRequest.getEndDate().getYear())){
			errors.add("invalid-end-date");
			result = false;
		}
		if(suezMigrationRequest.getExtRoleNewRoleMap() == null 
				|| suezMigrationRequest.getExtRoleNewRoleMap().keySet().isEmpty()
				|| suezMigrationRequest.getExtRoleNewRoleMap().keySet().size() != extRolesSize){
			errors.add("invalid-roles-mapping");
			result = false;
		}
		return result;
		
	}
}
