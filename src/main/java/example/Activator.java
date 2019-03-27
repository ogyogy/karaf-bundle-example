package example;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {
    private BundleContext bundleContext;

    public Activator(BundleContext ctx) {
        bundleContext = ctx;
    }

    public void start(BundleContext ctx) {
        System.out.println("Starting the bundle");
    }

    public void stop(BundleContext cxt) {
        System.out.println("Stopping the bundle");
    }

}