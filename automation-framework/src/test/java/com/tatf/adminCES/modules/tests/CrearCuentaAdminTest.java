package com.tatf.adminCES.modules.tests;

import com.tatf.adminCES.modules.configuracion.BaseTest;
import com.tatf.adminCES.modules.gestionUsuarios.data.PerfilData;
import com.tatf.adminCES.modules.gestionUsuarios.task.PerfilTask;
import com.tatf.adminCES.modules.autenticacion.data.RegistroData;
import com.tatf.adminCES.modules.autenticacion.task.PaginaAccesoTask;
import com.tatf.adminCES.modules.autenticacion.task.LoginTask;
import com.tatf.adminCES.modules.autenticacion.task.RegistroTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CrearCuentaAdminTest extends BaseTest {
    private PaginaAccesoTask acceso;
    private RegistroTask registro;
    private LoginTask inicioSesion;
    private PerfilTask perfil;

    @BeforeEach
    public void configurarPrueba() {
        this.acceso = new PaginaAccesoTask(browser);
        this.registro = new RegistroTask(browser);
        this.inicioSesion = new LoginTask(browser);
        this.perfil = new PerfilTask(browser);
    }

    @Test
    @DisplayName("Crea una cuenta de administrador y valida sus datos de perfil")
    public void crearCuentaAdminTest() {
        this.acceso.ingresarAlSistema(url, hash);
        this.acceso.verificarUrl(url);

        this.registro.registrarAdministrador(RegistroData.Nombre, RegistroData.Apellido, RegistroData.Email,
                RegistroData.Contrasenia, RegistroData.RepetirContrasenia, RegistroData.Pais);
        this.registro.verificarMensajeRegistro();

        this.inicioSesion.iniciarSesionYVerificar(RegistroData.Email, RegistroData.Contrasenia);

        this.perfil.abrirPerfil(RegistroData.Nombre + " " + RegistroData.Apellido);
        this.perfil.verificarDatosPerfil(RegistroData.Nombre, RegistroData.Apellido, RegistroData.Email,
                RegistroData.Pais, PerfilData.PerfilAdministrador);
    }
}