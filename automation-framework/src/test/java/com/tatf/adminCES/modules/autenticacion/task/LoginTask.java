package com.tatf.adminCES.modules.autenticacion.task;

import com.tatf.adminCES.modules.gestionUsuarios.data.ModalData;
import com.tatf.adminCES.modules.gestionUsuarios.task.ModalTask;
import com.tatf.adminCES.modules.autenticacion.pom.PaginaLoginPO;
import com.tatf.core.browser.IBrowser;

public class LoginTask {
    private final PaginaLoginPO login;
    private final ModalTask modal;

    public LoginTask(IBrowser browser) {
        this.login = new PaginaLoginPO(browser);
        this.modal = new ModalTask(browser);
    }

    public void iniciarSesionYVerificar(String email, String contrasenia) {
        this.login.clicEnlaceIniciarSesion();
        this.login.ingresarEmail(email);
        this.login.ingresarContrasenia(contrasenia);
        this.login.clicIniciarSesion();
        this.modal.verificarTituloYSubtituloYConfirmar(
                ModalData.TituloModalExito, "No se mostró el mensaje de confirmación de ingreso exitoso.",
                ModalData.SubtituloSesionIniciada, "El subtítulo del mensaje de confirmación de ingreso no coincide.");
    }
}