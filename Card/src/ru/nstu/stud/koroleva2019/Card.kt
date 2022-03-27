package ru.nstu.stud.koroleva2019

class Card(rank: Int, suit: Suits) : Comparable<Card?> {
    private val MIN_RANK = 2
    private val MAX_RANK = 15

    private val rank: Int
    private val suit: Suits

    init {
        this.rank = enterRank(rank)
        this.suit = getValidSuit(suit)
    }

    private fun getValidSuit(suit: Suits): Suits {
        return if ((this.rank == 15) && (suit != Suits.BLACK) && (suit != Suits.RED)) {
            println("""Your rank number: $rank, it's a Joker. 
                    |Two suits are available for the Joker: BLACK or RED.
                    |BLACK is selected.""".trimMargin())
            Suits.BLACK
        } else suit
    }

    private fun enterRank(rank: Int): Int {
        return if (rank in MIN_RANK..MAX_RANK) rank
        else {
            println("""Your rank number: $rank,
                |The entered rank number must be >= 2 and <= 15.
                |Rank 2 is selected.""".trimMargin())
            2
        }
    }

    fun printCard() = println("${toStringRank()} $suit")

    private fun toStringRank(): String {
        return when (rank) {
            11 -> "Jack"
            12 -> "Queen"
            13 -> "King"
            14 -> "Ace"
            15 -> "Joker"
            else -> rank.toString()
        }
    }

    fun getRankInt() = rank

    fun getStringRank() = toStringRank()

    fun getSuits() = suit

    override fun toString() = "${toStringRank()} $suit"

    override fun equals(other: Any?) =
        (other is Card) && (this.rank == other.rank) && (this.suit == other.suit)

    override fun hashCode() = 10 * rank + suit.ordinal

    fun isStronger(card: Card?) =
        (card != null) && (suit == card.suit) && (rank > card.rank)

    override fun compareTo(other: Card?): Int {
        return when {
            other == null -> -1
            rank == other.rank -> suit.ordinal - other.suit.ordinal
            else -> rank - other.rank
        }
    }

    //public static int compare(CardB card1, CardB card2) 
}