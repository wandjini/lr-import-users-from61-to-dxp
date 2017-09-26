<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="init.jsp" %>
<%
	Calendar from = CalendarFactoryUtil.getCalendar();
	Calendar to = CalendarFactoryUtil.getCalendar();

	from.set(Calendar.MONTH, Calendar.JANUARY);
	
	from.set(Calendar.DATE, 1);
	from.set(Calendar.YEAR, 2017);

	to.set(Calendar.MONTH, Calendar.DECEMBER);
	
	to.set(Calendar.DATE, 31);
	to.set(Calendar.YEAR, 2017);
	
	int fromDay = from.get(Calendar.DATE);
	int fromMonth = from.get(Calendar.MONTH);
	int fromYear = from.get(Calendar.YEAR);
	
	int toDay = to.get(Calendar.DATE);
	int toMonth = to.get(Calendar.MONTH);
	int toYear = to.get(Calendar.YEAR);
	
	List<ExtCompany> extCompanies = (List<ExtCompany>) renderRequest.getAttribute("ExtCompanies");
	List<ExtRole> extRoles = (List<ExtRole>) renderRequest.getAttribute("ExtRoles");
	List<Role> newRoles = (List<Role>) renderRequest.getAttribute("NewRoles");
	List<Group> sites = (List<Group>) renderRequest.getAttribute("Sites");
	long destinationGroupId = (long) renderRequest.getAttribute("destinationGroupId");
	long extCompanyId = (long) renderRequest.getAttribute("extCompanyId");
	int extRolesSize = extRoles != null ? extRoles.size():0;
	long extRoleId_1 = ParamUtil.getLong(renderRequest, "extRoleId_1");
	long extRoleId_2 = ParamUtil.getLong(renderRequest, "extRoleId_2");
	long extRoleId_3 = ParamUtil.getLong(renderRequest, "extRoleId_3");
	long extRoleId_4 = ParamUtil.getLong(renderRequest, "extRoleId_4");
	long destRoleId_1 = ParamUtil.getLong(renderRequest, "destRoleId_1");
	long destRoleId_2 = ParamUtil.getLong(renderRequest, "destRoleId_2");
	long destRoleId_3 = ParamUtil.getLong(renderRequest, "destRoleId_3");
	long destRoleId_4 = ParamUtil.getLong(renderRequest, "destRoleId_4");
	
%>
<portlet:renderURL var="importPortletUrl">
	<portlet:param name="jspPath" value="/view.jsp"/>
</portlet:renderURL>
<aui:row>
	<liferay-ui:error key="invalid-ext-company"   message="invalid-ext-company"  />
	<liferay-ui:error key="invalid-destination-site"   message="invalid-destination-site" />
	<liferay-ui:error key="invalid-start-date"    message="invalid-start-date" />
	<liferay-ui:error key="invalid-end-date"      message="invalid-end-date"/>
	<liferay-ui:error key="invalid-roles-mapping" message="invalid-roles-mapping" />

