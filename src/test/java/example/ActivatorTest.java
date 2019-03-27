package example;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.osgi.framework.BundleContext;
import org.apache.sling.testing.mock.osgi.MockOsgi;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ActivatorTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    // private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    // private final PrintStream originalErr = System.err;
    Activator activator;
    BundleContext bundleContext = MockOsgi.newBundleContext();

    @Before
    public void setup() throws Exception {
        System.setOut(new PrintStream(outContent));
        // System.setErr(new PrintStream(errContent));
        activator = new Activator(bundleContext);
        // Whitebox.setInternalState(activator, "bundleContext", bundleContext);
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        // System.setErr(originalErr);
    }

    @Test
    public void test() {
        activator.start(bundleContext);
        assertEquals("Starting the bundle" + System.lineSeparator(), outContent.toString());
    }
}