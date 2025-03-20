fun main() {


    val hospedes = mutableListOf<Pair<String, Int>>()
    val valorDiaria = 50.5

    while (true) {
        println("Qual o nome do hóspede? (OU PARE PARA FINALIZAR)")
        val nome = readLine() ?: ""
        if (nome.isBlank() || nome.toDoubleOrNull() != null){
            println("Por favor, insira um nome válido !")
            continue
        }

        if (nome.uppercase() == "PARE") break

        println("Digite a idade de $nome: ")

        val idade = readLine()?.toIntOrNull()
        if (idade == null) {
            println("Idade inválida! Por favor, insira um número inteiro.")
            continue
        }

        when {
            idade < 6 -> println("O hóspede $nome possui gratuidade.")
            idade > 60 -> println("O hóspede $nome paga meia.")
            else -> println("O hóspede $nome paga a diária inteira.")
        }

        hospedes.add(nome to idade)

    }

    var qtdGratuidades = 0
    var qtdMeiasHospedagens = 0
    var valorTotal = 0.0

    for ((_, idade) in hospedes){
        when{
            idade < 6 -> qtdGratuidades++
            idade > 60 -> {
                qtdMeiasHospedagens++
                valorTotal += valorDiaria / 2
            }
            else -> valorTotal += valorDiaria
        }
    }

    println("Resumo da hospedagem:")
    println("Quantidade de gratuidades: $qtdGratuidades")
    println("Quantidade de meis hospedagens: $qtdMeiasHospedagens")
    println("Valor total a ser pago: R$%.2f".format(valorTotal))
}
