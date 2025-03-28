fun main() {
    val numeroDeConvidados = definirConvidados()

    if (numeroDeConvidados > 0) {
        escolherAuditorio(numeroDeConvidados)
        reservaPrincipal()
        calcularGarcons(numeroDeConvidados)
        calcularBuffet(numeroDeConvidados)
        confirmarReserva("Auditório Colorado", "Mak", numeroDeConvidados, 5, 1417.50, 822.00)
    }
}

fun definirConvidados(): Int {
    var numeroDeConvidados: Int? = null

    while (numeroDeConvidados == null || numeroDeConvidados <= 0 || numeroDeConvidados > 350) {
        println("Digite o número de convidados para o evento (entre 0 e 350):")
        numeroDeConvidados = readLine()?.toIntOrNull()

        if (numeroDeConvidados == null || numeroDeConvidados <= 0 || numeroDeConvidados > 350) {
            println("Número de convidados inválido. Tente novamente.")
        }
    }

    return numeroDeConvidados
}

fun escolherAuditorio(numeroDeConvidados: Int) {
    val capacidadeLaranja = 150
    val capacidadeLaranjaAdicional = 70

    if (numeroDeConvidados <= capacidadeLaranja + capacidadeLaranjaAdicional) {
        println("O auditório mais adequado é o Laranja.")
        if (numeroDeConvidados > capacidadeLaranja) {
            val cadeirasExtras = numeroDeConvidados - capacidadeLaranja
            println("Serão necessárias $cadeirasExtras cadeiras adicionais.")
        }
    } else {
        println("O auditório mais adequado é o Colorado.")
    }
}

fun reservaPrincipal() {
    println("Digite o dia da semana (sem acentos):")
    val diaDaSemana = readLine()?.lowercase()

    println("Digite a hora do evento (apenas o número inteiro, entre 0 e 23):")
    val hora = readLine()?.toIntOrNull()

    if (hora == null || hora < 0 || hora > 23) {
        println("Hora inválida.")
        return
    }

    val disponivel = reservaAuditorio(diaDaSemana, hora)

    if (disponivel) {
        println("Digite o nome da empresa que está reservando:")
        val nomeDaEmpresa = readLine()
        println("Auditório reservado para $nomeDaEmpresa: $diaDaSemana às ${hora}hs")
    } else {
        println("O auditório não está disponível no(a) $diaDaSemana às ${hora}hs.")
        return
    }
}

fun reservaAuditorio(diaDaSemana: String?, hora: Int): Boolean {
    return when (diaDaSemana) {
        "segunda", "terca", "quarta", "quinta", "sexta" -> hora in 7..23
        "sabado", "domingo" -> hora in 7..15
        else -> false
    }
}

fun calcularGarcons(numeroDeConvidados: Int) {
    println("Qual a duração do evento em horas? (lembrando que dia de semana é das 07:00hrs às 23:00hrs e fim de semana das 07:00hrs às 15:00hrs.")
    val duracaoEvento = readLine()?.toIntOrNull()

    if (duracaoEvento == null || duracaoEvento <= 0) {
        println("Duração do evento inválida.")
        return
    }

    val garconsBase = kotlin.math.ceil(numeroDeConvidados / 12.0).toInt()
    val garconsAdicionais = duracaoEvento / 2
    val totalGarcons = garconsBase + garconsAdicionais

    val custoPorHora = 10.50
    val custoTotal = totalGarcons * duracaoEvento * custoPorHora

    println("São necessários $totalGarcons garçons.")
    println("Custo: R$ ${"%.2f".format(custoTotal)}")
    println("Agora vamos calcular o custo do buffet do hotel para o evento.")

    calcularBuffet(numeroDeConvidados)
}

fun calcularBuffet(numeroDeConvidados: Int) {
    val cafeLitros = numeroDeConvidados * 0.2
    val aguaLitros = numeroDeConvidados * 0.5
    val salgadosUnidades = numeroDeConvidados * 7

    val custoCafe = cafeLitros * 0.80
    val custoAgua = aguaLitros * 0.40
    val custoSalgados = kotlin.math.ceil(salgadosUnidades / 100.0).toInt() * 34.0

    val custoTotal = custoCafe + custoAgua + custoSalgados

    println("Quantidade de café necessária: ${"%.2f".format(cafeLitros)} litros.")
    println("Quantidade de água necessária: ${"%.2f".format(aguaLitros)} litros.")
    println("Quantidade de salgados necessária: $salgadosUnidades unidades.")
    println("Custo total do buffet: R$ ${"%.2f".format(custoTotal)}")
}

fun confirmarReserva(
    auditorio: String,
    empresa: String,
    convidados: Int,
    duracao: Int,
    custoGarcons: Double,
    custoBuffet: Double
) {
    val custoTotal = custoGarcons + custoBuffet
    println("\n--- Relatório do Evento ---")
    println("Auditório: $auditorio")
    println("Empresa: $empresa")
    println("Quantidade de Convidados: $convidados")
    println("Duração do Evento: $duracao horas")
    println("Custo dos garçons: R$ ${"%.2f".format(custoGarcons)}")
    println("Custo do buffet: R$ ${"%.2f".format(custoBuffet)}")
    println("Custo Total: R$ ${"%.2f".format(custoTotal)}")

    println("\nGostaria de efetuar a reserva? (S/N)")
    when (readLine()?.uppercase()) {
        "S" -> println("Reserva efetuada com sucesso!")
        "N" -> println("Reserva não efetuada.")
        else -> println("Opção inválida. Reserva não efetuada.")
    }
}
