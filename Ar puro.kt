fun main() {
    val orcamentos = mutableListOf<Pair<String, Double>>()

    do {
        println("Qual o nome da empresa?")
        val nomeEmpresa = readLine() ?: ""

        println("Qual o valor por aparelho?")
        val valorPorAparelho = readLine()?.toDoubleOrNull() ?: 0.0

        println("Qual a quantidade de aparelhos?")
        val quantidadeAparelhos = readLine()?.toIntOrNull() ?: 0

        println("Qual a porcentagem de desconto?")
        val porcentagemDesconto = readLine()?.toDoubleOrNull() ?: 0.0

        println("Qual o número mínimo de aparelhos para conseguir o desconto?")
        val quantidadeMinimaParaDesconto = readLine()?.toIntOrNull() ?: 0

        val total = calcularValorTotal(
            valorPorAparelho,
            quantidadeAparelhos,
            porcentagemDesconto,
            quantidadeMinimaParaDesconto
        )

        println("O serviço de $nomeEmpresa custará R$ ${"%.2f".format(total)}")
        orcamentos.add(nomeEmpresa to total)

        println("Deseja informar novos dados? (S/N)")
    } while (readLine()?.uppercase() == "S")

    val menorOrcamento = orcamentos.minByOrNull { it.second }

    println("O orçamento de menor valor é o de ${menorOrcamento?.first} por R$ ${"%.2f".format(menorOrcamento?.second)}")
}

fun calcularValorTotal(
    valorPorAparelho: Double,
    quantidadeAparelhos: Int,
    porcentagemDesconto: Double,
    quantidadeMinimaParaDesconto: Int
): Double {
    val valorSemDesconto = valorPorAparelho * quantidadeAparelhos
    return if (quantidadeAparelhos >= quantidadeMinimaParaDesconto) {
        valorSemDesconto * (1 - porcentagemDesconto / 100)
    } else {
        valorSemDesconto
    }
}
