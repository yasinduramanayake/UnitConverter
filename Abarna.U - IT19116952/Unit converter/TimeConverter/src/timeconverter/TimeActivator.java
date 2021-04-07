package timeconverter;

import org.osgi.framework.BundleActivator;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import timeconverter.TimeCalculate;
import timeconverter.TimeService;

public class TimeActivator implements BundleActivator {

	ServiceRegistration serviceRegistration;


	@Override
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Time service is started");
		TimeService timeService = new TimeCalculate();
		serviceRegistration = bundleContext.registerService(TimeService.class.getName(), timeService, null);
	}
	
	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Time service is stopped");
		serviceRegistration.unregister();
	}

}
