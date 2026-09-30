package com.tatf.adminCES.modules.tests;

import com.tatf.adminCES.modules.configuracion.BaseTest;
import com.tatf.adminCES.modules.gestionUsuarios.data.UsuariosData;
import com.tatf.adminCES.modules.gestionUsuarios.task.ListaUsuariosTask;
import com.tatf.adminCES.modules.autenticacion.data.LoginData;
import com.tatf.adminCES.modules.autenticacion.task.PaginaAccesoTask;
import com.tatf.adminCES.modules.autenticacion.task.LoginTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EliminarCuentaTesterTest extends BaseTest {
    private PaginaAccesoTask acceso;
    private LoginTask inicioSesion;
    private ListaUsuariosTask usuarios;

    @BeforeEach
    public void configurar() {
        this.acceso = new PaginaAccesoTask(browser);
        this.inicioSesion = new LoginTask(browser);
        this.usuarios = new ListaUsuariosTask(browser);
    }

    @Test
    @DisplayName("Elimina una cuenta con perfil tester y valida que ya no exista")
    public void eliminarCuentaTesterTest() {
        this.acceso.ingresarAlSistema(url, hash);
        this.acceso.verificarUrl(url);

        this.inicioSesion.iniciarSesionYVerificar(LoginData.EmailAdmin2, LoginData.ContraseniaAdmin2);

        this.usuarios.irAUsuarios();
        this.usuarios.verificarUsuarioExiste(UsuariosData.EmailParaEliminar);

        this.usuarios.eliminarUsuario(UsuariosData.EmailParaEliminar);
        this.usuarios.verificarUsuarioNoExiste(UsuariosData.EmailParaEliminar);
    }
}