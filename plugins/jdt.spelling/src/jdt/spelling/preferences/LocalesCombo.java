package jdt.spelling.preferences;

import java.util.List;
import java.util.Locale;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

public class LocalesCombo extends Composite {

	private final List<Locale> availableLocales;

	private final Combo combo;

	public LocalesCombo(Composite parent, int style, List<Locale> list) {
		super(parent, style);
		setLayout(new FillLayout());
		combo = new Combo(this, SWT.NONE);

		availableLocales = list;
		String[] localesDisplay = new String[availableLocales.size()];
		for (int i = 0; i < availableLocales.size(); i++) {
			localesDisplay[i] = availableLocales.get(i).getDisplayName();
		}
		combo.setItems(localesDisplay);
	}

	public void setSelectedLocale(Locale selected) {
		combo.select(availableLocales.indexOf(selected));
	}

	public Locale getSelectedLocale() {
		return availableLocales.get(combo.getSelectionIndex());
	}

}
