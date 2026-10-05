package com.tatf.adminCES.modules.autenticacion.task;

import com.tatf.adminCES.modules.gestionUsuarios.data.ModalData;
import com.tatf.adminCES.modules.gestionUsuarios.task.ModalTask;
import com.tatf.adminCES.modules.autenticacion.pom.PaginaReiniciarContraseniaPO;
import com.tatf.core.browser.IBrowser;

public class ReiniciarContraseniaTask {
    private final PaginaReiniciarContraseniaPO reinicioContrasenia;
    private final ModalTask modal;

    public ReiniciarContraseniaTask(IBrowser browser) {
        this.reinicioContrasenia = new PaginaReiniciarContraseniaPO(browser);
        this.modal = new ModalTask(browser);
    }

    public void reiniciarContrasenia(String email, String contrasenia, String repetirContrasenia) {
        this.reinicioContrasenia.clicEnlaceReiniciarContrasenia();
        this.reinicioContrasenia.ingresarEmail(email);
        this.reinicioContrasenia.ingresarContrasenia(contrasenia);
        this.reinicioContrasenia.ingresarRepetirContrasenia(repetirContrasenia);
        this.reinicioContrasenia.clicReiniciar();
    }

    public void verificarMensajeReinicio() {
        this.modal.verificarTituloYSubtituloYConfirmar(
                ModalData.TituloModalExito, "No se mostró el mensaje de confirmación del reinicio de contraseña.",
                ModalData.SubtituloContraseniaReiniciada, "El subtítulo del mensaje de confirmación de reinicio no coincide.");
    }
}
