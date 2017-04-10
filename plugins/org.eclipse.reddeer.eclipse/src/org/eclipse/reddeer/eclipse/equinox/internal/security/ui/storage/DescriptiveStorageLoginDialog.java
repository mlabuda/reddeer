/*******************************************************************************
 * Copyright (c) 2017 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.eclipse.reddeer.eclipse.equinox.internal.security.ui.storage;

import org.eclipse.reddeer.common.wait.WaitWhile;
import org.eclipse.reddeer.core.matcher.WithLabelMatcher;
import org.eclipse.reddeer.jface.window.AbstractWindow;
import org.eclipse.reddeer.swt.condition.ShellIsAvailable;
import org.eclipse.reddeer.swt.impl.button.CancelButton;
import org.eclipse.reddeer.swt.impl.button.OkButton;
import org.eclipse.reddeer.swt.impl.text.DefaultText;

/**
 * Secure storage login.
 *
 * @author jnovak@redhat.com
 */
public class DescriptiveStorageLoginDialog extends AbstractWindow {

	private static final String SHELL_TITLE = "Secure Storage Password";

	public DescriptiveStorageLoginDialog(){
		super(SHELL_TITLE);
	}

	public void setPassword(String password){
		new DefaultText(new WithLabelMatcher("Password:")).setText(password);
	}

	public void ok(){
		new OkButton().click();
		new WaitWhile(new ShellIsAvailable(SHELL_TITLE));
	}

	public void cancel(){
		new CancelButton().click();
		new WaitWhile(new ShellIsAvailable(SHELL_TITLE));
	}

}
