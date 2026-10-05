package com.tatf.adminCES.modules.tests;

import com.tatf.adminCES.modules.autenticacion.task.LoginTask;
import com.tatf.adminCES.modules.autenticacion.task.PaginaAccesoTask;
import com.tatf.adminCES.modules.autenticacion.task.RegistroTask;
import com.tatf.adminCES.modules.configuracion.BaseTest;
import com.tatf.adminCES.modules.gestionUsuarios.data.PerfilData;
import com.tatf.adminCES.modules.gestionUsuarios.task.PerfilTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class CrearCuentaAdminTest extends BaseTest {
    private PaginaAccesoTask acceso;
    private RegistroTask registro;
    private LoginTask inicioSesion;
    private PerfilTask perfil;

    @BeforeEach
    public void configurar() {
        this.acceso = new PaginaAccesoTask(browser);
        this.registro = new RegistroTask(browser);
        this.inicioSesion = new LoginTask(browser);
        this.perfil = new PerfilTask(browser);
    }

    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(
            resources = "/datos_UsuariosAdmin.csv",
            useHeadersInDisplayName = true
    )
    @DisplayName("Crea una cuenta de administrador y valida sus datos de perfil")
    public void crearCuentaAdminTest(String nombre, String apellido, String email, String contrasenia, String repetirContrasenia, String pais) {
        this.acceso.ingresarAlSistema(url, hash);
        this.acceso.verificarUrl(url);

        this.registro.registrarAdministrador(nombre, apellido, email, contrasenia, repetirContrasenia, pais);
        this.registro.verificarMensajeRegistro();

        this.inicioSesion.iniciarSesionYVerificar(email, contrasenia);

        this.perfil.abrirPerfil(nombre + " " + apellido);
        this.perfil.verificarDatosPerfil(nombre, apellido, email, pais, PerfilData.PerfilAdministrador);
    }
}