package energyconverter;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import energyconverter.EnergyCalculate;
import energyconverter.EnergyService;

public class EnergyActivator implements BundleActivator {

	ServiceRegistration serviceRegistration;
	
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Energy service is started");
		EnergyService tempService = new EnergyCalculate();
		serviceRegistration = bundleContext.registerService(EnergyService.class.getName(), tempService, null);
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Energy service is stopped");
		serviceRegistration.unregister();
	}
	
}