</aui:row>
<portlet:actionURL name="importUsers" var="importUsersURL" />
<aui:form method="post" name="fm" action="<%=importUsersURL.toString() %>">
	<aui:input type="hidden" value="<%=String.valueOf(extRolesSize) %>" name="extRolesSize"/>
	<p><liferay-ui:message key="import-message-description"/></p>
	<aui:fieldset>
		<aui:row>
			<aui:col width="50">
				<aui:select name="extCompanyId" label="ext-company">
					<option  value="0" selected disabled ><liferay-ui:message key="select"/></option>
					<%if(extCompanies != null && !extCompanies.isEmpty()) {%>
						<%for(ExtCompany extCompany:extCompanies){ %>
							<aui:option  value="<%= String.valueOf(extCompany.getCompanyId()) %>" selected = "<%= extCompanyId == extCompany.getCompanyId()%>"><%=extCompany.getWebId() %></aui:option>
						<%} %>
					<%}%>
				</aui:select>
			</aui:col>
			<aui:col width="50">
				<aui:select name="destinationGroupId" label="dest-site">
					<option  value="0"  disabled><liferay-ui:message key="select"/></option>
					<%if(sites != null && !sites.isEmpty()) {%>
						<%for(Group group:sites){ %>
							<aui:option  value="<%=String.valueOf(group.getGroupId()) %>" selected = "<%= destinationGroupId ==group.getGroupId()%>"><%=group.getName() %></aui:option>
						<%} %>
					<%}%>
				</aui:select>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col width="50">
				<aui:select name="extRoleId_1" label="ext-role-1">
					<option  value="" disabled selected ><liferay-ui:message key="select"/></option>
					<%if(extRoles != null && !extRoles.isEmpty()){ %>
						<%for(ExtRole extRole:extRoles){ %>
							<aui:option  value="<%=String.valueOf(extRole.getRoleId()) %>" selected ="<%=extRole.getRoleId() == extRoleId_1 %>"><%=extRole.getName() %></aui:option>
						<%} %>
					<%}%>
				</aui:select>
			</aui:col>
			<aui:col width="50">
				<aui:select name="destRoleId_1" label="dest-role-1">
					<option  value="" selected disabled><liferay-ui:message key="select"/></option>
					<%if(newRoles != null && !newRoles.isEmpty()) {%>
						<%for(Role newRole:newRoles){ %>
							<aui:option  value="<%=String.valueOf(newRole.getRoleId()) %>" selected ="<%=newRole.getRoleId() == destRoleId_1 %>"><%=newRole.getName() %></aui:option>
						<%} %>
					<%}%>
				</aui:select>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col width="50">
				<aui:select name="extRoleId_2" label="ext-role-2">
					<option  value="" selected disabled><liferay-ui:message key="select"/></option>
					<%if(extRolesSize > 1) {%>
						<%for(ExtRole extRole:extRoles){ %>
							<aui:option  value="<%=String.valueOf(extRole.getRoleId()) %>" selected ="<%=extRole.getRoleId() == extRoleId_2 %>"><%=extRole.getName() %></aui:option>
						<%} %>
					<%}%>				
				</aui:select>
			</aui:col>
			<aui:col width="50">
				<aui:select name="destRoleId_2" label="dest-role-2">
					<option  value="" selected disabled><liferay-ui:message key="select"/></option>
					<%if(extRolesSize > 1) {%>
						<%for(Role newRole:newRoles){ %>
							<aui:option  value="<%=String.valueOf(newRole.getRoleId()) %>" selected ="<%=newRole.getRoleId() == destRoleId_2 %>"><%=newRole.getName() %></aui:option>
						<%} %>
					<%}%>
				</aui:select>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col width="50">
				<aui:select name="extRoleId_3" label="ext-role-3">
					<option  value="" selected disabled><liferay-ui:message key="select"/></option>
					<%if(extRolesSize > 2) {%>
						<%for(ExtRole extRole:extRoles){ %>
							<aui:option  value="<%=String.valueOf(extRole.getRoleId()) %>" selected ="<%=extRole.getRoleId() == extRoleId_3 %>"><%=extRole.getName() %></aui:option>
						<%} %>
					<%}%>
				</aui:select>
			</aui:col>
			<aui:col width="50">
				<aui:select name="destRoleId_3" label="dest-role-3">
					<option  value="" selected disabled><liferay-ui:message key="select"/></option>
					<%if(extRolesSize > 2) {%>
						<%for(Role newRole:newRoles){ %>
							<aui:option  value="<%=String.valueOf(newRole.getRoleId()) %>" selected ="<%=newRole.getRoleId() == destRoleId_3 %>"><%=newRole.getName() %></aui:option>
						<%} %>
					<%}%>
				</aui:select>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col width="50">
				<aui:select name="extRoleId_4" label="ext-role-4">
					<option  value="" selected disabled><liferay-ui:message key="select"/></option>
					<%if(extRolesSize > 3) {%>
						<%for(ExtRole extRole:extRoles){ %>
							<aui:option  value="<%=String.valueOf(extRole.getRoleId()) %>" selected ="<%=extRole.getRoleId() == extRoleId_4 %>"><%=extRole.getName() %></aui:option>
						<%} %>
					<%}%>
				</aui:select>
			</aui:col>
			<aui:col width="50">
				<aui:select name="destRoleId_4" label="dest-role-4">
					<option  value="" selected disabled><liferay-ui:message key="select"/></option>
					<%if(extRolesSize > 3) {%>
						<%for(Role newRole:newRoles){ %>
							<aui:option  value="<%=String.valueOf(newRole.getRoleId()) %>" selected ="<%=newRole.getRoleId() == destRoleId_4 %>"><%=newRole.getName() %></aui:option>
						<%} %>
					<%}%>
				</aui:select>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col width="50">
				<div class="form-group input-text-wrapper">
					<label >
						<liferay-ui:message key="from" />
					</label>
					<liferay-ui:input-date
						dayParam='<%= "f_day" %>'
						dayValue="<%= fromDay %>"
						disabled="<%= false %>"
						firstDayOfWeek="<%= from.getFirstDayOfWeek() - 1 %>"
						monthParam='<%= "f_month" %>'
						monthValue="<%= fromMonth %>"
						name='<%= "startDate" %>'
						yearParam='<%= "f_year" %>'
						yearValue="<%= fromYear %>"
						formName='<%= "fm"%>'
					/>	
				</div>
			</aui:col>
			<aui:col width="50">
				<div class="form-group input-text-wrapper">
					<label >
						<liferay-ui:message key="to" />
					</label>
					<liferay-ui:input-date
						dayParam='<%= "t_day" %>'
						dayValue="<%= toDay %>"
						disabled="<%= false %>"
						firstDayOfWeek="<%= to.getFirstDayOfWeek() - 1 %>"
						monthParam='<%= "t_month" %>'
						monthValue="<%= toMonth %>"
						name='<%= "endDate" %>'
						yearParam='<%= "t_year" %>'
						yearValue="<%= toYear %>"
						formName='<%= "fm"%>'
					/>	
				</div>			
			</aui:col>
		</aui:row>
	</aui:fieldset>
	<aui:button
			    cssClass="btn-lg"
			    label="import"
			    name="import"
			    primary="<%= true %>"
			    type="submit"  value="import"/>
			
</aui:form>

<script type="text/javascript">

var <portlet:namespace/>reloadPage = function(isCompany){
	
	var url = Liferay.PortletURL.createURL('<%= importPortletUrl%>');
	var destinationGroupId = AUI().one('#<portlet:namespace/>destinationGroupId').val();
	var extCompanyId = AUI().one('#<portlet:namespace/>extCompanyId').val();
	url.setParameter('destinationGroupId', destinationGroupId);
	url.setParameter('extCompanyId', extCompanyId);
	window.location.href = url.toString();
	
	
};
AUI().ready(function(A){
	A.one('#<portlet:namespace/>destinationGroupId').on('change', function(){
		<portlet:namespace/>reloadPage(false);
	});
	
	A.one('#<portlet:namespace/>extCompanyId').on('change', function(){
		<portlet:namespace/>reloadPage(true);
	});
});
</script>