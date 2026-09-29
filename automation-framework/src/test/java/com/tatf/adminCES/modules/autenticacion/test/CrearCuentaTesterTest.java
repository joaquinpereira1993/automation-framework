package com.tatf.adminCES.modules.autenticacion.test;

import com.tatf.adminCES.modules.configuracion.BaseTest;
import com.tatf.adminCES.modules.gestionUsuarios.data.AltaTesterData;
import com.tatf.adminCES.modules.gestionUsuarios.task.AltaTesterTask;
import com.tatf.adminCES.modules.gestionUsuarios.task.ListaUsuariosTask;
import com.tatf.adminCES.modules.autenticacion.data.LoginData;
import com.tatf.adminCES.modules.autenticacion.task.PaginaAccesoTask;
import com.tatf.adminCES.modules.autenticacion.task.LoginTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CrearCuentaTesterTest extends BaseTest {
    private PaginaAccesoTask acceso;
    private LoginTask inicioSesion;
    private AltaTesterTask altaTester;
    private ListaUsuariosTask usuarios;

    @BeforeEach
    public void configurar() {
        this.acceso = new PaginaAccesoTask(browser);
        this.inicioSesion = new LoginTask(browser);
        this.altaTester = new AltaTesterTask(browser);
        this.usuarios = new ListaUsuariosTask(browser);
    }

    @Test
    @DisplayName("Crea una cuenta con perfil tester y valida que exista en la lista de usuarios")
    public void crearCuentaTesterTest() {
        this.acceso.ingresarAlSistema(url, hash);
        this.acceso.verificarUrl(url);

        this.inicioSesion.iniciarSesionYVerificar(LoginData.EmailAdmin2, LoginData.ContraseniaAdmin2);
        this.altaTester.abrirFormularioCrearUsuario();
        this.altaTester.crearTester(AltaTesterData.Nombre, AltaTesterData.Apellido, AltaTesterData.Email,
                AltaTesterData.Pais, AltaTesterData.Contrasenia, AltaTesterData.Seniority);
        this.altaTester.verificarMensajeAlta();

        this.usuarios.irAUsuarios();
        this.usuarios.verificarUsuarioExiste(AltaTesterData.Email);
    }
}