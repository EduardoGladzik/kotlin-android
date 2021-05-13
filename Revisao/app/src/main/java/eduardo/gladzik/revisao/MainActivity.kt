package eduardo.gladzik.revisao

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val dialButton by lazy { findViewById<Button>(R.id.dialButton) }
    private val studentButton by lazy { findViewById<Button>(R.id.studentButton) }
    private val squareButton by lazy { findViewById<Button>(R.id.squareButton) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dialButton.setOnClickListener(this@MainActivity)

        studentButton.setOnClickListener(this@MainActivity)

        squareButton.setOnClickListener(this@MainActivity)
    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            R.id.dialButton -> {
                val intent = Intent(this@MainActivity, DialScreen::class.java)
                startActivity(intent)
            }
            R.id.studentButton -> {
                val intent = Intent(this@MainActivity, StudentScreen::class.java)
                startActivity(intent)
            }
            R.id.squareButton -> {
                val intent = Intent(this@MainActivity, SquareScreen::class.java)
                startActivity(intent)
            }
        }
    }


}