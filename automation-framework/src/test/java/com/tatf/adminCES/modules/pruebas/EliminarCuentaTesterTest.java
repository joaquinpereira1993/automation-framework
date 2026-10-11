package com.tatf.adminCES.modules.pruebas;

import com.tatf.adminCES.modules.autenticacion.data.LoginData;
import com.tatf.adminCES.modules.autenticacion.task.LoginTask;
import com.tatf.adminCES.modules.autenticacion.task.PaginaAccesoTask;
import com.tatf.adminCES.modules.configuracion.BaseTest;
import com.tatf.adminCES.modules.gestionUsuarios.task.AltaTesterTask;
import com.tatf.adminCES.modules.gestionUsuarios.task.ListaUsuariosTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@Tag("tester")
public class EliminarCuentaTesterTest extends BaseTest {
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

    @ParameterizedTest(name = "{arguments}")
    @Tag("regresion")
    @CsvFileSource(
            resources = "/datos_EliminarUsuarioTester.csv",
            useHeadersInDisplayName = true
    )
    @DisplayName("Elimina una cuenta con perfil tester y valida que ya no exista")
    public void eliminarCuentaTesterTest(String nombre, String apellido, String email, String pais, String contrasenia, String seniority) {
        this.acceso.ingresarAlSistema(url, hash);
        this.acceso.verificarUrl(url);

        this.inicioSesion.iniciarSesionYVerificar(LoginData.EmailAdmin2, LoginData.ContraseniaAdmin2);

        //Se crea el tester que luego se va a eliminar, para que cada fila del CSV sea independiente
        this.altaTester.abrirFormularioCrearUsuario();
        this.altaTester.crearTester(nombre, apellido, email, pais, contrasenia, seniority);
        this.altaTester.verificarMensajeAlta();

        this.usuarios.irAUsuarios();
        this.usuarios.verificarUsuarioExiste(email);

        this.usuarios.eliminarUsuario(email);
        this.usuarios.verificarUsuarioNoExiste(email);
    }
}