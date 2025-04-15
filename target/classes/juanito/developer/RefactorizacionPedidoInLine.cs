public void ProcesarPedido(Pedido pedido)
{
    // Validar pedido
    if (pedido == null || pedido.Items.Count == 0)
    {
        throw new ArgumentException("Pedido inválido");
    }

    decimal total = pedido.Items.Sum(item => item.Precio * item.Cantidad);
    if (pedido.Cliente.EsVIP)
    {
        total *= 0.9m; // 10% de descuento
    }

    ActualizarInventario(pedido);
    RegistrarPedido(pedido, total);
    EnviarConfirmacion(pedido.Cliente.Email, total);
}

public void ActualizarInventario(Pedido pedido)
{
    // Actualizar inventario y registrar pedido
    foreach (var item in pedido.Items)
    {
        ActualizarInventario(item);
    }
}