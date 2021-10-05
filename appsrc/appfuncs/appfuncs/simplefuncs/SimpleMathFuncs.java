package appfuncs.simplefuncs;

import appcommons.commonfuncs.CommonFuncs;

public class SimpleMathFuncs {

	
	//returns smallest common positive factor for a and b 
	public static int lcf(int a, int b) {
		a = Math.abs(a);
		b = Math.abs(b);
		int min = CommonFuncs.min(a, b);
		for(int i = 2; i <= min/2; i++) {
			if(CommonFuncs.isFactor(i, a) && CommonFuncs.isFactor(i, b)) {
				return i;
			}
		}
		return 1;
	}
	
	//returns largest common positive factor for a and b 
	public static int hcf(int a, int b) {
		a = Math.abs(a);
		b = Math.abs(b);
		int min = CommonFuncs.max(a, b);
		for(int i = min/2; i >= 2; i--) {
			if(CommonFuncs.isFactor(i, a) && CommonFuncs.isFactor(i, b)) {
				return i;
			}
		}
		return 1;
	}
}