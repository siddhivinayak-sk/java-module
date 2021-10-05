package userfuncsimpl.binaryfuncsimpl;

import userfuncs.binaryfuncs.BinaryFunc;
import userfuncs.binaryfuncs.BinaryFuncProvider;

public class AbsPlusProvider implements BinaryFuncProvider {

	public BinaryFunc get() {
		return new AbsPlus();
	}

}