package eduardo.gladzik.dices.model

class Character(val name: String, val age: Int) {

    fun calculateRings(): Int {
        return this.age * 4
    }

    override fun toString(): String {
        return "Congratulations, ${this.name}, you passed by ${this.calculateRings()} rings!"
    }


}