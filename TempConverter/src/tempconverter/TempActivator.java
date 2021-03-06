package tempconverter;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;

public class TempActivator implements BundleActivator {

	ServiceRegistration serviceRegistration;
	
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Temperature service is started");
		TempService tempService = new TempCalculate();
		serviceRegistration = bundleContext.registerService(TempService.class.getName(), tempService, null);
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Temperature service is stopped");
		serviceRegistration.unregister();
	}

}
