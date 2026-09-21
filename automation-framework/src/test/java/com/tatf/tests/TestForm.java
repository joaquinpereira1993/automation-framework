package com.tatf.tests;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.element.Element;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class TestForm {

    private static IBrowser browser;

    @BeforeAll
    static void beforeAll() {

        browser = BrowserFactory.getBrowser(true);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
    }

    @AfterAll
    static void afterAll() {
        BrowserFactory.quitBrowser();
    }

    @Test
    void completeForm() {

        browser.interaction().navigateTo("http://cestore.ces.com.uy/autotestlab/");
        browser.find().css("input[type='password']").write("3&44fcf@42e157ff0f)21f2#ecb12ad9");
        browser.find().css("button[type='submit']").click();
        browser.find().link("Formulario").click();
        browser.find().id("nombre").write("Joaquin Pereira");
        browser.find().id("comentarios").write("Comentario de joaquin");
        browser.find().id("aceptoTerminos").click();
        browser.find().id("masculino").click();
        browser.find().id("pais").selectValue("uruguay");
        browser.find().id("fecha").write("29/06/1993");
        browser.find().link("Enviar").click();
        //driver.get("http://cestore.ces.com.uy/autotestlab/");
        //driver.findElement(By.cssSelector("input[type='password']")).sendKeys("3&44fcf@42e157ff0f)21f2#ecb12ad9");
        //driver.findElement(By.cssSelector("button[type='submit']")).click();
        //driver.findElement(By.linkText("Formulario")).click();
        //driver.findElement(By.id("nombre")).sendKeys("Juan Pérez");
        //driver.findElement(By.id("comentarios")).sendKeys("Comentario de prueba generado por automatización.");
        //driver.findElement(By.id("aceptoTerminos")).click();
        //driver.findElement(By.id("femenino")).click();

        //Select paisSelect = new Select(driver.findElement(By.id("pais")));
        //paisSelect.selectByValue("uruguay");

        //driver.findElement(By.id("fecha")).sendKeys("15/03/1995");
        //driver.findElement(By.linkText("Enviar")).click();

    }
}
