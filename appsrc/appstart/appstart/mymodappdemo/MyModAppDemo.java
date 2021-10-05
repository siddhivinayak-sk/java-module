package appstart.mymodappdemo;

import appfuncs.simplefuncs.SimpleMathFuncs;
import appcommons.commonfuncs.CommonFuncs;

import userfuncs.binaryfuncs.BinaryFunc;
import userfuncs.binaryfuncs.BinaryFuncProvider;

import java.util.ServiceLoader;

public class MyModAppDemo {
	
	public static void main(String...args) {
		System.out.println("2 is factor of 10: " + CommonFuncs.isFactor(2, 10));
		
		System.out.println("LCF of 80, 45: " + SimpleMathFuncs.lcf(80, 45));
		
		System.out.println("HCF of 80, 45: " + SimpleMathFuncs.hcf(80, 40));
		
		
		//Use of service
		ServiceLoader<BinaryFuncProvider> serviceLoader = ServiceLoader.load(BinaryFuncProvider.class);
		BinaryFunc plusFunc = null;
		BinaryFunc minusFunc = null;
		for(BinaryFuncProvider tmpProvider:serviceLoader) {
			if(tmpProvider.get().getName().equalsIgnoreCase("AbsPlus")) {
				plusFunc = tmpProvider.get();
			}
			else if(tmpProvider.get().getName().equalsIgnoreCase("AbsMinus")) {
				minusFunc = tmpProvider.get();
			}
		}
		
		if(null != plusFunc) {
			System.out.println("BinaryFunc Service (5, 4) - " + plusFunc.getName() + " : " + plusFunc.func(5, 4));
		}
		else {
			System.out.println("PlusFunction Not Available");
		}
		
		if(null != minusFunc) {
			System.out.println("BinaryFunc Service (5, 4) - " + minusFunc.getName() + " : " + minusFunc.func(5, 4));
		}
		else {
			System.out.println("MinusFunction Not Available");
		}
	}
	
}