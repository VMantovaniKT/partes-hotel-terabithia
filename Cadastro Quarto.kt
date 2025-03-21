import  kotlin.system.exitProcess

val quartos = Array(20) { false }
var hotel = "Noxus"
var nome: String = ""

fun main() {
    println("Qual o seu nome?")
     nome = readln()

    password()

    iniciar()
}

fun iniciar() {
    print("Bem vindo ao Hotel $hotel, $nome, é um imenso prazer ter você por aqui!")

    while (true) {
        println(
            """
          Escolha uma opção:
      
         1 - Cadastrar Quartos
         2 - Cadastrar Hospedes
         3 - Abastecer Automóveis
         4 - Sair
         
      """.trimIndent()
        )
        println("Escolha uma opção:")

        val escolha = readln().toIntOrNull()

        when (escolha) {
            1 -> cadastrarQuartos()
            2 -> cadastrarHospedes()
            3 -> AbastecimentoDeAutomoveis()
            4 -> sairDoHotel()
            else -> erro()
        }

    }
}
fun cadastrarQuartos() {

 val diaria = 50.5

    println("O valor da diaria é R$$diaria.Informe a quantidade de dias de hospedagem: ")
 val dias = readln().toIntOrNull()

    if (dias == null || dias <= 0 || dias > 30) {
        println("Valor Inválido. A quantidade de dias deve estar entre 1 e 30.")
        return
    }

    val total = diaria * dias
    println("O total para $dias dias de hospedagem será: R$$total.")

    println("Qual o nome do hóspede?")
    val hospede = readln().toString()

    while (true) {
        println("Informe o número do quarto que deseja (1 a 20):")
        val numeroQuarto = readln().toIntOrNull()


        if (numeroQuarto == null || numeroQuarto < 1 || numeroQuarto > 20) {
            println("Número de quarto inválido. Tente novamente.")
            continue
        }

        if (quartos[numeroQuarto - 1]) {
            println("Quarto já está ocupado. Por favor, escolha outro quarto.")
        } else {
            println("Quarto $numeroQuarto está disponível. Deseja confirmar a reserva? (Sim/Não)")
            val confirmacao = readln().lowercase()

            if (confirmacao == "sim") {
                println("Reserva confirmada para o hóspede $hospede no quarto $numeroQuarto!")
                quartos[numeroQuarto - 1] = true
                break
            } else if (confirmacao == "não") {
                println("Reserva não confirmada. Retornando ao menu inicial...")
                iniciar()
                return
            } else {
                println("Resposta inválida. Por favor, responda com 'Sim' ou 'Não'.")
            }
        }
    }
}


fun cadastrarHospedes(){

}

fun AbastecimentoDeAutomoveis() {

}

fun sairDoHotel() {
    println("Você deseja sair?\n Informe 1 para \"sim\" e 0 para \"não\"")
    val confirma = readln().toIntOrNull()
    if (confirma == 1) {
        println("Muito obrigado e até logo, $nome!")
        exitProcess(0) // Encerra o programa
    } else {
        println("Voltando ao menu...")
        iniciar()
    }
}

fun erro(){
    println("Por favor, informe um número entre 1 e 4.")
    iniciar()
}

fun password() {
    val senha = 2678

    println("Digite a senha para prosseguir:")
    val tentativa = readln().toInt()

    if (tentativa != senha) {
        println("Senha incorreta! Tente novamente.")
        password()
    } else {
        println("Senha correta! Acesso autorizado.")
    }
}