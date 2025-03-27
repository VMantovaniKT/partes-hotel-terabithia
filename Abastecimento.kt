fun abastecimento (){

    println("Digite o preço do álcool no Wayne Oil: ")
    var AW = readln().toDouble()

    println("Digite o preço da gasolina no Wayne Oil: ")
    var GW = readln().toDouble()

    println("Digite o preço do álcool no Stark Petrol: ")
    var AS = readln().toDouble()

    println("Digite o preço da gasolina no Stark Petrol: ")
    var GS = readln().toDouble()


    val custoWayne = if (AW < GW * 0.7){
        println("No Wayne Oil, o álcool é mais vantajoso!")
        AW * 42
    }else{
        println("No Wayne Oil, a gasolina é mais vantajosa!")
        GW * 42
    }

    val custoStark = if (AS < GS * 0.7){
        println("No Stark Petrol, o álcool é mais vantajoso!")
        AS * 42
    }else{
        println("No Stark Petrol, a gasolina é mais vantajosa!")
        GS * 42
    }


    if (custoWayne < custoStark) {
        println("O posto mais vantajoso é o Wayne Oil, com custo total de R$ $custoWayne.")
    } else {
        println("O posto mais vantajoso é o Stark Petrol, com custo total de R$ $custoStark.")
    }
}