package com.liferay.suez.synch.portlet.test.integration;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.suez.synch.portlet.SuezUsersImportPortlet;
import com.liferay.suez.synch.users.util.SuezMigrationRequest;
import com.liferay.suez.synch.users.util.SynchSuezUsersKeys;
import com.liferay.suez.synch.validation.SuezMigrationsRequestValidator;
import com.liferay.suez.user.synch.service.ExtCompanyLocalService;
import com.liferay.suez.user.synch.service.ExtRoleLocalService;

@RunWith(PowerMockRunner.class)
@PrepareForTest({SuezUsersImportPortlet.class,SuezMigrationsRequestValidator.class, 
	ServiceContextFactory.class, ParamUtil.class, PortalUtil.class, SessionErrors.class})
public class SuezUsersImportPortletTest {
	
	@InjectMocks
	private SuezUsersImportPortlet suezUsersImportPortlet; 
	
	@Mock
	private GroupLocalService groupLocService;
	
	@Mock
	private RoleLocalService roleLocService;
	
	@Mock
	protected ExtCompanyLocalService extCompanyLocService;
	
	@Mock
	protected ExtRoleLocalService extRoleLocService;
	
	@Mock
	private ActionRequest actionRequest;
	
	
	@Mock
	private ActionResponse actionResponse;
	
	@Mock
	private String extRolesSizeString;
	@Mock
	private int extRolesSize = 10;
	
	@Mock
	private ThemeDisplay themeDisplay;
	
	@Mock
	private SuezMigrationRequest suezMigrationRequest;
	
	@Mock
	private ArrayList<String> errors;
	
	@Mock
	private ServiceContext serviceContext;
	
	@Mock
	private TimeZone timeZone = TimeZone.getDefault();
	
	@Mock
	private int fDay = 1;
	
	@Mock
	private int fMonth = 1;
	
	@Mock
	private int fYear = 1970;
	
	@Mock
	private int tDay = 1;
	
	@Mock
	private int tMonth = 1;
	
	@Mock
	private int tYear = 1970;
	
	
	
	@Test
	public void importUsersTest() throws Exception{
		
		
		PowerMockito.mockStatic(SuezMigrationsRequestValidator.class);
		PowerMockito.mockStatic(ServiceContextFactory.class);
		PowerMockito.mockStatic(ParamUtil.class);
		PowerMockito.mockStatic(PortalUtil.class);
		
		
		when(actionRequest.getAttribute(WebKeys.THEME_DISPLAY)).thenReturn(themeDisplay);
		when(ParamUtil.getInteger(actionRequest, "extRolesSize")).thenReturn(extRolesSize);
		when(ServiceContextFactory.getInstance(actionRequest)).thenReturn(serviceContext);
		when(themeDisplay.getTimeZone()).thenReturn(timeZone);
		when(ParamUtil.getInteger(actionRequest, "f_day", 1)).thenReturn(fDay);
		when(ParamUtil.getInteger(actionRequest, "f_month", 1)).thenReturn(fMonth);
		when(ParamUtil.getInteger(actionRequest, "f_year",1970)).thenReturn(fYear);
		
		when(ParamUtil.getInteger(actionRequest, "t_day")).thenReturn(tDay);
		when(ParamUtil.getInteger(actionRequest, "t_month")).thenReturn(tMonth);
		when(ParamUtil.getInteger(actionRequest, "t_year")).thenReturn(tYear);
		
		when(PortalUtil.getDate(
				fMonth, fDay, fYear, 0, 0,
				themeDisplay.getTimeZone(), PortalException.class)).thenReturn(new Date());
		
		
		//PowerMockito.whenNew(ArrayList.class).withNoArguments().thenReturn(errors);
	
		PowerMockito.when(SuezMigrationsRequestValidator.class,
				"isSuezMigrationRequestValid",suezMigrationRequest, 
				extRolesSize, errors)
				.thenReturn(true);
		
		
		suezUsersImportPortlet.importUsers(actionRequest, actionResponse);
		verify(actionResponse, times(1)).setRenderParameter("jspPath", "/view.jsp");
	}

	
	/*@Test
	public void importUsersWithErrorsTest() throws Exception{
		
		
		PowerMockito.mockStatic(SuezMigrationsRequestValidator.class);
		PowerMockito.mockStatic(ServiceContextFactory.class);
		PowerMockito.mockStatic(ParamUtil.class);
		PowerMockito.mockStatic(PortalUtil.class);
		PowerMockito.mockStatic(SessionErrors.class);
		
		
		when(actionRequest.getAttribute(WebKeys.THEME_DISPLAY)).thenReturn(themeDisplay);
		when(ParamUtil.getInteger(actionRequest, "extRolesSize")).thenReturn(extRolesSize);
		when(ServiceContextFactory.getInstance(actionRequest)).thenReturn(serviceContext);
		when(themeDisplay.getTimeZone()).thenReturn(timeZone);
		when(ParamUtil.getInteger(actionRequest, "f_day", 1)).thenReturn(fDay);
		when(ParamUtil.getInteger(actionRequest, "f_month", 1)).thenReturn(fMonth);
		when(ParamUtil.getInteger(actionRequest, "f_year",1970)).thenReturn(fYear);
		
		when(ParamUtil.getInteger(actionRequest, "t_day")).thenReturn(tDay);
		when(ParamUtil.getInteger(actionRequest, "t_month")).thenReturn(tMonth);
		when(ParamUtil.getInteger(actionRequest, "t_year")).thenReturn(tYear);
		
		when(PortalUtil.getDate(
				fMonth, fDay, fYear, 0, 0,
				themeDisplay.getTimeZone(), PortalException.class)).thenReturn(new Date());
		
		
		//PowerMockito.whenNew(ArrayList.class).withNoArguments().thenReturn(errors);
		errors.add("error");
		PowerMockito.when(SuezMigrationsRequestValidator.class,
				"isSuezMigrationRequestValid",suezMigrationRequest, 
				extRolesSize, errors)
				.thenReturn(true);
		
		when(SessionErrors.class, "add", actionRequest, Mockito.anyString()).thenReturn(new Answer<Void>(){

			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				return  null;
			}
			
		});
		suezUsersImportPortlet.importUsers(actionRequest, actionResponse);
		PowerMockito.verifyStatic(SessionErrors.class);
		verify(actionResponse, times(1)).setRenderParameter("jspPath", "/view.jsp");
	}*/

	
	
	

}
