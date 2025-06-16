package interfaces;

import model.Consulta;

import java.util.Scanner;

public interface Prescreve {
    void gerarPrescricao(Consulta consulta, Scanner sc);
    void realizarAnamneseClinica(Consulta consulta, Scanner sc);
}
