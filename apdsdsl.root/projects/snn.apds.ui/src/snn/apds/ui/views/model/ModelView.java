package snn.apds.ui.views.model;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;

import com.google.inject.Inject;

import snn.apds.ui.internal.ApdsUiActivator;

public class ModelView extends ViewPart {

	public static final String ID = "snn.apds.ui.views.model.ModelView"; //$NON-NLS-1$

	protected ResourceDescriptionsProvider resourceDescProvider;

	@Inject
	ResourceDescriptionsProvider rdp;

	public ModelView() {
		// resourceDescProvider = PluginActivator.getInstance().getRdp();

		IResourceServiceProvider.Registry resourceServiceProviderRegistry = IResourceServiceProvider.Registry.INSTANCE;
		//-example-	resourceServiceProviderRegistry.getResourceServiceProvider( uri );
		// IResourceDescription.Manager manager = resourceServiceProvider.getResourceDescriptionManager();
	}

	/**
	 * Create contents of the view part.
	 * 
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));

		TreeViewer treeViewer = new TreeViewer(composite, SWT.BORDER);
		Tree tree = treeViewer.getTree();
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		TreeViewerColumn treeViewerColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
		TreeColumn trclmnModelItem = treeViewerColumn.getColumn();
		trclmnModelItem.setWidth(100);
		trclmnModelItem.setText("model item");

		//Composite container = new Composite(parent, SWT.NONE);

		test01();

		initializeMenu();
	}

	private void test01() {
		final String qualifiedNameStr = "";
		final QualifiedName qualifiedName = QualifiedName.create(qualifiedNameStr.split("::"));

		final IProject project = null;
		final IPath projectPath = project == null ? null : project.getFullPath();
		final IResourceDescriptions resDescriptions = rdp
				.getResourceDescriptions(new XtextResourceSet());

		for (final IResourceDescription resDesc : resDescriptions.getAllResourceDescriptions()) {
			final IPath resPath = new Path(resDesc.getURI().toPlatformString(true));
			/*if (project == null || projectPath.isPrefixOf(resPath)) {
				for(IEObjectDescription eod : resDesc.getExportedObjects(componentImplementationEClass, qualifiedName, true)) {
					ComponentImplementation result = (ComponentImplementation)eod.getEObjectOrProxy();
				    //return (ComponentImplementation)eod.getEObjectOrProxy();
				}
			}*/
			System.out.println(resPath.toOSString());
		}
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		// IMenuManager menuManager = getViewSite().getActionBars().getMenuManager();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}
}
