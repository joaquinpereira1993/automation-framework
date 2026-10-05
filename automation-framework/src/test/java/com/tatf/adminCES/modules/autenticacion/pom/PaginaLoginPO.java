package com.tatf.adminCES.modules.autenticacion.pom;

import com.tatf.core.browser.IBrowser;

public class PaginaLoginPO {
    private final IBrowser browser;

    private final String enlaceIniciarSesion = "INICIAR SESIÓN";
    private final String campoEmail = "//input[@name='inputEmail']";
    private final String campoContrasenia = "//input[@name='inputPassword']";
    private final String botonIniciarSesion = "//button[text()='Iniciar Sesión']";

    public PaginaLoginPO(IBrowser browser) {
        this.browser = browser;
    }

    public void clicEnlaceIniciarSesion() {
        this.browser.find().link(enlaceIniciarSesion).click();
    }

    public void ingresarEmail(String email) {
        this.browser.find().xpath(campoEmail).write(email);
    }

    public void ingresarContrasenia(String contrasenia) {
        this.browser.find().xpath(campoContrasenia).write(contrasenia);
    }

    public void clicIniciarSesion() {
        this.browser.find().xpath(botonIniciarSesion).click();
    }
}