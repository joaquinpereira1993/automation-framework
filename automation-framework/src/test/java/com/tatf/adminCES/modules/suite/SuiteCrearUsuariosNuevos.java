package com.tatf.adminCES.modules.suite;

import com.tatf.adminCES.modules.pruebas.CrearCuentaAdminTest;
import com.tatf.adminCES.modules.pruebas.CrearCuentaTesterTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Suite por clase: CrearCuentaAdminTest y CrearCuentaTesterTest")
@SelectClasses({CrearCuentaAdminTest.class, CrearCuentaTesterTest.class})
public class SuiteCrearUsuariosNuevos {
}