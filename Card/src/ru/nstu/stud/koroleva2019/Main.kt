package ru.nstu.stud.koroleva2019

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
    println("card11: ")
    val card11 = Card()
    card11.printCard()

    println()
    println("""Test equals():
        |
        |$card1 == $card2 ? 
        |${card1 == card2}
        |
        |$card0 == $card2 ? 
        |${card0 == card2}
        |
        |$card2 == null ? 
        |${card2.equals(null)}
        |
        |
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
    //неизменяемый массив
    val cardArray = arrayOf(card0, card1, card2, card3)
    println(cardArray.joinToString(prefix = "[", postfix = "]"))

    //а как он тогда сортирует immutable array?????????????????????????
    //в интернетах пишут, что такое возможно только для mutable,
    //а для immutable он только возвращает новый отсортированный... ладно......
    cardArray.sort()
    println("Array after sort: ${cardArray.joinToString(prefix = "[", postfix = "]")}")

    println()
    println("test \"static\" compare(): ")
    println("$card3 > $card2 ?")
    println("${Card.compare(card3, card2)}")
}

fun main() {
    test()
}