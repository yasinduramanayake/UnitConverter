package unitconverterdisplayer;

import energyconverter.EnergyService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import tempconverter.TempService;

public class ConverterDisplayerActivator implements BundleActivator {

	public ServiceRegistration serviceRegistration;
	public static ServiceTracker tempTracker,energyTracker;
	public static TempService tempService;
	public static EnergyService energyService;
	

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Unit Converter Displayer service is started");
		ConverterDisplayerService cds = new ConverterDisplayer();
		serviceRegistration = bundleContext.registerService(ConverterDisplayerService.class.getName(), cds, null);
		
		tempTracker = new ServiceTracker(bundleContext,TempService.class.getName(),null);
		energyTracker = new ServiceTracker(bundleContext,EnergyService.class.getName(),null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Unit Converter Displayer service is stopped");
		serviceRegistration.unregister();
	}

	public static boolean tempChecker() {
		tempTracker.open();
		tempService = (TempService) tempTracker.getService();
		
		if (tempService != null)
			return true;
		else
			return false;
	}
	
	public static boolean energyChecker() {
		energyTracker.open();
		energyService = (EnergyService) energyTracker.getService();
		
		if (energyService != null)
			return true;
		else
			return false;
	}
	
}