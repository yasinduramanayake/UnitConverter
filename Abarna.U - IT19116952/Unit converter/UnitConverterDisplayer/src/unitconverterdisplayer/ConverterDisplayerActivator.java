package unitconverterdisplayer;

import energyconverter.EnergyService;


import lengthconverter.LengthService;
import massconverter.MassService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;

import storageconverter.StorageService;
import tempconverter.TempService;
<<<<<<< HEAD
import currencyconverter.CurencyService;
import speedconverter.SpeedService;
=======
import timeconverter.TimeService;
>>>>>>> pubudi

public class ConverterDisplayerActivator implements BundleActivator {

	public ServiceRegistration serviceRegistration;
<<<<<<< HEAD
	public static ServiceTracker tempTracker,energyTracker,lengthTracker,storageTracker, currencyTracker, speedTracker;
=======
	public static ServiceTracker tempTracker,energyTracker,lengthTracker,storageTracker,massTracker,timeTracker;
>>>>>>> pubudi
	public static TempService tempService;
	public static EnergyService energyService;
	public static LengthService lengthService;
	public static StorageService storageService;
<<<<<<< HEAD
	public static CurencyService curencyService;
	public static SpeedService speedService;
=======
	public static MassService massService;
	public static TimeService timeService;
>>>>>>> pubudi
	

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Unit Converter Displayer service is started");
		ConverterDisplayerService cds = new ConverterDisplayer();
		serviceRegistration = bundleContext.registerService(ConverterDisplayerService.class.getName(), cds, null);
		
		tempTracker = new ServiceTracker(bundleContext,TempService.class.getName(),null);
		energyTracker = new ServiceTracker(bundleContext,EnergyService.class.getName(),null);
		lengthTracker = new ServiceTracker(bundleContext, LengthService.class.getName(), null);
		storageTracker = new ServiceTracker(bundleContext, StorageService.class.getName(), null);
<<<<<<< HEAD
		currencyTracker = new ServiceTracker(bundleContext, CurencyService.class.getName(), null);
		speedTracker = new ServiceTracker(bundleContext, SpeedService.class.getName(), null);
		
=======
		massTracker = new ServiceTracker(bundleContext, MassService.class.getName(), null);
		timeTracker = new ServiceTracker(bundleContext,TimeService.class.getName(),null);
>>>>>>> pubudi
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
	
	public static boolean lengthChecker() {
		lengthTracker .open();
		lengthService = (LengthService) lengthTracker.getService();
		
		if (lengthService != null)
			return true;
		else
			return false;
	}
	public static boolean StorageChecker() {
		storageTracker .open();
		storageService = (StorageService) storageTracker.getService();
		
		if (storageService != null)
			return true;
		else
			return false;
	}
	
<<<<<<< HEAD
	
	public static boolean CurencyChecker() {
		currencyTracker .open();
		curencyService = (CurencyService) currencyTracker.getService();
		
		if (curencyService != null)
=======
	public static boolean MassChecker() {
		massTracker .open();
		massService = (MassService) massTracker.getService();
		
		if (massService != null)
>>>>>>> pubudi
			return true;
		else
			return false;
	}
	
<<<<<<< HEAD
	public static boolean SpeedChecker() {
		speedTracker .open();
		speedService = (SpeedService) speedTracker.getService();
		
		if (speedService != null)
=======
	public static boolean timeChecker() {
		timeTracker.open();
		timeService = (TimeService) timeTracker.getService();
		
		if (timeService != null)
>>>>>>> pubudi
			return true;
		else
			return false;
	}
<<<<<<< HEAD
=======
	
>>>>>>> pubudi
}

