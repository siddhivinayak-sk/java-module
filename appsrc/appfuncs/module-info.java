module appfuncs {
	requires transitive appcommons; //Adds required module in transitive mode, means it automatically adds 'appcommons' requires
	exports appfuncs.simplefuncs to appstart; //Exports package to specific modules (seperated by comma)
}