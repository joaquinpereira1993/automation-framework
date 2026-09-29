package com.tatf.adminCES.modules.gestionUsuarios.pom;

import com.tatf.core.browser.IBrowser;

public class PaginaAltaTesterPO {
    private final IBrowser browser;

    private final String tarjetaCrearUsuario = "cardLogin";
    private final String campoNombre = "//input[@name='inputFirstName']";
    private final String campoApellido = "//input[@name='inputLastName']";
    private final String campoEmail = "//input[@name='inputEmail']";
    private final String selectorPais = "//select[@name='inputCountry']";
    private final String campoContrasenia = "//input[@name='inputPassword']";
    private final String botonCrearCuenta = "btnRegister";

    public PaginaAltaTesterPO(IBrowser browser) {
        this.browser = browser;
    }

    public void clicCrearUsuario() {
        this.browser.find().id(tarjetaCrearUsuario).click();
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

    public void seleccionarPais(String pais) {
        this.browser.find().xpath(selectorPais).selectValue(pais);
    }

    public void ingresarContrasenia(String contrasenia) {
        this.browser.find().xpath(campoContrasenia).write(contrasenia);
    }

    public void seleccionarSeniority(String idSeniority) {
        this.browser.find().id(idSeniority).click();
    }

    public void clicCrearCuenta() {
        this.browser.find().id(botonCrearCuenta).click();
    }
}
