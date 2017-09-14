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
%>
<aui:row>
	<liferay-ui:error key="invalid-ext-company"   message="invalid-ext-company"  />
	<liferay-ui:error key="invalid-destination-site"   message="invalid-destination-site" />
	<liferay-ui:error key="invalid-start-date"    message="invalid-start-date" />
	<liferay-ui:error key="invalid-end-date"      message="invalid-end-date"/>
	<liferay-ui:error key="invalid-roles-mapping" message="invalid-roles-mapping" />

</aui:row>
<portlet:actionURL name="importUsers" var="importUsersURL" />
<aui:form method="post" name="fm" action="<%=importUsersURL.toString() %>">
	<p><liferay-ui:message key="import-message-description"/></p>
	<aui:fieldset>
		<aui:row>
			<aui:col width="50">
				<aui:select name="extCompanyId" label="ext-company">
					<aui:option label="select" value="" disabled=""></aui:option>
				</aui:select>
			</aui:col>
			<aui:col width="50">
				<aui:select name="destinationGroupId" label="dest-site">
					<aui:option label="select" value="" disabled=""></aui:option>
				</aui:select>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col width="50">
				<aui:select name="extRoleId_1" label="ext-role-1">
					<aui:option label="select" value="" disabled=""></aui:option>
				</aui:select>
			</aui:col>
			<aui:col width="50">
				<aui:select name="destRoleId_1" label="dest-role-1">
					<aui:option label="select" value="" disabled=""></aui:option>
				</aui:select>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col width="50">
				<aui:select name="extRoleId_2" label="ext-role-2">
					<aui:option label="select" value="" disabled=""></aui:option>
				</aui:select>
			</aui:col>
			<aui:col width="50">
				<aui:select name="destRoleId_2" label="dest-role-2">
					<aui:option label="select" value="" disabled=""></aui:option>
				</aui:select>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col width="50">
				<aui:select name="extRoleId_3" label="ext-role-3">
					<aui:option label="select" value="" disabled=""></aui:option>
				</aui:select>
			</aui:col>
			<aui:col width="50">
				<aui:select name="destRoleId_3" label="dest-role-3">
					<aui:option label="select" value="" disabled=""></aui:option>
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
