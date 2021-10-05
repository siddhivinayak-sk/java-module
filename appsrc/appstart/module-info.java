module appstart {
	//List of required module
	requires appfuncs;
	requires userfuncs;
	requires userfuncsimpl;

	//Added required service to be used in this module from other module
	uses userfuncs.binaryfuncs.BinaryFuncProvider;
}