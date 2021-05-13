package eduardo.gladzik.revisao.model

class Square(var side: Double) {

    fun calculateArea(): Double {
        return side*2
    }

    fun calculatePerimeter(): Double {
        return side*4
    }

    override fun toString(): String {
        return "Square(side=$side)"
    }
}