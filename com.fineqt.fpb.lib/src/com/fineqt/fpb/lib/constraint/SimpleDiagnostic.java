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
package com.fineqt.fpb.lib.constraint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fineqt.fpb.lib.value.PValue;

public class SimpleDiagnostic implements Diagnostic, DiagnosticChain {
	private List<Diagnostic> children;
	private Throwable exception;
	private String message;
	private int severity = PASS;
	private PValue source;
	private boolean shouldCollectAllError = false;
	
	public SimpleDiagnostic() {
		
	}
	
	public SimpleDiagnostic(int severity, String message, PValue source, 
			Throwable exception) {
		this.exception = exception;
		this.message = message;
		this.severity = severity;
		this.source = source;
	}

	public SimpleDiagnostic(int severity, String message, PValue source) {
		this(severity, message, source, null);
	}
	
	public SimpleDiagnostic(int severity, String message) {
		this(severity, message, null, null);
	}
	
	@Override
	public void add(Diagnostic diagnostic) {
	    if (children == null){
	      children = new ArrayList<Diagnostic>();
	    }
	    children.add(diagnostic);
	    int childSeverity = diagnostic.getSeverity();
	    if (childSeverity > getSeverity())
	    {
	      severity = childSeverity;
	    }
	}

	@Override
	public void addAll(Diagnostic diagnostic) {
	    for (Diagnostic child : diagnostic.getChildren()) {
	      add(child);
	    }
	}

	@Override
	public void merge(Diagnostic diagnostic) {
	    if (diagnostic.getChildren().isEmpty()) {
	      add(diagnostic);
	    } else {
	      addAll(diagnostic);
	    }
	}

	@Override
	public List<Diagnostic> getChildren() {
	    if (children == null) {
	      return Collections.emptyList();
	    } else {
	      return Collections.unmodifiableList(children);
	    }
	}

	@Override
	public Throwable getException() {
		return exception;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public int getSeverity() {
		return severity;
	}

	@Override
	public PValue getSource() {
		return source;
	}

	public void setException(Throwable exception) {
		this.exception = exception;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setSeverity(int severity) {
		this.severity = severity;
	}

	public void setSource(PValue source) {
		this.source = source;
	}

	@Override
	public void setShouldCollectAllError(boolean should) {
		shouldCollectAllError = should;
	}

	@Override
	public boolean shouldCollectAllError() {
		return shouldCollectAllError;
	}

	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		builder.append("severity", severity)
			.append("message", message)
			.append("exception", exception)
			.append("source", source)
			.append("shouldCollectAllError", shouldCollectAllError);
		if (children != null) {
			for (int i = 0; i < children.size(); i++) {
				builder.append("\n  ");
				builder.append("child["+i+"]"+children.get(i));
			}
		}
		return builder.toString();
	}
}
