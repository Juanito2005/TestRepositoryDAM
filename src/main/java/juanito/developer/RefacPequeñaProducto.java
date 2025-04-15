// ------------------------------------------- a. codigo i
// Refactorización eliminar variables globales y autoencapsular campos

public class Calculadora {
    public int sumar(int a, int b) {
        int resultado = a + b;
        imprimir(resultado);
        return resultado;
    }

    private void imprimir(int resultado) {
        System.out.println("Resultado: " + resultado);
    }
}
// ------------------------------------------- codigo ii

public class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public double getPrecioConIVA() {
        return precio * 1.21;
    }
}


public class Factura
{
    public void imprimirPrecioConIVA(Producto p)
    {
        System.out.println(p.getNombre() + ": " + p.getPrecioConIVA());
    }
}

// ------------------------------------------- b. codigo i

//Reemplazar condicionales con polimorfismo

public abstract class Vehiculo {
    public abstract void mover();
}

public class Coche extends Vehiculo {
    @Override
    public void mover() {
        System.out.println("Rodando...");
    }
}

public class Barco extends Vehiculo {
    @Override
    public void mover() {
        System.out.println("Navegando...");
    }
}

// Metodo Main teorico para ejecutarlo

/* public class Main {
    public static void main(String[] args) {
        Vehiculo miCoche = new Coche();
        Vehiculo miBarco = new Barco();

        miCoche.mover();  // Imprime: Rodando...
        miBarco.mover();  // Imprime: Navegando...
    }
} */

// ------------------------------------------- c. codigo i

public class Usuario {
    private static final int MAYORIA_DE_EDAD = 18; // Constante extraída
    private int edad; // Campo privado

    public void setEdad(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public void imprimir() {
        if (edad > MAYORIA_DE_EDAD) {
            System.out.println("Usuario mayor de edad");
        }
    }
}
