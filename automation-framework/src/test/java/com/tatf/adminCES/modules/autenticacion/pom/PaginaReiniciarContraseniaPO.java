package com.tatf.adminCES.modules.autenticacion.pom;

import com.tatf.core.browser.IBrowser;

public class PaginaReiniciarContraseniaPO {
    private final IBrowser browser;

    private final String enlaceReiniciarContrasenia = "REINICIAR CONTRASEÑA";
    private final String campoEmail = "//input[@name='inputEmail']";
    private final String campoContrasenia = "//input[@name='inputPassword']";
    private final String campoRepetirContrasenia = "//input[@name='inputRepeatPassword']";
    private final String botonReiniciar = "btnReset";

    public PaginaReiniciarContraseniaPO(IBrowser navegador) {
        this.browser = navegador;
    }

    public void clicEnlaceReiniciarContrasenia() {
        this.browser.find().link(enlaceReiniciarContrasenia).click();
    }

    public void ingresarEmail(String email) {
        this.browser.find().xpath(campoEmail).write(email);
    }

    public void ingresarContrasenia(String contrasenia) {
        this.browser.find().xpath(campoContrasenia).write(contrasenia);
    }

    public void ingresarRepetirContrasenia(String repetirContrasenia) {
        this.browser.find().xpath(campoRepetirContrasenia).write(repetirContrasenia);
    }

    public void clicReiniciar() {
        this.browser.find().id(botonReiniciar).click();
    }
}