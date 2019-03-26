package example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Rule;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.junit.Before;
import org.junit.After;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import org.apache.sling.testing.mock.osgi.MockOsgi;
import org.mockito.internal.util.reflection.Whitebox;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ActivatorTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    // private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    // private final PrintStream originalErr = System.err;

    Activator activator;
    BundleContext bundleContext = MockOsgi.newBundleContext();

    @Before
    public void setup() throws Exception {
        System.setOut(new PrintStream(outContent));
        // System.setErr(new PrintStream(errContent));
        activator = new Activator();
        Whitebox.setInternalState(activator, "bundleContext", bundleContext);
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