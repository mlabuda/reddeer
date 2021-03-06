/******************************************************************************* 
 * Copyright (c) 2016 Red Hat, Inc. 
 * Distributed under license by Red Hat, Inc. All rights reserved. 
 * This program is made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 * Red Hat, Inc. - initial API and implementation 
 ******************************************************************************/ 
package org.jboss.reddeer.gef.api;

import java.util.List;

/**
 * API for palette manipulation
 * 
 * @author Andrej Podhradsky (andrej.podhradsky@gmail.com
 *
 */
public interface Palette {

	/**
	 * Activates tool with a given label.
	 *
	 * @param label            Tool label
	 */
	void activateTool(String label);

	/**
	 * Activates tool with a given label in a given group.
	 *
	 * @param label            Tool label
	 * @param group            Group label
	 */
	void activateTool(String label, String group);

	/**
	 * Returns active tool.
	 *
	 * @return active tool
	 */
	String getActiveTool();

	/**
	 * Returns all available tools.
	 *
	 * @return all available tools
	 */
	List<String> getTools();
}
