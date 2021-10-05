These keywords are restrictive keywords context based usage, it means they can be used for identifiers for other context.
The modules can be packaged as JAR as well as a new format added JMOD. 

JMOD is specical format which is used for customized JRE with Jlink tool (without Jlink there is no meaning of JMODs). The JMOD includes java classes alog with other types of file like jvm config, native binaries, native libs etc.

1. module - defines module
module <module name> {
}

2. exports - defines packages required to export into module
module <module name> {
	exports <package name>;
}

Export package to specific module
module <module name> {
	exports <package name> to <list of modules comma separated>;
}

3. requires - Define module name which are required in current module
module <module name> {
	requires <module name>;
}

In case transitive module depedency like A depends on B, B depends on C so naturally A depends on B and C. The B must add requires with transitive keyword so that when B is added in module A, it automatically adds C.
module <module name> {
	requires transitive <module name>;
}

In case, if module required only at compilation (at runtime it will be optional)
module <module name> {
	requires static <module name>;
}

4. open and opens - The both keywords used to make packages available to all other modules at runtime by Reflection

It opens module for other modules
open module <module name> {
}

It opens specific package of module for other modules
module <module name> {
	opens <package>;
}

5. Service (Pluggable API development with Interface and Implementation using java.util.ServiceLoader<T>.load(T.class))
A. First, need to create a module which defines API Interface
B. Need to create another module where interface implementation created and module definition contains 'provider'
module <module name> {
	provides <interface> with <list of implementation classes separated by comma>;
}
C. Where ever this API required need to define service uses
module <module name> {
	uses <interface>;
}

There are three ways to run modules
1. open modules (raw as in directories)
java --module-path <path of modules> -m <module_name>/<main_class_with_absolute_name>

2. Create custom JRE with list of modules created as your program and JRE modules

Jlink with open module (open directory not jar or jmod)
jlink --launcher MyModAppDemo=appstart/appstart.mymodappdemo.MyModAppDemo --module-path C:\sandeep\sandbox\java\java-11-openjdk-11.0.1.13\jmods;C:\sandeep\code\source\others\java-module\mymodapp\appsrc --add-modules appstart --output ..\jlinkoutput-1

Jlink with jmod files
jlink --launcher MyModAppDemo=appstart/appstart.mymodappdemo.MyModAppDemo --module-path C:\sandeep\sandbox\java\java-11-openjdk-11.0.1.13\jmods;C:\sandeep\code\source\others\java-module\mymodapp\jmods --add-modules appstart --output ..\jlinkoutput-2

3. Pack modules in Jar and use it as library or add Jar in module and use with custom JRE created with Jlink

Create modular jar
jar -cvf <jar file name> <directory which need to be added in jar>

jar -cvf userfuncsimpl.jar .

Note: The module jar can be created with module directory added in jar which contains module-info.class or without it where module-info.class directly contained in jar

To run modular jar:

java --module-path <directory where modules/jars contains>  -m <module_name>/<main_class_name>

java --module-path .  -m appstart/appstart.mymodappdemo.MyModAppDemo

The classpath switch can be added to define the non-modular jars.


New switches with Javac:
--module-path or -p <directory where module places>
--module-source-path <directory where module placed in open format to compile>

javac -d <target directory> --module-source-path <directory where modules placed> <list of classes to be compiled>

New switches with Java:
--module-path <directory where module places>
-m <module_name/class_name>

java --module-path <directory where list of module placed> -m <module_name>/<main_method_class>
java --module-path . -m appstart/appstart.mymodappdemo.MyModAppDemo

----------------New tools ----------------------
jmod - This tool is used to create jmod file. Below is basic command:

jmod create --class-path <directory which contains the classes>  --module-path <list of modules> --main-class <main class> --cmds <dir where native binaries (.exe) placed> <outputfile>.jmod
jmod create --class-path appstart --module-path jmods  --main-class appstart.mymodappdemo.MyModAppDemo appstart.jmod

jlink - It creates distributable output of the Java project along with JRE with required modules for the project based upon module dependency. It collects all modules and create a single image which can be executed on JVM, this image can be extracted using jimage tool.

jlink --launcher <name of executable in output>=<module>/<main class> --module-path <absolute path of JDK module directory>;<absolute path of modules to be added> --add-modules <list of modules to be added> --output <output directory>

jimage - It is tool introduced with jlink. The jlink will collect all modules and create a single image file which runs over the JVM. If it is required to check info, extract, list and verify the image, this jimage tool is used.

Go into lib directory in distributable created by jlink tool. There must a file named modules.

jimage <extract, list, verify, info> module_file

jimage info modules

