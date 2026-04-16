package com.calculadora;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuCalculadora {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculadora calc = new Calculadora();
        boolean continuar = true;

        System.out.println("====== INICIANDO CALCULADORA VCIENTIFICA ======");

        while (continuar) {
            System.out.println("\n-------------------------------------------");
            System.out.println("MENÚ PRINCIPAL");
            System.out.println("1. Operaciones aritméticas");
            System.out.println("2. Ecuación cuadrática");
            System.out.println("3. Figuras geométricas");
            System.out.println("4. Sistema ecuaciones lineales");
            System.out.println("5. Ecuación de la recta");
            System.out.println("6. Salir");
            System.out.println("-------------------------------------------");
            System.out.print("Seleccione una opción (1-6): ");

            try {
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        menuAritmetico(scanner, calc);
                        break;
                    case 2:
                        resolverCuadratica(scanner, calc);
                        break;
                    case 3:
                        menuFiguras(scanner, calc);
                        break;
                    case 4:
                        resolverSistema(scanner, calc);
                        break;
                    case 5:
                        resolverRecta(scanner, calc);
                        break;
                    case 6:
                        System.out.println("\nSaliendo de la calculadora. ¡Hasta luego!");
                        continuar = false;
                        break;
                    default:
                        System.out.println("==> Opción no válida. Ingrese un valor del 1 al 6.");
                }

            // Múltiples Excepciones cumpliendo el requerimiento de control
            } catch (InputMismatchException e) {
                System.out.println("\n==> EXCEPCIÓN DETECTADA: Por favor, ingrese un carácter NUMÉRICO válido. No se admiten letras ni símbolos especiales.");
                scanner.nextLine(); // Limpiar el buffer corrupto
            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println("\n==> OP. FALLIDA: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("\n==> EXCEPCIÓN INESPERADA: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static void menuAritmetico(Scanner scanner, Calculadora calc) {
        System.out.println("\n--- [1] Operaciones Aritméticas ---");
        System.out.print("Ingrese el primer número: ");
        double a = scanner.nextDouble();
        System.out.print("Ingrese el segundo número (o el '%'): ");
        double b = scanner.nextDouble();

        System.out.println("\nResultados:");
        System.out.println(" > Suma:           " + calc.sumar(a, b));
        System.out.println(" > Resta:          " + calc.restar(a, b));
        System.out.println(" > Multiplicación: " + calc.multiplicar(a, b));
        try {
            System.out.println(" > División:       " + calc.dividir(a, b));
        } catch (ArithmeticException e) {
            System.out.println(" > División:       [ERROR] " + e.getMessage());
        }
        System.out.println(" > Mayor:          " + calc.mayor(a, b));
        System.out.println(" > Menor:          " + calc.menor(a, b));
        try {
            System.out.println(" > Potencia (a^b): " + calc.potencia(a, b));
        } catch (ArithmeticException e) {
            System.out.println(" > Potencia:       [ERROR] " + e.getMessage());
        }
        System.out.println(" > Porcentaje (" + b + "% de " + a + "): " + calc.porcentaje(a, b));
    }

    private static void resolverCuadratica(Scanner scanner, Calculadora calc) {
        System.out.println("\n--- [2] Ecuación Cuadrática (Ax^2 + Bx + C = 0) ---");
        System.out.print("Ingrese coeficiente A: ");
        double a = scanner.nextDouble();
        System.out.print("Ingrese coeficiente B: ");
        double b = scanner.nextDouble();
        System.out.print("Ingrese coeficiente C: ");
        double c = scanner.nextDouble();

        double[] res = calc.ecuacionCuadratica(a, b, c);
        System.out.println("\n==> Soluciones: x1 = " + res[0] + ", x2 = " + res[1]);
    }

    private static void menuFiguras(Scanner scanner, Calculadora calc) {
        System.out.println("\n--- [3] Figuras Geométricas ---");
        System.out.println(" 1. Cuadrado (Perímetro y Área)");
        System.out.println(" 2. Rectángulo (Perímetro y Área)");
        System.out.println(" 3. Círculo (Perímetro y Área)");
        System.out.println(" 4. Esfera (Volumen y Área)");
        System.out.println(" 5. Cubo (Volumen y Área)");
        System.out.println(" 6. Cono (Volumen y Área)");
        System.out.print("Seleccione una figura geométrica: ");
        int fig = scanner.nextInt();
        
        switch (fig) {
            case 1:
                System.out.print("Valor del lado: ");
                double l = scanner.nextDouble();
                System.out.println("==> Perímetro: " + calc.perimetroCuadrado(l));
                System.out.println("==> Área:      " + calc.areaCuadrado(l));
                break;
            case 2:
                System.out.print("Valor base: ");
                double b = scanner.nextDouble();
                System.out.print("Valor altura: ");
                double a = scanner.nextDouble();
                System.out.println("==> Perímetro: " + calc.perimetroRectangulo(b, a));
                System.out.println("==> Área:      " + calc.areaRectangulo(b, a));
                break;
            case 3:
                System.out.print("Valor radio: ");
                double r = scanner.nextDouble();
                System.out.println("==> Perímetro: " + calc.perimetroCirculo(r));
                System.out.println("==> Área:      " + calc.areaCirculo(r));
                break;
            case 4:
                System.out.print("Valor radio central: ");
                double re = scanner.nextDouble();
                System.out.println("==> Volumen: " + calc.volumenEsfera(re));
                System.out.println("==> Área:    " + calc.areaEsfera(re));
                break;
            case 5:
                System.out.print("Valor arista: ");
                double ar = scanner.nextDouble();
                System.out.println("==> Volumen: " + calc.volumenCubo(ar));
                System.out.println("==> Área:    " + calc.areaCubo(ar));
                break;
            case 6:
                System.out.print("Valor radio base: ");
                double rc = scanner.nextDouble();
                System.out.print("Valor altura: ");
                double h = scanner.nextDouble();
                System.out.print("Valor longitud generatriz: ");
                double g = scanner.nextDouble();
                System.out.println("==> Volumen: " + calc.volumenCono(rc, h));
                System.out.println("==> Área:    " + calc.areaCono(rc, g));
                break;
            default:
                System.out.println("Opción de figura no contemplada en este menú.");
        }
    }

    private static void resolverSistema(Scanner scanner, Calculadora calc) {
        System.out.println("\n--- [4] Sistema Ecuaciones 2x2 ---");
        System.out.println("Forma: Ax + By = C  ||  Dx + Ey = F");
        System.out.print("Ingresar A: "); double a = scanner.nextDouble();
        System.out.print("Ingresar B: "); double b = scanner.nextDouble();
        System.out.print("Ingresar C: "); double c = scanner.nextDouble();
        System.out.print("Ingresar D: "); double d = scanner.nextDouble();
        System.out.print("Ingresar E: "); double e = scanner.nextDouble();
        System.out.print("Ingresar F: "); double f = scanner.nextDouble();

        double[] res = calc.sistemaEcuaciones(a, b, c, d, e, f);
        System.out.println("\n==> Solución: x = " + res[0] + ", y = " + res[1]);
    }

    private static void resolverRecta(Scanner scanner, Calculadora calc) {
        System.out.println("\n--- [5] Ecuación de la Recta (Desde P1 y P2) ---");
        System.out.print("Ingresar coordenada X del Punto 1: "); double x1 = scanner.nextDouble();
        System.out.print("Ingresar coordenada Y del Punto 1: "); double y1 = scanner.nextDouble();
        System.out.print("Ingresar coordenada X del Punto 2: "); double x2 = scanner.nextDouble();
        System.out.print("Ingresar coordenada Y del Punto 2: "); double y2 = scanner.nextDouble();

        double[] res = calc.ecuacionRecta(x1, y1, x2, y2);
        System.out.println("\n==> Ecuación resultante: Y = " + res[0] + " * X + " + res[1]);
    }
}
