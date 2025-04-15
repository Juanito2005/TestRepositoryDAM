public void AnalizarTexto(string texto)
{
    var palabras = texto.Split(' ', StringSplitOptions.RemoveEmptyEntries);

    // Se usan expresiones "LINQ" que básicamente son como las típicas consultas SQl
    // para iterar sobre colecciones de datos
    // Tuve que usarlas porque de otra forma, el código original no tenía nada que refectorizar
    Console.WriteLine($"Cantidad de palabras: {palabras.Length}");
    // Expresion LINQ ".Count"
    Console.WriteLine($"Cantidad de caracteres: {texto.Count(c => !char.IsWhiteSpace(c))}");
    // ".OrderByDescending" Es otra expresión LINQ que te ahorra líneas de código
    Console.WriteLine($"Palabra más larga: {palabras.OrderByDescending(p => p.Length).FirstOrDefault() ?? ""}");
    // Al final las expresiones LINQ son como un lenguaje declarativo en el que le dices "que" quieres
    // Y las estructuras de toda la vida son un lenguaje imperativo en el que le dices "como" lo quieres
}
