<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.model.Group"%>
<%@page import="com.liferay.suez.user.synch.model.ExtRole"%>
<%@page import="com.liferay.suez.user.synch.model.ExtCompany"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.model.Role"%>



<liferay-theme:defineObjects />

<portlet:defineObjects />