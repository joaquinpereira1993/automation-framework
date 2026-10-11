package com.tatf.adminCES.modules.autenticacion.pom;

import com.tatf.core.browser.IBrowser;

public class PaginaRegistroPO {
    private final IBrowser browser;

    private final String enlaceRegistrarse = "REGISTRARSE";
    private final String campoNombre = "//input[@name='inputFirstName']";
    private final String campoApellido = "//input[@name='inputLastName']";
    private final String campoEmail = "//input[@name='inputEmail']";
    private final String campoContrasenia = "//input[@name='inputPassword']";
    private final String campoRepetirContrasenia = "//input[@name='inputRepeatPassword']";
    private final String campoPais = "//input[@name='inputCountry']";
    private final String botonRegistrarse = "btnRegister";

    public PaginaRegistroPO(IBrowser navegador) {
        this.browser = navegador;
    }

    public void clicEnlaceRegistrarse() {
        this.browser.find().link(enlaceRegistrarse).click();
    }

    public void ingresarNombre(String nombre) {
        this.browser.find().xpath(campoNombre).write(nombre);
    }

    public void ingresarApellido(String apellido) {
        this.browser.find().xpath(campoApellido).write(apellido);
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

    public void ingresarPais(String pais) {
        this.browser.find().xpath(campoPais).write(pais);
    }

    public void clicRegistrarse() {
        this.browser.find().id(botonRegistrarse).click();
    }
}