package userfuncsimpl.binaryfuncsimpl;

import userfuncs.binaryfuncs.BinaryFunc;

public class AbsMinus implements BinaryFunc {

	public String getName() {
		return "AbsMinus";
	}
	
	public int func(int a, int b) {
		return Math.abs(a) - Math.abs(b);
	}

}