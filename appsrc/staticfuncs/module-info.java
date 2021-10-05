module staticfuncs {
	exports staticfuncs.myfunctions; //Exports package
	opens staticfuncs.myfunctions2; //Opens package to all other modules at runtime via Reflection
	requires static appfuncs; //the keyword 'static' mark this requires mandatory for compilation but optional for runtime
}