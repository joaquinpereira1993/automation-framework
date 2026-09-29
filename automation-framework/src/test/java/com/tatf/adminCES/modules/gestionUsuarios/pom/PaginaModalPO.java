package com.tatf.adminCES.modules.gestionUsuarios.pom;

import com.tatf.core.browser.IBrowser;

public class PaginaModalPO {
    private final IBrowser browser;

    private final String titulo = "swal2-title";
    private final String subtitulo = "swal2-html-container";
    private final String botonConfirmar = "button.swal2-confirm";
    private final String botonSi = "button.swal2-confirm";
    private final String botonCancelar = "button.swal2-cancel";

    public PaginaModalPO(IBrowser browser) {
        this.browser = browser;
    }

    public void esperarModal() {
        this.browser.wait(titulo).id();
    }

    public String obtenerTitulo() {
        return this.browser.find().id(titulo).getText();
    }

    public String obtenerSubtitulo() {
        return this.browser.find().id(subtitulo).getText();
    }

    public void clicConfirmar() {
        this.browser.find().css(botonConfirmar).click();
    }

    public void clicSi() {
        this.browser.find().css(botonSi).click();
    }

    public void clicCancelar() {
        this.browser.find().css(botonCancelar).click();
    }
}