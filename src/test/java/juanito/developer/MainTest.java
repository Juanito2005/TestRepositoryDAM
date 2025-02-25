package juanito.developer;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    void testMain() {
        // Según lo que entendí, se redirecciona el otuput a una variable (baos)
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));
        Main.main(new String[]{});

        System.setOut(originalOut);
        // Se comprueba que el String de salida sea el mismo que el del test
        String output = baos.toString();
        assertTrue(output.contains("Total de inventario:150"));
        assertTrue(output.contains("Producto mas caro:50"));
        assertTrue(output.contains("Inventario actualizado: [10, 20, 35, 40, 50]"));
    }

    @Test
    void testActualizarInventario() {
        // Test básico
        int[] inventarioActu = {10, 20 ,30, 40, 55};
        int[] inventarioOri = {10, 20, 30, 40, 50};
        Main.actualizarInventario(inventarioOri, 4, 5);
        assertArrayEquals(inventarioActu, inventarioOri);

        // Prueba con cantidades negativas
        int[] inventarioActu2 = {10, 20 ,29, 40, 50};
        int[] inventarioOri1 = {10, 20, 30, 40, 50};
        Main.actualizarInventario(inventarioOri1, 2, -1);
        assertArrayEquals(inventarioActu2, inventarioOri1);

        // Se comprueba que actualice el índice esperado
        assertEquals(inventarioActu[4], inventarioOri[4]);

        // Se comprueba que ignora índices por encima de límite :)
        int[] inventarioOriginal = {10, 20, 30, 40, 55};
        Main.actualizarInventario(inventarioOriginal, 5, 20);
        assertArrayEquals(inventarioActu, inventarioOriginal);

        // Se comprueba que igora índices por debajo de límite :(
        int[] inventarioOriginal2 = {10, 20, 30, 40, 55};
        Main.actualizarInventario(inventarioOriginal, -1, 20);
        assertArrayEquals(inventarioActu, inventarioOriginal2);
    }

    /* @Test
    void testActualizarInventarioConValorNegativo() {
        int[] inventarioOriginal = {10, 20, 30, 40, 55};
        int[] inventarioActu = {10, 20 ,30, 40, 0};
        Main.actualizarInventario(inventarioOriginal, 4, -56);
        assertArrayEquals(inventarioActu, inventarioOriginal);
    } */

    @Test
    void testCalcularTotal() {
        int[] inventario = {1, 2, 3, 4, 5};
        int[] inventario2 = {1, 2, 3, 0, -1};
        int[] inventario3 = { };
        int[] inventario4 = {1};
        int[] inventario5 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        assertEquals(15, Main.calcularTotal(inventario));
        assertNotEquals(13, Main.calcularTotal(inventario));

        // Suma con negativos
        assertEquals(5, Main.calcularTotal(inventario2));

        // Suma de un array vacío
        assertEquals(0, Main.calcularTotal(inventario3));

        // Suma de un único elemento
        assertEquals(1, Main.calcularTotal(inventario4));

        // Suma de multiples elementos
        assertEquals(20, Main.calcularTotal(inventario5));
    }

    @Test
    void testEncontrarProductoMasCaro() {
        int[] inventario = {10, 20, 30, 40, 50, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 60, 51};
        assertEquals(60, Main.encontrarProductoMasCaro(inventario));

        // Prueba con numeros del mismo valor
        int[] inventario1 = {5, 5, 5, 5, 5};
        assertEquals(5, Main.encontrarProductoMasCaro(inventario1));

        // Prueba con numeros negativos
        int[] inventario2 = {-5, -5, -5, -5, -5, -3};
        assertEquals(-3, Main.encontrarProductoMasCaro(inventario2));
    }
}
