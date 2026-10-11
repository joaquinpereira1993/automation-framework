package com.tatf.adminCES.modules.gestionUsuarios.pom;

import com.tatf.core.browser.IBrowser;
import com.tatf.core.element.Element;

import java.util.List;

public class PaginaUsuariosPO {
    private final IBrowser browser;

    private final String enlaceVerUsuarios = "VER USUARIOS";

    public PaginaUsuariosPO(IBrowser browser) {
        this.browser = browser;
    }

    public void clicVerUsuarios() {
        this.browser.find().link(enlaceVerUsuarios).click();
    }

    public List<Element> obtenerFilasUsuario(String email) {
        return this.browser.find().xpathList("//td[text()='" + email + "']/parent::tr");
    }

    public void clicEliminar(String email) {
        this.browser.find().id(email).click();
    }
}