package snn.apds.ui.internal;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

public class ApdsUiExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return ApdsUiActivator.getInstance().getBundle();
	}

	@Override
	protected Injector getInjector() {
		return ApdsUiActivator.getInstance().getInjector();
	}

}
