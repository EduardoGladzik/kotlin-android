package eduardo.gladzik.prova.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import eduardo.gladzik.prova.R
import eduardo.gladzik.prova.model.Calculator

class CalculatorScreen : AppCompatActivity(), View.OnClickListener {

    private val textValue1 by lazy { findViewById<EditText>(R.id.textValue1) }
    private val textValue2 by lazy { findViewById<EditText>(R.id.textValue2) }
    private val spinnerCalculator by lazy { findViewById<Spinner>(R.id.spinnerCalculation) }
    private val buttonCalculate by lazy { findViewById<Button>(R.id.buttonCalculate) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator_screen)

        val actionBar = supportActionBar
        actionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.title = getString(R.string.calculator_title)
        }

        buttonCalculate.setOnClickListener(this@CalculatorScreen)
    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            R.id.buttonCalculate -> {
                val calculator = Calculator(textValue1.text.toString().toDouble(), textValue2.text.toString().toDouble(), this@CalculatorScreen)
                val spinner = spinnerCalculator.selectedItem.toString()
                

                if(textValue1.text.toString().isEmpty() || textValue2.text.toString().isEmpty())
                    toast("Valor(es) inválido(s)")

                if(spinner.contains("Choose")) {
                    toast(getString(R.string.text_choose_an_calculation))
                } else if(spinner.contains("Add")) {
                    toast("${getString(R.string.text_result)} ${calculator.add()}")
                } else if(spinner.contains("Subtract")) {
                    toast("${getString(R.string.text_result)} ${calculator.subtract()}")
                } else if(spinner.contains("Multiply")) {
                    toast("${getString(R.string.text_result)} ${calculator.multiply()}")
                } else {
                    toast("${getString(R.string.text_result)} ${calculator.divide()}")
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun toast(message: String) {
        Toast.makeText(baseContext, message, Toast.LENGTH_LONG).show()
    }
}