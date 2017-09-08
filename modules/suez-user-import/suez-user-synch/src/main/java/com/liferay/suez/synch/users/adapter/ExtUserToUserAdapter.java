package com.liferay.suez.synch.users.adapter;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.suez.user.synch.model.ExtUser;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Class that adapts an ExtUser to Liferay's User.
 * @author ibairuiz
 *
 */
@Component(
		immediate = true,
		properties = {}
	)
public class ExtUserToUserAdapter {
	
	/** ExtUser instance to adapt.**/
	private ExtUser extUser;

	/**
	 * Default public constructor
	 */
	public ExtUserToUserAdapter() {
		super();
	}
	
	/**
	 * Constructor based on an external User.
	 * @param externalUser the external user to adapt.
	 */
	public ExtUserToUserAdapter(final ExtUser externalUser) {
		this.extUser = externalUser;
	}

	/**
	 * Method that adapts an ExtUser to User
	 * @param extUser Original 6.1 User
	 * @param user DXP User created beforehand
	 * @return updated User instance.
	 */
	public final User adaptExternalUsertoUser() {
		User user = _userLocalService.createUser(_counterLocalService.increment(User.class.getName()));
		user.setAgreedToTermsOfUse(this.extUser.getAgreedToTermsOfUse());
		user.setPasswordEncrypted(true);
		user.setPassword(extUser.getPassword());
		/*...
		 * here would go the rest of the fields.
		 * a more generic approach would be to use reflection
		 * to recursively call the same method on both users.
		 * 
		 */
		return user;
	}

	/**
	 * Setter for extUser 
	 * @return extUser
	 */
	public ExtUser getExtUser() {
		return extUser;
	}

	/**
	 * Getter for extUser
	 * @param externalUser
	 */
	public void setExtUser(final ExtUser externalUser) {
		this.extUser = externalUser;
	}

	@Reference
	static UserLocalService _userLocalService;
	
	@Reference
	static CounterLocalService _counterLocalService;

}
