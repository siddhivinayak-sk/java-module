package appcommons.commonfuncs;

public class CommonFuncs {

	//determine a is factor of b
	public static boolean isFactor(int a, int b) {
		return (b % a) == 0;
	}
	
	//return min between a and b
	public static int min(int a, int b) {
		return a < b ? a : b;
	}

	//return max between a and b
	public static int max(int a, int b) {
		return a > b ? a : b;
	}
	
}