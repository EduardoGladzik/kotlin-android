package eduardo.gladzik.prova.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import eduardo.gladzik.prova.R

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val buttonCalculatorScreen by lazy { findViewById<Button>(R.id.buttonGoToCalculatorScreen) }
    private val buttonRandomScreen by lazy { findViewById<Button>(R.id.buttonGoToRandomScreen) }
    private val buttonAbout by lazy { findViewById<Button>(R.id.buttonAbout) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculatorScreen.setOnClickListener(this@MainActivity)
        buttonRandomScreen.setOnClickListener(this@MainActivity)
        buttonAbout.setOnClickListener(this@MainActivity)
    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            R.id.buttonGoToCalculatorScreen -> {
                val intent = Intent(this@MainActivity, CalculatorScreen::class.java)
                startActivity(intent)
            }
            R.id.buttonGoToRandomScreen -> {
                val intent = Intent(this@MainActivity, RandomScreen::class.java)
                startActivity(intent)
            }
            R.id.buttonAbout -> {
                val intent = Intent(this@MainActivity, AboutScreen::class.java)
                startActivity(intent)
            }
        }
    }


}