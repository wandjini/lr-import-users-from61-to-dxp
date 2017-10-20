package com.liferay.suez.synch.users.adapter;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.exportimport.kernel.lar.ExportImportThreadLocal;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.service.ClassNameLocalService;
import com.liferay.portal.kernel.service.ResourceLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.suez.user.synch.model.ExtRole;

/**
 * 
 * @author guy
 *
 */
@Component(
		immediate = true,
		properties = {}
	)
public class ExtRoleAdapter {

	/**
	 * default constructor
	 */
	public ExtRoleAdapter() {
		super();
	}
	
	/**
	 * Constructor based on an external role
	 */
	public ExtRoleAdapter(final ExtRole extRole){
		this.extRole = extRole;
	}
	
	
	/**
	 * 
	 * @param serviceContext
	 * @return
	 */
	public final Role adaptExternalRoletoRole(ServiceContext serviceContext) 
			throws PortalException {
				
		try {
			
			long roleId = counterLocService.increment();
			long classNameId = classNameLocService.getClassNameId(this.extRole.getClassName());
			Role role = roleLocService.createRole(roleId);
			role.setClassName(this.extRole.getClassName());
			role.setClassNameId(classNameId);
			role.setClassPK(roleId);
			if (serviceContext != null) {
				role.setUuid(serviceContext.getUuid());
			}
			User user = userLocService.getUser(serviceContext.getUserId());
			role.setCompanyId(serviceContext.getCompanyId());
			role.setUserId(serviceContext.getUserId());
			role.setUserName(user.getFullName());
			role.setClassNameId(classNameId);
			role.setName(this.extRole.getName());
			role.setTitleMap(this.extRole.getTitleMap());
			role.setDescriptionMap(this.extRole.getDescriptionMap());
			role.setType(this.extRole.getType());
			role.setSubtype(this.extRole.getSubtype());
			role.setExpandoBridgeAttributes(serviceContext);

			role = roleLocService.updateRole(role);
			
			// Resources

			long ownerId = serviceContext.getUserId();

			if (user.isDefaultUser()) {
				ownerId = 0;
			}

			resourceLocService.addResources(
				user.getCompanyId(), 0, ownerId, Role.class.getName(),
				role.getRoleId(), false, false, false);

			if (!user.isDefaultUser()) {
				resourceLocService.addResources(
					user.getCompanyId(), 0, user.getUserId(), Role.class.getName(),
					role.getRoleId(), false, false, false);

				if (!ExportImportThreadLocal.isImportInProcess()) {
					reindex(user);
				}
			}

			return role;
		} catch (Exception e) {
			log.debug(e);
		}
				
		return null;
				
	}
	private ExtRole extRole;
	
	
	@Reference
	protected static CounterLocalService counterLocService;
	@Reference
	protected static ResourceLocalService resourceLocService;

	@Reference
	protected static RoleLocalService roleLocService;
	
	@Reference
	protected static ClassNameLocalService classNameLocService;
	
	@Reference
	protected static UserLocalService userLocService;
	
	protected void reindex(User user) throws SearchException {
		Indexer<User> indexer = IndexerRegistryUtil.nullSafeGetIndexer(
			User.class);
		indexer.reindex(user);
	}
	private static final Log log = LogFactoryUtil.getLog(
			ExtRoleAdapter.class);
}
