package com.tatf.adminCES.modules.autenticacion.task;

import com.tatf.adminCES.modules.gestionUsuarios.data.ModalData;
import com.tatf.adminCES.modules.gestionUsuarios.task.ModalTask;
import com.tatf.adminCES.modules.autenticacion.pom.PaginaRegistroPO;

import com.tatf.core.browser.IBrowser;

public class RegistroTask {
    private final PaginaRegistroPO registro;
    private final ModalTask modal;

    public RegistroTask(IBrowser browser) {
        this.registro = new PaginaRegistroPO(browser);
        this.modal = new ModalTask(browser);
    }

    public void registrarAdministrador(String nombre, String apellido, String email, String contrasenia, String repetirContrasenia, String pais) {
        this.registro.clicEnlaceRegistrarse();
        this.registro.ingresarNombre(nombre);
        this.registro.ingresarApellido(apellido);
        this.registro.ingresarEmail(email);
        this.registro.ingresarContrasenia(contrasenia);
        this.registro.ingresarRepetirContrasenia(repetirContrasenia);
        this.registro.ingresarPais(pais);
        this.registro.clicRegistrarse();
    }

    public void verificarMensajeRegistro() {
        this.modal.verificarTituloYSubtituloYConfirmar(
                ModalData.TituloModalExito, "No se mostró el mensaje de confirmación del registro del usuario administrador",
                ModalData.SubtituloUsuarioCreado, "El subtítulo del mensaje de confirmación de registro no coincide");
    }
}