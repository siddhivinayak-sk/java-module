package userfuncsimpl.binaryfuncsimpl;

import userfuncs.binaryfuncs.BinaryFunc;
import userfuncs.binaryfuncs.BinaryFuncProvider;

public class AbsMinusProvider implements BinaryFuncProvider {

	public BinaryFunc get() {
		return new AbsMinus();
	}

}