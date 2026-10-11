# Estructura del proyecto

![framework-structure.png](README/framework-structure.png)

# AdminCES – Proyecto de Automatización de Testing Funcional

## Funcionalidades cubiertas

Se automatizaron los cuatro flujos principales del panel AdminCES:

- **CrearCuentaAdminTest** – da de alta un usuario con perfil Administrador y valida que se haya registrado correctamente.
- **CrearCuentaTesterTest** – crea un usuario con perfil Tester y confirma que aparezca en la lista de usuarios.
- **EliminarCuentaTesterTest** – elimina una cuenta Tester existente y verifica que ya no figure en el sistema.
- **ReiniciarContraseniaTest** – restablece la contraseña de un usuario Administrador y valida el acceso con la nueva clave.

## Suites armadas

Para no tener que ejecutar cada prueba por separado, se agruparon los cuatro escenarios en **suites de JUnit 5**, usando la API `@Suite` del framework. Esto permite correr distintos subconjuntos de pruebas según lo que se necesite en cada momento, sin tener que ir clase por clase.

- **SuiteCompletaAdminCES:** agrupa todas las clases de prueba del proyecto (`CrearCuentaAdminTest`, `CrearCuentaTesterTest`, `EliminarCuentaTesterTest`, `ReiniciarContraseniaTest`) seleccionando el paquete donde viven los tests con `@SelectPackages`. Es la que se usa para correr la regresión completa del proyecto.

- **SuiteCrearUsuariosNuevos:** agrupa `CrearCuentaAdminTest` y `CrearCuentaTesterTest`, es decir, los dos escenarios de alta de usuario (Administrador y Tester). Sirve para validar rápidamente que el sistema sigue permitiendo crear cuentas correctamente, sin correr el resto de las pruebas.

- **SuiteRegresionSinDebug:** agrupa todas las pruebas excepto `ReiniciarContraseniaTest`, que quedó marcada con `@Tag("debug")` por tratarse de un flujo más inestable/sensible a validar manualmente. Esta suite corre `CrearCuentaAdminTest`, `CrearCuentaTesterTest` y `EliminarCuentaTesterTest`, excluyendo la de reinicio de contraseña con `@ExcludeTags("debug")`.

Esta organización permite elegir, según el momento, entre una ejecución acotada (altas de usuarios), una ejecución de regresión sin los casos más inestables, o la suite completa con los cuatro escenarios.

## Ejecución en distintos navegadores

Para correr las pruebas en Chrome y Firefox se armó una fábrica de drivers (`DriverManagerFactory`, `BrowserFactory`) que permite elegir el navegador simplemente pasando el parámetro `-Dbrowser` al ejecutar, sin tener que tocar el código.

## Parametrización

Los datos de prueba (nombre, email, contraseña, país, etc.) se cargan desde archivos `.csv` en vez de estar escritos a mano en el código. Así, una misma prueba se puede correr varias veces con distintos datos usando `@CsvFileSource`.

## Dependencias principales

El proyecto usa Maven para gestionar las dependencias, entre ellas Selenium WebDriver para manejar el navegador, JUnit 5 como motor de pruebas, y Allure para generar el informe de resultados.

## Patrón de diseño utilizado

Se trabajó con el patron de diseño **Page Object Model (POM)**, separando el código en capas de datos, páginas, tareas y pruebas. Esto hace que el código sea más fácil de mantener: si cambia algo en la interfaz, solo hay que ajustar el objeto de página correspondiente.