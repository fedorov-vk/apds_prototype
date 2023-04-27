package snn.apds.ui.internal;

import org.apache.log4j.Logger;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class ApdsUiActivator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "snn.apds.ui"; //$NON-NLS-1$

	private static final Logger logger = Logger.getLogger(ApdsUiActivator.class);

	private static ApdsUiActivator INSTANCE = null;

	private Injector injector;

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		INSTANCE = this;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		injector = null;
		INSTANCE = null;
		super.stop(context);
	}

	public static ApdsUiActivator getInstance() {
		return ApdsUiActivator.INSTANCE;
	}

	public Injector getInjector() {
		if (injector == null) {
			injector = createInjector();
		}
		return injector;
	}

	protected Injector createInjector() {
		try {
			return Guice.createInjector(new ApdsUiModule());
		} catch (Exception e) {
			logger.error("Failed to create injector");
			logger.error(e.getMessage(), e);
			throw new RuntimeException("Failed to create injector", e);
		}
	}

}
