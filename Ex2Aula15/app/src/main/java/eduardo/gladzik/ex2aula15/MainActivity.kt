package eduardo.gladzik.ex2aula15

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val spinnerGender by lazy { findViewById<Spinner>(R.id.spinnerGender) }
    private val buttonSpinner by lazy { findViewById<Button>(R.id.buttonChoose) }
    private val layout by lazy { findViewById<ConstraintLayout>(R.id.layout) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val person = Person("Eduardo", "Gladzik", this@MainActivity)
//
//        Toast.makeText(baseContext, person.toString(), Toast.LENGTH_LONG).show()
//        Toast.makeText(baseContext, person.getFullname(), Toast.LENGTH_LONG).show()

        toast("${user}")

        buttonSpinner.setOnClickListener(this@MainActivity)

        spinnerGender.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {}

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if(p2 != 0) {
                    val gender = spinnerGender.getItemAtPosition(p2).toString()
                    toast("You selected $gender")
                }
            }
        }
    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            R.id.buttonChoose -> {
                val gender = spinnerGender.selectedItem.toString()
                if(spinnerGender.selectedItemPosition == 0) {
                    toast("Select a gender")
                    layout.setBackgroundColor(getColor(R.color.red))
                    return
                }
                layout.setBackgroundColor(getColor(R.color.colorAccent))
                toast("You selected $gender")
            }
        }
    }

    private fun toast(message: String) {
        Toast.makeText(baseContext, message, Toast.LENGTH_LONG).show()
    }
}