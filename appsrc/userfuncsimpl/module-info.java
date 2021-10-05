module userfuncsimpl {
	requires userfuncs; //This module requires specified module
	//Defines service interface and its provider implementation classes. This module needs define 'uses' where it has to use
	provides userfuncs.binaryfuncs.BinaryFuncProvider with userfuncsimpl.binaryfuncsimpl.AbsPlusProvider, userfuncsimpl.binaryfuncsimpl.AbsMinusProvider; 
}