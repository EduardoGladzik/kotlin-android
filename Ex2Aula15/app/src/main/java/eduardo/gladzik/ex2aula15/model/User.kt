package eduardo.gladzik.ex2aula15.model

import android.content.Context
import eduardo.gladzik.ex2aula15.R

class User(var name: String, var gender: String, val context: Context) {

    fun getUserName(): String {
        return "${context.getString(R.string.your_name_is)} $name"
    }

    override fun toString(): String {
        return "${context.getString(R.string.your_name_is)} $name, ${context.getString(R.string.your_gender_is)} $gender"
    }


}