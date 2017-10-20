package com.liferay.suez.synch.users;

import java.util.Dictionary;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.messaging.Destination;
import com.liferay.portal.kernel.messaging.DestinationConfiguration;
import com.liferay.portal.kernel.messaging.DestinationFactory;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.suez.synch.users.util.SynchSuezUsersKeys;

/**
 * 
 * This component is used to configure a destination
 * @author guy
 *
 */
@Component(immediate = true, 
	service = SynchSuezUsersConfigurator.class
)
public class SynchSuezUsersConfigurator {

	@Activate
	protected void activate(BundleContext bundleContext)  {
		
		DestinationConfiguration destinationConfiguration = new DestinationConfiguration(
				DestinationConfiguration.DESTINATION_TYPE_PARALLEL, 
				SynchSuezUsersKeys.DESTINATION_NAME); 
		destinationConfiguration.setMaximumQueueSize(50);
		destination = destinationFactory.createDestination(destinationConfiguration);
		Dictionary<String, Object> properties = new HashMapDictionary<>();
		properties.put("destination.name", destination.getName());
		ServiceRegistration<Destination> serviceRegistration = bundleContext.registerService
				(Destination.class, destination, properties);
		servicRegistrations.put(destination.getName(), serviceRegistration);
	}
	
	@Deactivate
	protected void deactivate() {
		ServiceRegistration<Destination> serviceRegistration =
				servicRegistrations.remove(destination.getName());

			serviceRegistration.unregister();
	}
	
	@Reference
	protected DestinationFactory destinationFactory;
	
	private final Map<String, ServiceRegistration<Destination>>
	 	servicRegistrations = new ConcurrentHashMap<>();
	
	private Destination destination;
}
