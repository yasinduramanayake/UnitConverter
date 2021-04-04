package lengthconverter;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class LengthActivator implements BundleActivator {

	ServiceRegistration serviceRegistration;


	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Length service is started");
		LengthService LengthService = new LengthCalculater();
		serviceRegistration = bundleContext.registerService(LengthService.class.getName(), LengthService, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Length service is stopped");
		serviceRegistration.unregister();
	}

}
