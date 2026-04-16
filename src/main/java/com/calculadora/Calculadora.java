package com.calculadora;

public class Calculadora {

    // ----------------------------------------------------
    // 1- Operaciones aritméticas básicas
    // ----------------------------------------------------
    public double sumar(double a, double b) {
        return a + b;
    }

    public double restar(double a, double b) {
        return a - b;
    }

    public double multiplicar(double a, double b) {
        return a * b;
    }

    public double dividir(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Error Matemático: No se puede dividir por cero.");
        }
        return a / b;
    }

    public double mayor(double a, double b) {
        return Math.max(a, b);
    }

    public double menor(double a, double b) {
        return Math.min(a, b);
    }

    public double potencia(double base, double exponente) {
        if (base == 0 && exponente == 0) {
            throw new ArithmeticException("Error Matemático: La potencia de '0' elevado a '0' no está definida.");
        }
        return Math.pow(base, exponente);
    }

    public double porcentaje(double numero, double porcentaje) {
        return (numero * porcentaje) / 100.0;
    }

    // ----------------------------------------------------
    // 2- Ecuación cuadrática: Ax^2 + Bx + C = 0
    // ----------------------------------------------------
    public double[] ecuacionCuadratica(double a, double b, double c) {
        if (a == 0) {
            throw new IllegalArgumentException("Error Analítico: El coeficiente 'A' no puede ser cero en una ecuación cuadrática (sería lineal).");
        }
        double discriminante = Math.pow(b, 2) - (4 * a * c);
        if (discriminante < 0) {
            throw new ArithmeticException("Error Matemático: La ecuación no tiene soluciones reales porque el discriminante es negativo.");
        }
        double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
        double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
        return new double[]{x1, x2};
    }

    // ----------------------------------------------------
    // 3- Figuras geométricas
    // ----------------------------------------------------
    public double perimetroCuadrado(double lado) { return 4 * lado; }
    public double areaCuadrado(double lado) { return lado * lado; }
    
    public double perimetroRectangulo(double base, double altura) { return 2 * (base + altura); }
    public double areaRectangulo(double base, double altura) { return base * altura; }
    
    public double perimetroCirculo(double radio) { return 2 * Math.PI * radio; }
    public double areaCirculo(double radio) { return Math.PI * Math.pow(radio, 2); }
    
    public double volumenEsfera(double radio) { return (4.0 / 3.0) * Math.PI * Math.pow(radio, 3); }
    public double areaEsfera(double radio) { return 4 * Math.PI * Math.pow(radio, 2); }
    
    public double volumenCubo(double arista) { return Math.pow(arista, 3); }
    public double areaCubo(double arista) { return 6 * Math.pow(arista, 2); }
    
    public double volumenCono(double radio, double altura) { return (Math.PI * Math.pow(radio, 2) * altura) / 3.0; }
    public double areaCono(double radio, double generatriz) { return Math.PI * radio * (radio + generatriz); }

    // ----------------------------------------------------
    // 4- Sistema de ecuaciones: Ax + By = C | Dx + Ey = F
    // ----------------------------------------------------
    public double[] sistemaEcuaciones(double a, double b, double c, double d, double e, double f) {
        double determinante = (a * e) - (b * d);
        if (determinante == 0) {
            throw new ArithmeticException("Error Analítico: El sistema no tiene una solución única (líneas paralelas o coincidentes).");
        }
        double x = ((c * e) - (b * f)) / determinante;
        double y = ((a * f) - (c * d)) / determinante;
        return new double[]{x, y};
    }

    // ----------------------------------------------------
    // 5- Ecuación de la recta (Y = mX + b) dado 2 puntos
    // ----------------------------------------------------
    public double[] ecuacionRecta(double x1, double y1, double x2, double y2) {
        if (x1 == x2) {
            throw new ArithmeticException("Error Analítico: La recta es vertical, la pendiente es indefinida (se intenta dividir por cero en (x2-x1)).");
        }
        double m = (y2 - y1) / (x2 - x1);
        double b = y1 - (m * x1); // Operado desde Y - mX = b
        return new double[]{m, b};
    }
}
