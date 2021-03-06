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
package org.jboss.reddeer.eclipse.core.resources;

/**
 * API for Project Item manipulation.
 * 
 * @author mlabuda@redhat.com
 * @since 2.0
 */
public interface ProjectItem extends Resource {

	/**
	 * Gets project item specified by path from current project item. Method go
	 * through whole hierarchy and on each layer at first try to find resource
	 * specified by part of the path as it is (whole text). If there is no such
	 * resource, then resource is looked up by non-decorated text representing
	 * this project item. If there is more than one project item in this step
	 * containing same non-styled text, then EclipseLayerException is thrown.
	 *
	 * @param path
	 *            path to the specific project item
	 * @return project item found on the specified path
	 */
	ProjectItem getProjectItem(String... path);

	/**
	 * Gets project of the project item where this item belongs to.
	 * 
	 * @return project of the project item
	 */
	Project getProject();

	/**
	 * Opens the project item with the specified editor.
	 *
	 * @param editor
	 *            editor to open project item
	 */
	void openWith(String editor);
}
