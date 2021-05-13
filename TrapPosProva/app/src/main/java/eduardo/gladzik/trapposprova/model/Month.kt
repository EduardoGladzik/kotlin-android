package eduardo.gladzik.trapposprova.model

import android.content.Context
import eduardo.gladzik.trapposprova.R

class Month(var monthNumber: Int?, var context: Context) {

    fun verifyMonthNumber(): String? = when (this.monthNumber) {
        in 1..12 -> "\"$monthNumber\" ${context.getString(R.string.number_equals_to)}: ${context.resources.getStringArray(
            R.array.months
        )[monthNumber!! -1]}."
        else -> context.getString(R.string.invalid_number)
    }
}

