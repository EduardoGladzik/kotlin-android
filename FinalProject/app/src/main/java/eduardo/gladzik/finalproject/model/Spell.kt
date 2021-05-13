package eduardo.gladzik.finalproject.model

import java.io.Serializable

data class Spell(val id: Int,
                 var characterName: String,
                 var name: String,
                 var range: Int,
                 var duration: String,
                 var level: Int,
                 var classes: String,
                 var casting: String): Serializable {

    override fun toString(): String {
        return "Spell(id='$id', characterName='$characterName', name='$name', range=$range, duration='$duration', level=$level, classes='$classes', casting='$casting')"
    }
}