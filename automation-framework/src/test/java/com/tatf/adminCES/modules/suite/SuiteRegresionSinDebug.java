package com.tatf.adminCES.modules.suite;

import org.junit.platform.suite.api.*;

@Suite
@SuiteDisplayName("Suite combinada: regresión sin debug")
@SelectPackages("com.tatf.adminCES.modules.pruebas")
@IncludeTags("regresion")
@ExcludeTags("debug")
@IncludeClassNamePatterns(".*Test")
public class SuiteRegresionSinDebug {
}