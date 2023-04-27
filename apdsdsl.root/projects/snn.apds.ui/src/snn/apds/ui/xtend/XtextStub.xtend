package snn.apds.ui.xtend

import com.google.inject.Inject
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider
import snn.apds.ui.internal.ApdsUiActivator

class XtextStub {

	// @Inject ResourceDescriptionsProvider rdp
	// @Inject IContainer.Manager cm

	@Inject
	def setRdp(ResourceDescriptionsProvider rdp1) {
		//ApdsUiActivator.getInstance.setRdp = rdp1;
	}

}
