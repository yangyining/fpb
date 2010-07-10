package com.fineqt.fpb.lib.template.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;

import com.fineqt.fpb.lib.codec.builtin.PCharstringValue;
import com.fineqt.fpb.lib.model.fpbmodule.TypeClass;
import com.fineqt.fpb.lib.model.fpbtemplate.PMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PPrimitiveValueMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PRangeMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PValueListMatcher;
import com.fineqt.fpb.lib.template.NotSingleValueException;
import com.fineqt.fpb.lib.template.PTemplateParIns;
import com.fineqt.fpb.lib.template.ElementExtCreatingException;
import com.fineqt.fpb.lib.template.TemplateMatchingExption;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PValueMeta;

public class PCharsetMatcherExt extends PSimpleMatcherExtBase {
	private List<CharRange> acceptRanges = new ArrayList<CharRange>();
	
	public PCharsetMatcherExt(PValueListMatcher model, PValueMeta matcherMeta) 
	throws ElementExtCreatingException {
		super(model, matcherMeta);
		if (matcherMeta.getTypeMeta().getTypeClass() != TypeClass.CHARSTRING) {
			throw new IllegalArgumentException();
		}
		EList<PMatcher> modelItems = model.getItems();
		for (PMatcher modelItem : modelItems) {
			CharRange range;
			if (modelItem instanceof PPrimitiveValueMatcher) {
				PPrimitiveValueMatcher pItem = (PPrimitiveValueMatcher)modelItem;
				assert pItem.getValueDesc().length() == 1;
				range = new SingleCharRange(pItem.getValueDesc().charAt(0));
			} else {
				PRangeMatcher rItem = (PRangeMatcher)modelItem;
				assert rItem.getLowerBound().length() == 1;
				assert rItem.getUpperBound().length() == 1;
				range = new BoundCharRange(
						rItem.getLowerBound().charAt(0), 
						rItem.getUpperBound().charAt(0));
			}
			getAcceptRanges().add(range);
		}
	}

	public List<CharRange> getAcceptRanges() {
		return acceptRanges;
	}
	
	@Override
	protected boolean doMatch(PValue value, Map<String, PTemplateParIns> paras)
			throws TemplateMatchingExption {
		if (value.pTypeMeta().getTypeClass() != TypeClass.CHARSTRING) {
			throw new IllegalArgumentException();
		}
		PCharstringValue charValue = (PCharstringValue)value;
		for (int i = 0; i < charValue.getLength(); i++) {
			char ch = charValue.getChar(i);
			if (!accept(ch)) {
				return false;
			}
		}
		return true;
	}
	
	private boolean accept(char ch) {
		for (int i = 0; i < acceptRanges.size(); i++) {
			if (acceptRanges.get(i).accept(ch)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public PValue valueOf(Map<String, PTemplateParIns> paras)
			throws TemplateMatchingExption {
		throw new NotSingleValueException();
	}


	public static interface CharRange {
		boolean accept(char ch);
	}
	
	public static class SingleCharRange implements CharRange {
		private char targetChar;
		public SingleCharRange(char targetChar) {
			this.targetChar = targetChar;
		}
		
		@Override
		public boolean accept(char ch) {
			return targetChar == ch;
		}
	}
	
	public static class BoundCharRange implements CharRange {
		private char lowerBound;
		private char upperBound;
		
		public BoundCharRange(char lowerBound, char upperBound) {
			this.lowerBound = lowerBound;
			this.upperBound = upperBound;
		}
		
		@Override
		public boolean accept(char ch) {
			return ch >= lowerBound && ch <= upperBound;
		}
	}

}
