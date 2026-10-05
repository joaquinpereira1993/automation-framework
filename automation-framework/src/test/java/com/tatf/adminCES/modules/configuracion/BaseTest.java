package com.tatf.adminCES.modules.configuracion;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    protected static IBrowser browser;
    protected static String url;
    protected static String hash;

    @BeforeEach
    public void prepararPrueba() {
        browser = BrowserFactory.getBrowser(true);
        url = "http://cestore.ces.com.uy/adminces/";
        hash = "3)ea60e0be3ba12c6ecd%7297868%5c4";
    }

    @AfterEach
    public void finalizarPrueba() {
        BrowserFactory.quitBrowser();
    }
}