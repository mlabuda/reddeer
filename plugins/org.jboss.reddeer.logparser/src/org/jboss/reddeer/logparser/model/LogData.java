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
package org.jboss.reddeer.logparser.model;

import java.util.List;

public class LogData {
	private String location = "";
	private List<ParseRule> parseRules;
		
	public LogData() {
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<ParseRule> getParseRules() {
		return parseRules;
	}

	public void setParseRules(List<ParseRule> parseRules) {
		this.parseRules = parseRules;
	}
	
	@Override
	public String toString() {
		return "LogData [location=" + location + ", parseRules.size=" 
			+ (parseRules != null ? parseRules.size() : 0) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogData other = (LogData) obj;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		return true;
	}
	public LogData clone () {
		LogData clone = new LogData();
		
		clone.location = this.location;
		clone.parseRules = this.parseRules;
		
		return clone;
	}
	
	public static void copyFields (LogData fromLogData, LogData toLogData){
		toLogData.setLocation(fromLogData.getLocation());
		toLogData.setParseRules(fromLogData.getParseRules());
	}
}
