package com.tatf.adminCES.modules.suite;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Suite por paquete: pruebas")
@SelectPackages("com.tatf.adminCES.modules.pruebas")
public class SuiteCompletaAdminCES {
}