/*
 * generated by Xtext 2.29.0
 */
package snn.apds.dsl.prototypes.ide

import com.google.inject.Guice
import org.eclipse.xtext.util.Modules2
import snn.apds.dsl.prototypes.PrototypeRuntimeModule
import snn.apds.dsl.prototypes.PrototypeStandaloneSetup

/**
 * Initialization support for running Xtext languages as language servers.
 */
class PrototypeIdeSetup extends PrototypeStandaloneSetup {

	override createInjector() {
		Guice.createInjector(Modules2.mixin(new PrototypeRuntimeModule, new PrototypeIdeModule))
	}
	
}
