package eduardo.gladzik.exaula13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class Screen1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen1)

        val something = intent.getStringExtra("something")

        Toast.makeText(baseContext, "Something: ${something}", Toast.LENGTH_LONG).show()
    }
}