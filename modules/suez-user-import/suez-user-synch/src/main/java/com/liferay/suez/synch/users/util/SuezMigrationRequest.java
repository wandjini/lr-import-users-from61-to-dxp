package com.liferay.suez.synch.users.util;

import java.util.Date;
import java.util.Map;

import com.liferay.portal.kernel.service.ServiceContext;
/**
 * This object is used to get wrap a migration request
 * 
 * @author guy
 *
 */
public class SuezMigrationRequest {

	
	
	/**
	 * get servicecontext
	 * @return
	 */
	public ServiceContext getServiceContext() {
		return serviceContext;
	}
	public void setServiceContext(ServiceContext serviceContext) {
		this.serviceContext = serviceContext;
	}
	/**
	 * get external companyId to migrate
	 * @return
	 */
	public long getExtCompanyId() {
		return extCompanyId;
	}
	public void setExtCompanyId(long extCompanyId) {
		this.extCompanyId = extCompanyId;
	}
	/**
	 * get destination site id 
	 * @return
	 */
	public long getDestinationGroupId() {
		return destinationGroupId;
	}
	public void setDestinationGroupId(long destinationGroupId) {
		this.destinationGroupId = destinationGroupId;
	}
	/**
	 * get start date 
	 * @return
	 */
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * get end date
	 * @return
	 */
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * get role mapping
	 * @return
	 */
	public Map<Long, Long> getExtRoleNewRoleMap() {
		return extRoleNewRoleMap;
	}
	public void setExtRoleNewRoleMap(Map<Long, Long> extRoleNewRoleMap) {
		this.extRoleNewRoleMap = extRoleNewRoleMap;
	}
	private ServiceContext serviceContext;
	
	private long extCompanyId;
	private long destinationGroupId;
	private Date startDate;
	private Date endDate;
	private Map<Long,Long> extRoleNewRoleMap;
}
