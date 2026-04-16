package com.calculadora;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {

    Calculadora calc = new Calculadora();

    // ----------------------------------------------------------------------------------------
    // Mínimo: 2 pruebas unitarias por método para garantizar cumplimiento de la rúbrica.
    // ----------------------------------------------------------------------------------------

    @Test
    void testSumar() {
        assertEquals(5.0, calc.sumar(2.0, 3.0), "La suma de positivos falló");
        assertEquals(-1.0, calc.sumar(2.0, -3.0), "La suma de negativos falló");
    }

    @Test
    void testRestar() {
        assertEquals(1.0, calc.restar(3.0, 2.0));
        assertEquals(-5.0, calc.restar(-2.0, 3.0));
    }

    @Test
    void testMultiplicar() {
        assertEquals(6.0, calc.multiplicar(2.0, 3.0));
        assertEquals(-6.0, calc.multiplicar(-2.0, 3.0));
    }

    @Test
    void testDividir() {
        assertEquals(2.0, calc.dividir(6.0, 3.0));
        // Evaluación del requerimiento específico: "Qué pasa si el divisor es CERO"
        assertThrows(ArithmeticException.class, () -> calc.dividir(5.0, 0.0), "Debe lanzar excepción matemática");
    }

    @Test
    void testMayor() {
        assertEquals(5.0, calc.mayor(2.0, 5.0));
        assertEquals(5.0, calc.mayor(5.0, -2.0));
    }

    @Test
    void testMenor() {
        assertEquals(2.0, calc.menor(2.0, 5.0));
        assertEquals(-2.0, calc.menor(5.0, -2.0));
    }

    @Test
    void testPotencia() {
        assertEquals(8.0, calc.potencia(2.0, 3.0));
        // Evaluación del requerimiento específico: "Qué pasa si base y exponente son CERO"
        assertThrows(ArithmeticException.class, () -> calc.potencia(0.0, 0.0), "0^0 matemático detectado");
    }

    @Test
    void testPorcentaje() {
        assertEquals(20.0, calc.porcentaje(100.0, 20.0));
        assertEquals(2.5, calc.porcentaje(50.0, 5.0));
    }

    // ----------------------------------------------------------------------------------------
    // Pruebas Ecuación Cuadrática
    // ----------------------------------------------------------------------------------------
    @Test
    void testEcuacionCuadratica() {
        // x^2 - 5x + 6 = 0 -> Soluciones: 3 y 2
        double[] res = calc.ecuacionCuadratica(1, -5, 6);
        assertEquals(3.0, res[0]);
        assertEquals(2.0, res[1]);

        // Error manejado para 'A=0'
        assertThrows(IllegalArgumentException.class, () -> calc.ecuacionCuadratica(0, 2, 1));
        
        // Raíz imaginaria / negativa -> Maneja ArithmeticException implementado
        assertThrows(ArithmeticException.class, () -> calc.ecuacionCuadratica(1, 1, 1));
    }

    // ----------------------------------------------------------------------------------------
    // Pruebas Geometría (2 casos por métricas principales)
    // ----------------------------------------------------------------------------------------
    @Test void testAreaCuadrado() { assertEquals(16.0, calc.areaCuadrado(4.0)); assertEquals(0.0, calc.areaCuadrado(0.0)); }
    @Test void testPerimetroCuadrado() { assertEquals(16.0, calc.perimetroCuadrado(4.0)); assertEquals(20.0, calc.perimetroCuadrado(5.0)); }
    
    @Test void testAreaRectangulo() { assertEquals(8.0, calc.areaRectangulo(4.0, 2.0)); assertEquals(20.0, calc.areaRectangulo(4.0, 5.0)); }
    @Test void testPerimetroRectangulo() { assertEquals(12.0, calc.perimetroRectangulo(4.0, 2.0)); assertEquals(18.0, calc.perimetroRectangulo(4.0, 5.0)); }
    
    @Test void testAreaCirculo() { assertEquals(Math.PI, calc.areaCirculo(1.0)); assertEquals(4*Math.PI, calc.areaCirculo(2.0)); }
    @Test void testPerimetroCirculo() { assertEquals(2*Math.PI, calc.perimetroCirculo(1.0)); assertEquals(4*Math.PI, calc.perimetroCirculo(2.0)); }

    @Test void testVolumenEsfera() { assertEquals((4.0/3.0)*Math.PI, calc.volumenEsfera(1.0), 0.0001); assertEquals((4.0/3.0)*Math.PI*8, calc.volumenEsfera(2.0), 0.0001); }
    @Test void testAreaEsfera() { assertEquals(4*Math.PI, calc.areaEsfera(1.0)); assertEquals(16*Math.PI, calc.areaEsfera(2.0)); }

    @Test void testVolumenCubo() { assertEquals(8.0, calc.volumenCubo(2.0)); assertEquals(27.0, calc.volumenCubo(3.0)); }
    @Test void testAreaCubo() { assertEquals(24.0, calc.areaCubo(2.0)); assertEquals(54.0, calc.areaCubo(3.0)); }

    @Test void testVolumenCono() { assertEquals(Math.PI/3.0, calc.volumenCono(1.0, 1.0), 0.0001); assertEquals(Math.PI*4*2/3.0, calc.volumenCono(2.0, 2.0), 0.0001); }
    @Test void testAreaCono() { assertEquals(Math.PI*2, calc.areaCono(1.0, 1.0)); assertEquals(Math.PI*2*(4.0), calc.areaCono(2.0, 2.0)); }

    // ----------------------------------------------------------------------------------------
    // Sistema y Recta
    // ----------------------------------------------------------------------------------------
    @Test
    void testSistemaEcuaciones() {
        // x=1, y=2
        double[] res1 = calc.sistemaEcuaciones(2, 1, 4, 1, -1, -1);
        assertEquals(1.0, res1[0]);
        assertEquals(2.0, res1[1]);
        
        // Otro caso normal: 2x+y=5, 3x+2y=8 (x=2,y=1) -> A=2,B=1,C=5 | D=3,E=2,F=8
        double[] res2 = calc.sistemaEcuaciones(2, 1, 5, 3, 2, 8);
        assertEquals(2.0, res2[0]);
        assertEquals(1.0, res2[1]);

        // Manejo de Zero como determinante
        assertThrows(ArithmeticException.class, () -> calc.sistemaEcuaciones(1, 1, 1, 1, 1, 1));
    }

    @Test
    void testEcuacionRecta() {
        // P1(1,2), P2(3,4) -> m=1, b=1
        double[] res1 = calc.ecuacionRecta(1, 2, 3, 4);
        assertEquals(1.0, res1[0]);
        assertEquals(1.0, res1[1]);
        
        // P1(0,0), P2(2,4) -> m=2, b=0
        double[] res2 = calc.ecuacionRecta(0, 0, 2, 4);
        assertEquals(2.0, res2[0]);
        assertEquals(0.0, res2[1]);

        // Recta vertical -> lanza excep
        assertThrows(ArithmeticException.class, () -> calc.ecuacionRecta(2, 2, 2, 4));
    }
}
