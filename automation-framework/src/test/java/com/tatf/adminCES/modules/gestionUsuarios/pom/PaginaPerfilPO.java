
package com.tatf.adminCES.modules.gestionUsuarios.pom;

import com.tatf.core.browser.IBrowser;

public class PaginaPerfilPO {
    private final IBrowser browser;

    private final String enlacePerfil = "Perfil";
    private final String campoNombre = "inputFirstName";
    private final String campoApellido = "inputLastName";
    private final String campoEmail = "inputEmail";
    private final String campoPais = "inputCountry";
    private final String campoPerfil = "input[value='Administrador']";

    public PaginaPerfilPO(IBrowser browser) {
        this.browser = browser;
    }

    public void clicMenuUsuario(String nombreCompleto) {
        this.browser.find().link(nombreCompleto).click();
    }

    public void clicPerfil() {
        this.browser.find().link(enlacePerfil).click();
    }

    public String obtenerNombre() {
        return this.browser.find().name(campoNombre).getAttribute("value");
    }

    public String obtenerApellido() {
        return this.browser.find().name(campoApellido).getAttribute("value");
    }

    public String obtenerEmail() {
        return this.browser.find().name(campoEmail).getAttribute("value");
    }

    public String obtenerPais() {
        return this.browser.find().name(campoPais).getAttribute("value");
    }

    public String obtenerPerfil() {
        return this.browser.find().css(campoPerfil).getAttribute("value");
    }
}