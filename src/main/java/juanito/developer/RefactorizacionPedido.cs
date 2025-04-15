// Extract method
// Enfoque esto como si fuera una clase Servicio
// public class ProcesarPedidoService { }
/* Y respecto a la lógica, decidí separar las responsabilidades en varios metodos
    y dejar público solo el método que las demás clases van a usar
    y dejar privados los metodos que las demás clases no deberían usar
    para seguir el principio de encapsulamiento*/

public void ProcesarPedido(Pedido pedido)
{
    ValidarPedido(pedido);

    decimal total = CalcularTotal(pedido);

    ActualizarInventario(pedido);

    RegistrarPedido(pedido, total);

    EnviarConfirmacion(pedido, total);
}

private void ValidarPedido(Pedido pedido)
{
    if (pedido == null)
        throw new ArgumentNullException(nameof(pedido));
    if (pedido.Items == null || !pedido.Items.Any())
        throw new InvalidOperationException("El pedido no tiene items");
}

private decimal CalcularTotal(Pedido pedido)
{
    decimal total = pedido.Items.Sum(item => item.Precio * item.Cantidad);

    if (pedido.Cliente.EsVIP)
        total *= 0.9m; // 10% de descuento

    return decimal.Round(total, 2);
}

private void ActualizarInventario(Pedido pedido)
{
    foreach (var item in pedido.Items)
    {
        var producto = inventario.ObtenerProducto(item.ProductoId);
        if (producto.Stock < item.Cantidad)
            throw new InvalidOperationException($"Stock insuficiente para el producto {producto.Nombre}");

        producto.Stock -= item.Cantidad;
        inventario.ActualizarProducto(producto);
    }
}

private void RegistrarPedido(Pedido pedido, decimal total)
{
    pedido.Total = total;
    pedido.FechaProcesamiento = DateTime.Now;
    baseDeDatos.GuardarPedido(pedido);
}

private void EnviarConfirmacion(Pedido pedido, decimal total)
{
    string mensaje = $"Su pedido por {total:C} ha sido procesado.";
    emailService.EnviarEmail(pedido.Cliente.Email, "Confirmación de pedido", mensaje);
}
