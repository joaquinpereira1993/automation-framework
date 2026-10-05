package com.tatf.adminCES.modules.gestionUsuarios.task;

import com.tatf.adminCES.modules.gestionUsuarios.pom.PaginaPerfilPO;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;

public class PerfilTask {
    private final PaginaPerfilPO perfil;

    public PerfilTask(IBrowser browser) {
        this.perfil = new PaginaPerfilPO(browser);
    }

    public void abrirPerfil(String nombreCompleto) {
        this.perfil.clicMenuUsuario(nombreCompleto);
        this.perfil.clicPerfil();
    }

    public void verificarDatosPerfil(String nombre, String apellido, String email, String pais, String tipoPerfil) {
        IVerify.create().verify(nombre, this.perfil.obtenerNombre(), "El nombre no coincide con el usuario registrado.");
        IVerify.create().verify(apellido, this.perfil.obtenerApellido(), "El apellido no coincide con el usuario registrado.");
        IVerify.create().verify(email, this.perfil.obtenerEmail(), "El email no coincide con el usuario registrado.");
        IVerify.create().verify(pais, this.perfil.obtenerPais(), "El país no coincide con el usuario registrado.");
        IVerify.create().verify(tipoPerfil, this.perfil.obtenerPerfil(), "El perfil no coincide con el usuario registrado.");
    }
}