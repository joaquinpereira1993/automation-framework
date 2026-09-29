package com.tatf.adminCES.modules.autenticacion.pom;

import com.tatf.core.browser.IBrowser;

public class PaginaAccesoPO {
    private final IBrowser browser;

    private final String campoHash = "pass";
    private final String botonEnviar = "//button[@type='submit']";

    public PaginaAccesoPO(IBrowser browser) {
        this.browser = browser;
    }

    public void ingresarHash(String hash) {
        this.browser.find().id(campoHash).write(hash);
    }

    public void clicEnviar() {
        this.browser.find().xpath(botonEnviar).click();
    }
}