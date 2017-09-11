<%@ include file="init.jsp" %>

<portlet:actionURL name="importUsers" var="importUsersURL" />
<aui:form method="post" name="fm" action="<%=importUsersURL.toString() %>">
	<p><liferay-ui:message key="import-message-description"/></p>
	<aui:button
			    cssClass="btn-lg"
			    label="search"
			    name="search"
			    primary="<%= true %>"
			    type="submit"
			/>
</aui:form>
