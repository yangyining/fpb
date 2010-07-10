/****************************************************************
Fine Packet Builder, copyright (C) 2007-2009 fineqt.com

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful, 
but WITHOUT ANY WARRANTY; without even the implied warranty of 
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the 
GNU General Public License for more details at gnu.org.
******************************************************************/
package com.fineqt.fpb.lib.meta.context;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.fineqt.fpb.lib.dump.DumpLine;
import com.fineqt.fpb.lib.dump.TopTypeDumpLine;

public class DumpContextImpl extends AbstractCommonContext implements DumpContext {
	private List<DumpLine> allDumpLines = new ArrayList<DumpLine>();
	private List<DumpLine> allTopTypeLines = new ArrayList<DumpLine>();
	private DumpLine currentProtocol;
	private int offset;
	
	@Override
	public void addDumpLine(DumpLine line) {
		switch(line.getType()) {
		case TOP_TYPE:
			TopTypeDumpLine typeLine = (TopTypeDumpLine)line;
			if (typeLine.isProtocol()) {
				allTopTypeLines.add(typeLine);
			}
			break;
		}
		allDumpLines.add(line);
	}

	@Override
	public List<DumpLine> getAllDumpLines() {
		return allDumpLines;
	}

	@Override
	public List<DumpLine> getAllTopTypeLines() {
		return allTopTypeLines;
	}

	@Override
	public DumpLine getCurrentTopType() {
		return currentProtocol;
	}

	@Override
	public int getOffset() {
		return offset;
	}

	@Override
	public int incOffset(int increment) {
		return offset += increment;
	}

	@Override
	public void setCurrentTopType(DumpLine line) {
		currentProtocol = line;
	}

	@Override
	public void passivate() {
		allDumpLines.clear();
		allTopTypeLines.clear();
		offset = 0;
		currentProtocol = null;
		super.passivate();
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
		.appendSuper(super.toString());
		for (int i = 0; i < allDumpLines.size(); i++) {
			builder.append("allDumpLines["+i+"]", allDumpLines.get(i));
		}
		for (int i = 0; i < allTopTypeLines.size(); i++) {
			builder.append("allTopTypeLines["+i+"]", allTopTypeLines.get(i));
		}

		builder
			.append("offset", offset)
			.append("currentProtocol", currentProtocol==null?null:currentProtocol.getName());
		return builder.toString();
	}
	
}
