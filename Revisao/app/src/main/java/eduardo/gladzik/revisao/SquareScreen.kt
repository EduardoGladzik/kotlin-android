package eduardo.gladzik.revisao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.view.contains
import eduardo.gladzik.revisao.model.Square

class SquareScreen : AppCompatActivity() {

    private val textSquare by lazy { findViewById<EditText>(R.id.textSquareSide) }
    private val spinnerSquare by lazy { findViewById<Spinner>(R.id.spinnerSquare) }
    private val buttonSquare by lazy { findViewById<Button>(R.id.buttonCalculate) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_square_screen)

        buttonSquare.setOnClickListener {
            val square = Square(textSquare.text.toString().toDouble())
            val alert = AlertDialog.Builder(this)
            val spinner = spinnerSquare.selectedItem.toString()

            if (spinner.contains("Area")) {
                alert.setMessage("The result is ${square.calculateArea()}")
                alert.setNeutralButton(getText(R.string.neutral_button), null)
                alert.show()
            } else if (spinner.contains("Perimeter")) {
                alert.setMessage("The result is ${square.calculatePerimeter()}")
                alert.setNeutralButton(getText(R.string.neutral_button), null)
                alert.show()
            } else {
                alert.setMessage("Area: ${square.calculateArea()} \nPerimeter: ${square.calculatePerimeter()}")
                alert.setNeutralButton(getText(R.string.neutral_button), null)
                alert.show()
            }
        }
    }
}