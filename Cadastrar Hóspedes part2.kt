val hospedes = mutableListOf<String>()

fun main(){

 while(true){
     println(
         """
     --- Menu ---
     1 - Cadastrar
     2 - Pesquisar
     3 - Listar
     4 - Sair 
     Escolha uma opção:
     """.trimIndent()//função p tirar os espaços no começo do código
       )
 val opcao = readln().toIntOrNull()

 when (opcao){
     1 -> cadastrarHospede()
     2 -> pesquisarHospede()
     3 -> listarHospede()
     4 -> {
         println("Saindo do sistema... foi um prazer tê-lo conosco.")
         break
     }
     else -> println ("Opção inválida! Tente novamente.")
     }
   }
 }

fun cadastrarHospede() {

    if (hospedes.size >= 15) {
        println("Máximo de cadastros atingido.")
        return
    }
    println("Informe o nome do hóspede:")
    val nome = readln().trim().uppercase() //.trim() tira os espaçamento no começo e no fim

    if (nome.isBlank() || nome.toDoubleOrNull() != null) {
        println("Por favor, insira um nome válido !")
        return
    }
    hospedes.add(nome)
    println("Hóspede $nome cadastrado com sucesso!")
}

fun pesquisarHospede(){

    if(hospedes.isEmpty()){
        println("Nenhum hóspede cadastrado até o momento.")
        return
    }
    println("Informe o nome do hóspede que deseja pesquisar:")
    val nomePesquisa = readln().trim().uppercase()

    if (hospedes.any {it.uppercase() == nomePesquisa}) {
        println("Hóspede $nomePesquisa foi encontrado.")
    } else {
        println("Hóspede $nomePesquisa não foi encontrado.")
    }
}

fun listarHospede(){
if (hospedes.isEmpty()) {
    println("Nenhum hóspede cadastrado até o momento.")
    return
}

   println("Lista de Hóspedes:")
   hospedes.forEachIndexed { index, nome ->
    println("${index + 1}. $nome")
 }
}
