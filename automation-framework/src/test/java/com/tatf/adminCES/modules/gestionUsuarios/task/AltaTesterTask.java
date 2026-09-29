package com.tatf.adminCES.modules.gestionUsuarios.task;

import com.tatf.adminCES.modules.gestionUsuarios.data.ModalData;
import com.tatf.adminCES.modules.gestionUsuarios.pom.PaginaAltaTesterPO;
import com.tatf.core.browser.IBrowser;

public class AltaTesterTask {
    private final PaginaAltaTesterPO altaTester;
    private final ModalTask modal;

    public AltaTesterTask(IBrowser browser) {
        this.altaTester = new PaginaAltaTesterPO(browser);
        this.modal = new ModalTask(browser);
    }

    public void abrirFormularioCrearUsuario() {
        this.altaTester.clicCrearUsuario();
    }

    public void crearTester(String nombre, String apellido, String email, String pais, String contrasenia, String idSeniority) {
        this.altaTester.ingresarNombre(nombre);
        this.altaTester.ingresarApellido(apellido);
        this.altaTester.ingresarEmail(email);
        this.altaTester.seleccionarPais(pais);
        this.altaTester.ingresarContrasenia(contrasenia);
        this.altaTester.seleccionarSeniority(idSeniority);
        this.altaTester.clicCrearCuenta();
    }

    public void verificarMensajeAlta() {
        this.modal.verificarTituloYSubtituloYConfirmar(
                ModalData.TituloModalExito, "No se mostró el mensaje de confirmación de alta del usuario tester.",
                ModalData.SubtituloUsuarioCreado, "El subtítulo del mensaje de confirmación de alta no coincide.");
    }
}
