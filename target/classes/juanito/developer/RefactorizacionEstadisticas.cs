// Extract method
public void CalcularEstadisticas(List<decimal> ventas)
{
    // Se añade una validación para informar a el usuario
    if (ventas == null || ventas.Count == 0)
    {
        Consolo.WriteLine("No hay ventas para calcular estadisticas");
        return;
    }

    decimal total = calcularTotalVentas(ventas);
    decimal promedio = calcularPromedioVentas(total);
    decimal maxVenta = EncontrarVentaMaxima(ventas);

    Console.WriteLine($"Total de Ventas: {total:C}");
    Console.WriteLine($"Promedio de Ventas: {promedio:C}");
    Console.WriteLine($"Venta Máxima: {maxVenta:C}");
}

// Calcular total de ventas
public decimal calcularTotalVentas(List<decimal> ventas)
{
    return ventas.Sum(); //Si ya existe una función que hace eso, para que crear otra?
}

// Calcular promedio de ventas
public decimal calcularPromedioVentas(decimal total, List<decimal> ventas)
{
    return total / ventas.Count;
}

// Encontrar la venta máxima
public var EncontrarVentaMaxima(List<decimal> ventas)
{
    return ventas.Max(); // Hay que aprovechar las herramientas que existen en el lenguaje y aplicar conceptos de programación funcional
}