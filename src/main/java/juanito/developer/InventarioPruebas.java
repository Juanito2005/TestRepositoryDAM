package juanito.developer;
public class InventarioPruebas {
    public static void main(String[] args) {
        int[] inventario = {10, 20, 30, 40, 50};
        System.out.println("Total de inventario:" + calcularTotal(inventario));
        System.out.println("Producto mas caro:" + encontrarProductoMasCaro(inventario));
        actualizarInventario(inventario, 2,5);
        System.out.println("Inventario actualizado: " + java.util.Arrays.toString(inventario));
    }

    public static int calcularTotal(int[] inventario) {
        int total = 0;
        for (int i = 0; i < inventario.length; i++) {
            total += inventario[i];
        }
        return total;
    }

    public static int encontrarProductoMasCaro(int[] inventario) {
        int masCaro = inventario[0];
        for (int i = 0; i < inventario.length; i++) {
            if (inventario[i] > masCaro) {
                masCaro = inventario[i];
            }
        }
        return masCaro;
    }

    public static void actualizarInventario(int[] inventario, int indice, int cantidad) {
        if (indice >= 0 && indice < inventario.length) {
            inventario[indice] += cantidad;
            if (inventario[indice] < 0) {
                inventario[indice] = 0;
            }
        }
    }
}