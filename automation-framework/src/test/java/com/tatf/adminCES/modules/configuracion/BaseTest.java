package com.tatf.adminCES.modules.configuracion;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.util.ConfigReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    private static final ConfigReader CONFIG = new ConfigReader("config.properties");

    protected static IBrowser browser;
    protected static String url;
    protected static String hash;

    @BeforeEach
    public void prepararPruebas() {
        browser = BrowserFactory.getBrowser(true);
        url = CONFIG.asString("adminces.url");
        hash = CONFIG.asString("adminces.hash");
    }

    @AfterEach
    public void finalizarPruebas() {
        BrowserFactory.quitBrowser();
    }
}