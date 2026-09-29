package com.tatf.adminCES.modules.gestionUsuarios.task;

import com.tatf.adminCES.modules.gestionUsuarios.data.ModalData;
import com.tatf.adminCES.modules.gestionUsuarios.pom.PaginaUsuariosPO;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;

public class ListaUsuariosTask {
    private final PaginaUsuariosPO usuarios;
    private final ModalTask modal;

    public ListaUsuariosTask(IBrowser browser) {
        this.usuarios = new PaginaUsuariosPO(browser);
        this.modal = new ModalTask(browser);
    }

    public void irAUsuarios() {
        this.usuarios.clicVerUsuarios();
    }

    public void verificarUsuarioExiste(String email) {
        IVerify.create().verifyFalse(this.usuarios.obtenerFilasUsuario(email).isEmpty(), "El usuario " + email + " no se encuentra en la lista de usuarios.");
    }

    public void verificarUsuarioNoExiste(String email) {
        IVerify.create().verifyTrue(this.usuarios.obtenerFilasUsuario(email).isEmpty(), "El usuario eliminado todavía figura en la lista de usuarios.");
    }

    public void eliminarUsuario(String email) {
        this.usuarios.clicEliminar(email);
        this.modal.verificarTituloYSubtituloYConfirmarEliminacion(
                ModalData.TituloModalPregunta, "No se mostró el mensaje de confirmación de eliminación.",
                ModalData.subtituloConfirmarEliminarUsuario(email), "El subtítulo del mensaje de confirmación de eliminación no coincide.");
        this.modal.verificarTituloYSubtituloYConfirmar(
                ModalData.TituloModalExito, "No se mostró el mensaje de éxito de la eliminación.",
                ModalData.SubtituloUsuarioEliminado, "El subtítulo del mensaje de eliminación exitosa no coincide.");
    }
}