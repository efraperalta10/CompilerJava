/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package compiler;

/**
 *
 * @author Moisés
 */
//Clase para almacenar tokens que podemos detectar con el analizador lexico
public enum Tokens {
    Reservadas,
    Igual,
    Suma,
    Resta,
    Multiplicacion,
    Division,
    Identificador,
    Numero,
    Potencia,
    MENOR,
    MENORIGUAL,
    MAYOR,
    MAYORIGUAL,
    DIFERENTE,
    ASIGNACION,
    PUNTOCOMA,
    PUNTO,
    COMA,
    PAR_ABRE,
    PAR_CIERRE,
    LLAV_ABRE,
    LLAV_CIERRE,
    ERROR
}
