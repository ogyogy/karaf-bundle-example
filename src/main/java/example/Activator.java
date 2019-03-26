package example;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleReference;
import org.osgi.framework.FrameworkUtil;

public class Activator implements BundleActivator {
    private BundleContext bundleContext;

    public void init() {
        bundleContext = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
    }

    public void start(BundleContext context) {
        System.out.println("Starting the bundle");
    }

    public void stop(BundleContext context) {
        System.out.println("Stopping the bundle");
    }

}