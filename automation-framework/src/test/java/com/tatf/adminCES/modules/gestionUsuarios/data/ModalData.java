package com.tatf.adminCES.modules.gestionUsuarios.data;

public class ModalData {
    public static final String TituloModalExito = "Correcto!";
    public static final String TituloModalPregunta = "Pregunta!";

    public static final String SubtituloSesionIniciada = "Sesión iniciada.";
    public static final String SubtituloUsuarioCreado = "Usuario creado.";
    public static final String SubtituloContraseniaReiniciada = "Contraseña reiniciada.";
    public static final String SubtituloUsuarioEliminado = "Usuario eliminado.";

    public static String subtituloConfirmarEliminarUsuario(String email) {
        return "¿Eliminar usuario: " + email + "?";
    }
}