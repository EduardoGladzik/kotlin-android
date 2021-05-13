package eduardo.gladzik.revisao.model

class Student(var name: String?, var grade1: Double, var grade2: Double){

    fun calculateAvarage(): Double {
        return (this.grade1 + this.grade2) / 2
    }

    fun verifyStudent(): String {
        if (calculateAvarage() >= 7) {
            return "Congratulations $name you're approved"
        }
        return "Sorry $name you're disapproved"
    }

    override fun toString(): String {
        return "Student(name='$name', grade1=$grade1, grade2=$grade2)"
    }
}