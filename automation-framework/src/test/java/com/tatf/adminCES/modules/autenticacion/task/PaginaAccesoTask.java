package com.tatf.adminCES.modules.autenticacion.task;

import com.tatf.adminCES.modules.autenticacion.pom.PaginaAccesoPO;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;

public class PaginaAccesoTask {
    private final IBrowser browser;
    private final PaginaAccesoPO acceso;

    public PaginaAccesoTask(IBrowser navegador) {
        this.browser = navegador;
        this.acceso = new PaginaAccesoPO(this.browser);
    }

    public void ingresarAlSistema(String url, String hash) {
        this.browser.interaction().navigateTo(url);
        this.acceso.ingresarHash(hash);
        this.acceso.clicEnviar();
    }

    public void verificarUrl(String urlEsperada) {
        IVerify.create().verify(urlEsperada, this.browser.interaction().url(), "No se encuentra en la página esperada.");
    }
}