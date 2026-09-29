package com.tatf.adminCES.modules.gestionUsuarios.task;

import com.tatf.adminCES.modules.gestionUsuarios.pom.PaginaModalPO;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;

public class ModalTask {
    private final PaginaModalPO modal;

    public ModalTask(IBrowser browser) {
        this.modal = new PaginaModalPO(browser);
    }

    public void verificarTituloYConfirmar(String tituloEsperado, String mensajeError) {
        this.modal.esperarModal();
        IVerify.create().verify(tituloEsperado, this.modal.obtenerTitulo(), mensajeError);
        this.modal.clicConfirmar();
    }

    public void verificarTituloYSubtituloYConfirmar(String tituloEsperado, String mensajeErrorTitulo, String subtituloEsperado, String mensajeErrorSubtitulo) {
        this.modal.esperarModal();
        IVerify.create().verify(tituloEsperado, this.modal.obtenerTitulo(), mensajeErrorTitulo);
        IVerify.create().verify(subtituloEsperado, this.modal.obtenerSubtitulo(), mensajeErrorSubtitulo);
        this.modal.clicConfirmar();
    }

    public void verificarTituloYSubtituloYConfirmarEliminacion(String tituloEsperado, String mensajeErrorTitulo, String subtituloEsperado, String mensajeErrorSubtitulo) {
        this.modal.esperarModal();
        IVerify.create().verify(tituloEsperado, this.modal.obtenerTitulo(), mensajeErrorTitulo);
        IVerify.create().verify(subtituloEsperado, this.modal.obtenerSubtitulo(), mensajeErrorSubtitulo);
        this.modal.clicSi();
    }

    public void confirmar() {
        this.modal.clicConfirmar();
    }
}