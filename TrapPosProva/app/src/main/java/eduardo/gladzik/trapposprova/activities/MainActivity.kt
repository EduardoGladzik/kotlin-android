package eduardo.gladzik.trapposprova.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import eduardo.gladzik.trapposprova.R
import eduardo.gladzik.trapposprova.model.Month

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val textNumber by lazy { findViewById<EditText>(R.id.textNumber) }
    private val textViewMonth by lazy { findViewById<TextView>(R.id.textViewMonth) }
    private val buttonSeeMonth by lazy { findViewById<Button>(R.id.buttonSeeMonth) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSeeMonth.setOnClickListener(this@MainActivity)
    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            R.id.buttonSeeMonth -> {
                val month = Month(textNumber.text.toString().toInt(), this@MainActivity)

                textViewMonth.text = month.verifyMonthNumber()
            }
        }
    }


}