package model;

import java.util.*;

public class GerarID {

    public static String gerarIdPaciente(List<Paciente> pacientes) {
        int numero = pacientes.size() + 1;
        return String.format("PACI-%02d", numero);
    }

    public static String gerarIdConsulta(List<Consulta> consultas) {
        int numero = consultas.size() + 1;
        return String.format("CONS-%02d", numero);
    }

}
