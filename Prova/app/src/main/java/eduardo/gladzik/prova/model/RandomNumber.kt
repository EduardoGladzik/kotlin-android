package eduardo.gladzik.prova.model

class RandomNumber {

    companion object {
        fun generateRandomNumber(): Int {
            return (0..1000).random()
        }
    }
}