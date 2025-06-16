package interfaces;

import model.Consulta;

import java.util.Scanner;

public interface PlanejaAlimentar {
    void gerarPlanoAlimentar(Consulta consulta, Scanner sc);
    void realizarAnamneseNutricional(Consulta consulta, Scanner sc);
}
