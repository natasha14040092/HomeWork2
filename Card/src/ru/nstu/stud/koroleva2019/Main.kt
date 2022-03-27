package ru.nstu.stud.koroleva2019

fun strCardArray(cardArray: Array<Card>): String {
    var strCardArray = "[  "
    for (card in cardArray) {
        strCardArray += "$card  "
    }

    return "$strCardArray]"
}

fun test() {
    println("Test creating card: \n")
    println("card0: ")
    val card0 = Card(15, Suits.CLUBS)
    card0.printCard()

    println()
    println("card1: ")
    val card1 = Card(16, Suits.CLUBS)
    card1.printCard()

    println()
    println("card2: ")
    val card2 = Card(2, Suits.CLUBS)
    card2.printCard()

    println()
    println("""Test equals():
        |
        |$card1 == $card2 ? 
        |${card1 == card2}
        |
        |$card0 == $card2 ? 
        |${card0 == card2}
    """.trimMargin())

    val card3 = Card(3, Suits.CLUBS)

    println()
    println("""Test isStronger():
        |
        |$card1 > $card2 ? 
        |${card1.isStronger(card2)}
        |
        |$card0 > $card2 ? 
        |${card0.isStronger(card2)}
        |
        |$card3 > $card2 ? 
        |${card3.isStronger(card2)}
    """.trimMargin())

    println()
    println("test compareTo(): ")
    val cardArray = arrayOf(card0, card1, card2, card3)

    println(strCardArray(cardArray))
    cardArray.sort()
    println("Array after sort: ${strCardArray(cardArray)}")

}

fun main() {
    test()
}