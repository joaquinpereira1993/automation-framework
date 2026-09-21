package com.tatf.tests;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.element.Element;
import com.tatf.core.verification.IVerify;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.jupiter.api.MethodOrderer;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class AdminCesTest {
    private static IBrowser browser;

    //Variables para ingresar a la pagina de AdminCES
    private static String url = "http://cestore.ces.com.uy/adminces/";
    private static String hashEstatico = "3)ea60e0be3ba12c6ecd%7297868%5c4";

    //Variables para Crear cuenta administrador
    private static String nombre = "Joaquin";
    private static String apellido = "Pereira";
    private static String email = "JPereira@test.com";
    private static String contrasenia = "123456";
    private static String repetirContrasenia = "123456";
    private static String pais = "Uruguay";

    //Variables para Reiniciar contraseña
    private static String contraseniaNueva = "CES2026";
    private static String repetirContraseniaNueva = "CES2026";

    //Variables para iniciar sesion de cuenta administradores predeterminadas por el sistema
    private static String emailPredeterminado1 = "leonardoperez@gmail.com";
    private static String contraseniaPredeterminada1 = "12345";
    private static String emailPredeterminado2 = "yaniscorrea@gmail.com";
    private static String contraseniaPredeterminada2 = "12345";

    //Variables para Crear usuario tester
    private static String nombreTester = "Jose";
    private static String apellidoTester = "Perez";
    private static String emailTester = "jperez@testing.com";
    private static String contraseniaTester = "1234567";
    private static String paisTester = "Argentina";
    private static String seniorityTester = "testerSenior";

    @BeforeAll
    static void beforeAll() {

        browser = BrowserFactory.getBrowser(true);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("--ignore-certificate-errors");
    }
    @BeforeEach
    void beforeEach() {
        browser = BrowserFactory.getBrowser(true);
    }
    @AfterEach
    void afterEach() {
        BrowserFactory.quitBrowser();
    }
    @AfterAll
    static void afterAll() {
        BrowserFactory.quitBrowser();
    }


    // Ingresa a la página de AdminCES usando el hash estático.
    private void ingresarAPaginaAdminCES() {
        browser.interaction().navigateTo(url);
        browser.find().id("pass").write(hashEstatico);
        browser.find().xpath("//button[@type='submit']").click();
    }


     // Valida que la URL actual del navegador coincida con la URL esperada.
     // @param urlEsperada URL contra la que se compara la actual.
    private void validarUrl(String urlEsperada) {
        String urlActual = browser.interaction().url();
        IVerify.create().verify(urlEsperada, urlActual, "No se encuentra en la página esperada.");
    }

    @Order(1)
    @Test
    void CrearCuentaAdmin() {

        //Ingresar a la pagina de AdminCES
        ingresarAPaginaAdminCES();

        //Validar que la pagina que se va trabajar sea la correcta
        validarUrl(url);

        //Registrar usuario
        browser.find().link("REGISTRARSE").click();
        browser.find().xpath("//input[@name='inputFirstName']").write(nombre);
        browser.find().xpath("//input[@name='inputLastName']").write(apellido);
        browser.find().xpath("//input[@name='inputEmail']").write(email);
        browser.find().xpath("//input[@name='inputPassword']").write(contrasenia);
        browser.find().xpath("//input[@name='inputRepeatPassword']").write(repetirContrasenia);
        browser.find().xpath("//input[@name='inputCountry']").write(pais);
        browser.find().id("btnRegister").click();
        browser.find().css("button.swal2-confirm").click();

        //Verificar que el usuario admin registrado existe
        browser.find().link("INICIAR SESIÓN").click();
        browser.find().xpath("//input[@name='inputEmail']").write(email);
        browser.find().xpath("//input[@name='inputPassword']").write(contrasenia);
        browser.find().xpath("//button[@type='button' and @class='btn btn-orange-ces rounded-end-pill btn-block']").click();
        browser.find().css("button.swal2-confirm").click();
        browser.find().link("Joaquin Pereira").click();
        browser.find().link("Perfil").click();

        //Verificar los datos sean correctos del usuario administrador registrado
        Element campoNombre = browser.find().name("inputFirstName");
        IVerify.create().verify(nombre, campoNombre.getAttribute("value"), "El nombre no coincide con el usuario registrado");

        Element campoApellido = browser.find().name("inputLastName");
        IVerify.create().verify(apellido, campoApellido.getAttribute("value"), "El apellido no coincide con el usuario registrado");

        Element campoEmail = browser.find().name("inputEmail");
        IVerify.create().verify(email, campoEmail.getAttribute("value"), "El email no coincide con el usuario registrado");

        Element campoPais = browser.find().name("inputCountry");
        IVerify.create().verify(pais, campoPais.getAttribute("value"), "El país no coincide con el usuario registrado");

        Element campoPerfil = browser.find().css("input[value='Administrador']");
        IVerify.create().verify("Administrador", campoPerfil.getAttribute("value"), "El perfil no coincide con el usuario registrado");
    }
    @Order(2)
    @Test
    void crearCuentaTester(){
        //Ingresar a la pagina de AdminCES
        ingresarAPaginaAdminCES();

        //Validar que la pagina que se va trabajar sea la correcta
        validarUrl(url);

        //Iniciar sesion
        browser.find().link("INICIAR SESIÓN").click();
        browser.find().xpath("//input[@name='inputEmail']").write(emailPredeterminado1);
        browser.find().xpath("//input[@name='inputPassword']").write(contraseniaPredeterminada1);
        browser.find().xpath("//button[@type='button' and @class='btn btn-orange-ces rounded-end-pill btn-block']").click();
        browser.find().css("button.swal2-confirm").click();
        browser.find().id("cardLogin").click();

        browser.find().xpath("//input[@name='inputFirstName']").write(nombreTester);
        browser.find().xpath("//input[@name='inputLastName']").write(apellidoTester);
        browser.find().xpath("//input[@name='inputEmail']").write(emailTester);
        browser.find().xpath("//select[@name='inputCountry']").selectValue(paisTester);
        browser.find().xpath("//input[@name='inputPassword']").write(contraseniaTester);
        browser.find().id(seniorityTester).click();
        browser.find().id("btnRegister").click();
        browser.find().css("button.swal2-confirm").click(); //Selecciona botón "OK" en el mensaje y cierra el mensaje de alerta
        browser.find().link("VER USUARIOS").click();

        //Validar que el usuario Tester creado existe correctamente
        String xpathUsuarioTester = "//td[text()='jperez@testing.com']/parent::tr"; //Xpath de la fila completa del usuario tester creado
        List<Element> usuarioTester = browser.find().xpathList(xpathUsuarioTester);
        IVerify.create().verifyFalse(usuarioTester.isEmpty(), "El usuario Jose Perez no se encuentra en la lista de usuarios");
    }
    @Order(3)
    @Test
    void EliminarCuentaTester(){

        //Ingresar a la pagina de AdminCES
        ingresarAPaginaAdminCES();

        //Validar que la pagina que se va trabajar sea la correcta
        validarUrl(url);

        //Iniciar sesion
        browser.find().link("INICIAR SESIÓN").click();
        browser.find().xpath("//input[@name='inputEmail']").write(emailPredeterminado2);
        browser.find().xpath("//input[@name='inputPassword']").write(contraseniaPredeterminada2);
        browser.find().xpath("//button[@type='button' and @class='btn btn-orange-ces rounded-end-pill btn-block']").click();
        browser.find().css("button.swal2-confirm").click();

        //Ingresar a lista de usuarios
        browser.find().link("VER USUARIOS").click();

        //Validar que exista al menos un usuario con perfil Tester antes de eliminar
        List<Element> usuariosTester = browser.find().xpathList("//td[contains(text(),'Tester')]");
        IVerify.create().verifyFalse(usuariosTester.isEmpty(), "No existe ningún usuario con perfil Tester para eliminar.");

        //Seleccionar un usuario Tester y eliminarlo
        browser.find().id("jeniffer@gmail.com").click();
        browser.find().css("button.swal2-confirm").click();
        browser.find().css("button.swal2-confirm").click();

        //Verificar que el usuario eliminado ya no exista en la lista de usuarios
        List<Element> usuarioEliminado = browser.find().xpathList("//td[text()='jeniffer@gmail.com']");
        IVerify.create().verifyTrue(usuarioEliminado.isEmpty(), "El usuario eliminado todavía figura en la lista de usuarios.");
    }
    @Order(4)
    @Test
    void ReiniciarContrasenia(){

        //Ingresar a la pagina de AdminCES
        ingresarAPaginaAdminCES();

        //Validar que la pagina que se va trabajar sea la correcta
        validarUrl(url);

        //Ingresar en sección Reiniciar contraseña
        browser.find().link("REINICIAR CONTRASEÑA").click();
        browser.find().xpath("//input[@name='inputEmail']").write(emailPredeterminado1);
        browser.find().xpath("//input[@name='inputPassword']").write(contraseniaNueva);
        browser.find().xpath("//input[@name='inputRepeatPassword']").write(repetirContraseniaNueva);
        browser.find().id("btnReset").click();
        browser.find().css("button.swal2-confirm").click();

        //Validar que la contraseña fue actualizada iniciando sesión
        browser.find().link("INICIAR SESIÓN").click();
        browser.find().xpath("//input[@name='inputEmail']").write(emailPredeterminado1);
        browser.find().xpath("//input[@name='inputPassword']").write(contraseniaNueva);
        browser.find().xpath("//button[@type='button' and @class='btn btn-orange-ces rounded-end-pill btn-block']").click();
        browser.find().css("button.swal2-confirm").click();

    }
}
