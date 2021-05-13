package eduardo.gladzik.prova.model

import android.content.Context
import eduardo.gladzik.prova.R

class Calculator(var value1: Double, var value2: Double, val context: Context) {

    fun add(): Double? { return value1 + value2 }

    fun subtract(): Double? { return value1 - value2 }

    fun multiply(): Double? { return value1 * value2 }

    fun divide(): Double? { return value1 / value2 }

    override fun toString(): String {
        return "${context.getString(R.string.text_value_1)} $value1" +
                "\n${context.getString(R.string.text_value_2)} $value2"
    }


}