package storageconverter;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;



public class StorageActivator implements BundleActivator {

	ServiceRegistration serviceRegistration;


	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Storage service is started");
		StorageService StorageService = new StorageCalculater();
		serviceRegistration = bundleContext.registerService(StorageService.class.getName(), StorageService, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Storage service is stopped");
		serviceRegistration.unregister();
	}

}
