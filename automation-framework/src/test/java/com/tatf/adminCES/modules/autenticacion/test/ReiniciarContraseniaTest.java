package com.tatf.adminCES.modules.autenticacion.test;

import com.tatf.adminCES.modules.configuracion.BaseTest;
import com.tatf.adminCES.modules.gestionUsuarios.data.PerfilData;
import com.tatf.adminCES.modules.gestionUsuarios.task.PerfilTask;
import com.tatf.adminCES.modules.autenticacion.data.LoginData;
import com.tatf.adminCES.modules.autenticacion.data.ReiniciarContraseniaData;
import com.tatf.adminCES.modules.autenticacion.task.PaginaAccesoTask;
import com.tatf.adminCES.modules.autenticacion.task.LoginTask;
import com.tatf.adminCES.modules.autenticacion.task.ReiniciarContraseniaTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ReiniciarContraseniaTest extends BaseTest {
    private PaginaAccesoTask acceso;
    private ReiniciarContraseniaTask reinicioContrasenia;
    private LoginTask inicioSesion;
    private PerfilTask perfil;

    @BeforeEach
    public void configurar() {
        this.acceso = new PaginaAccesoTask(browser);
        this.reinicioContrasenia = new ReiniciarContraseniaTask(browser);
        this.inicioSesion = new LoginTask(browser);
        this.perfil = new PerfilTask(browser);
    }

    @Test
    @DisplayName("Reinicia la contraseña de un administrador y valida iniciando sesión con la nueva")
    public void reiniciarContraseniaTest() {
        this.acceso.ingresarAlSistema(url, hash);
        this.acceso.verificarUrl(url);
        this.reinicioContrasenia.reiniciarContrasenia(LoginData.EmailAdmin1, ReiniciarContraseniaData.ContraseniaNueva,
                ReiniciarContraseniaData.RepetirContraseniaNueva);
        this.reinicioContrasenia.verificarMensajeReinicio();
        this.inicioSesion.iniciarSesionYVerificar(LoginData.EmailAdmin1, ReiniciarContraseniaData.ContraseniaNueva);
        this.perfil.abrirPerfil(LoginData.NombreAdmin1 + " " + LoginData.ApellidoAdmin1);
        this.perfil.verificarDatosPerfil(LoginData.NombreAdmin1, LoginData.ApellidoAdmin1, LoginData.EmailAdmin1,
                LoginData.PaisAdmin1, PerfilData.PerfilAdministrador);
    }
}