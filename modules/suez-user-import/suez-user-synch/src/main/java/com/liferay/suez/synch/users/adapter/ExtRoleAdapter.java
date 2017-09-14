package com.liferay.suez.synch.users.adapter;

import java.text.ParseException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.exportimport.kernel.lar.ExportImportThreadLocal;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.service.ClassNameLocalService;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.service.ContactLocalService;
import com.liferay.portal.kernel.service.GroupLocalService;
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
			throws PortalException, ParseException {
				
		try {
			
			long roleId = _counterLocalService.increment();
			long classNameId = _classNameLocalService.getClassNameId(this.extRole.getClassName());
			Role role = _roleLocalService.createRole(roleId);
			role.setClassName(this.extRole.getClassName());
			role.setClassNameId(classNameId);
			role.setClassPK(roleId);
			if (serviceContext != null) {
				role.setUuid(serviceContext.getUuid());
			}
			User user = _userLocalService.getUser(serviceContext.getUserId());
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

			role = _roleLocalService.updateRole(role);
			
			// Resources

			long ownerId = serviceContext.getUserId();

			if (user.isDefaultUser()) {
				ownerId = 0;
			}

			_resourceLocalService.addResources(
				user.getCompanyId(), 0, ownerId, Role.class.getName(),
				role.getRoleId(), false, false, false);

			if (!user.isDefaultUser()) {
				_resourceLocalService.addResources(
					user.getCompanyId(), 0, user.getUserId(), Role.class.getName(),
					role.getRoleId(), false, false, false);

				if (!ExportImportThreadLocal.isImportInProcess()) {
					reindex(user);
				}
			}

			return role;
		} catch (Exception e) {
			// TODO: handle exception
		}
				
		return null;
				
	}
	private ExtRole extRole;
	
	
	@Reference
	public void setCounterLocalService(CounterLocalService counterLocalService){
		_counterLocalService = counterLocalService;
	}
	protected static CounterLocalService _counterLocalService;
	
	protected static GroupLocalService _groupLocalService;
	
	@Reference
	public void resourceLocalService(ResourceLocalService resourceLocalService){
		_resourceLocalService = resourceLocalService;
	}
	protected static ResourceLocalService _resourceLocalService;

	@Reference
	public void setRoleLocalService(RoleLocalService roleLocalService){
		_roleLocalService = roleLocalService;
	}
	protected static RoleLocalService _roleLocalService;
	
	@Reference
	public void setClassNameleLocalService(ClassNameLocalService classNameLocalService){
		_classNameLocalService = classNameLocalService;
	}
	protected static ClassNameLocalService _classNameLocalService;
	
	@Reference
	public void setUserLocalService(UserLocalService userLocalService){
		_userLocalService = userLocalService;
	}
	protected static UserLocalService _userLocalService;
	
	protected void reindex(User user) throws SearchException {
		Indexer<User> indexer = IndexerRegistryUtil.nullSafeGetIndexer(
			User.class);
		indexer.reindex(user);
	}
}
