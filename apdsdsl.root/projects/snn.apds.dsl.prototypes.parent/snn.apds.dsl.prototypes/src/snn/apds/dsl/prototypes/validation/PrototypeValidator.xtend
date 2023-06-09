/*
 * generated by Xtext 2.29.0
 */
package snn.apds.dsl.prototypes.validation

import com.google.inject.Inject
import org.eclipse.xtext.validation.Check
import snn.apds.core.xtend.ApdsDslIndex
import snn.apds.dsl.attributes.AttributesPackage
import snn.apds.dsl.attributes.Prototype

import static extension org.eclipse.xtext.EcoreUtil2.*

/**
 * This class contains custom validation rules. 
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class PrototypeValidator extends AbstractPrototypeValidator {

	protected static val ISSUE_CODE_PREFIX = "org.apds.dsl."
	protected static val MORE_CLASSES = ISSUE_CODE_PREFIX + "MoreClasses"

	// @Inject ApdsDslLib apdsDslLib
	@Inject ApdsDslIndex apdsDslIndex

	@Check
	def void checkClassPerFile(Prototype clazz) {
		val siblings = clazz.getSiblingsOfType(Prototype)
		if (siblings.length > 0) {
			val uriClass = clazz.normalizedURI
			val classes = apdsDslIndex.getVisiblePrototypesDescriptions(clazz)
			if (classes.get(0).EObjectURI == uriClass) {
				for (cl : siblings) {
					error(
						"The type " + cl.name + " should declared in another file",
						cl,
						AttributesPackage.Literals.PROTOTYPE__NAME,
						MORE_CLASSES
					)
				}
			}
		}
	}

}
