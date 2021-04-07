package massconverter;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import massconverter.MassCalculate;
import massconverter.MassService;

public class MassActivator implements BundleActivator {
	
	ServiceRegistration serviceRegistration;


	@Override
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Mas service is started");
		MassService massService = new MassCalculate();
		serviceRegistration = bundleContext.registerService(MassService.class.getName(), massService, null);
	}
	
	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Mass service is stopped");
		serviceRegistration.unregister();
	}

}

