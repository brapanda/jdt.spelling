package jspell;

import jspell.messages.Messages;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * Represents the jspell plug-in.
 * 
 */
public class JSpellPlugin extends AbstractUIPlugin {

	private static final String PLUGIN_ID = "jspell";

	private static final int INTERNAL_ERROR = 0;

	private static JSpellPlugin jSpellPlugin;

	public static JSpellPlugin getDefault() {
		return jSpellPlugin;
	}

	public static IWorkspace getWorkspace() {
		return ResourcesPlugin.getWorkspace();
	}

	public static IWorkbenchPage getActivePage() {
		return getDefault().internalGetActivePage();
	}

	public static IWorkbenchWindow getActiveWorkbenchWindow() {
		return getDefault().getWorkbench().getActiveWorkbenchWindow();
	}

	public static Shell getActiveWorkbenchShell() {
		IWorkbenchWindow window = getActiveWorkbenchWindow();
		if (window != null) {
			return window.getShell();
		}
		return null;
	}

	public static String getPluginId() {
		return PLUGIN_ID;
	}

	public static void log(IStatus status) {
		getDefault().getLog().log(status);
	}

	public static void logErrorMessage(String message) {
		log(new Status(IStatus.ERROR, getPluginId(), INTERNAL_ERROR, message, null));
	}

	public static void logErrorStatus(String message, IStatus status) {
		if (status == null) {
			logErrorMessage(message);
			return;
		}
		MultiStatus multi = new MultiStatus(getPluginId(), INTERNAL_ERROR, message, null);
		multi.add(status);
		log(multi);
	}

	public static void log(Throwable e) {
		log(new Status(IStatus.ERROR, getPluginId(), INTERNAL_ERROR, Messages.JSpellPlugin_internal_error, e));
	}

	public static boolean isDebug() {
		return getDefault().isDebugging();
	}

	public JSpellPlugin() {
		super();
		jSpellPlugin = this;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		try {

			// dispose resources

		} finally {
			super.stop(context);
		}
	}

	private IWorkbenchPage internalGetActivePage() {
		IWorkbenchWindow window = getWorkbench().getActiveWorkbenchWindow();
		if (window == null) {
			return null;
		}
		return window.getActivePage();
	}

	public static ImageDescriptor imageDescriptorFromPlugin(String name) {
		return imageDescriptorFromPlugin(PLUGIN_ID, "icons/" + name);
	}

}
