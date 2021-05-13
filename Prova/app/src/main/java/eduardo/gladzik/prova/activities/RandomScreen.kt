package eduardo.gladzik.prova.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import eduardo.gladzik.prova.R
import eduardo.gladzik.prova.model.RandomNumber

class RandomScreen : AppCompatActivity(), View.OnClickListener {

    private val textRandomNumber by lazy { findViewById<TextView>(R.id.textRandomNumber) }
    private val buttonrandomize by lazy { findViewById<Button>(R.id.buttonRandomize) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_screen)

        val actionBar = supportActionBar
        actionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.title = getString(R.string.randomizer_title)
        }

        buttonrandomize.setOnClickListener(this@RandomScreen)
    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            R.id.buttonRandomize -> {
//                antes - estruturado
//                val random = (0..1000).random()
//                val response = "${getText(R.string.text_random_number)} $random"
//
//                textRandomNumber.text = response

//                agora - orientado a objeto
                textRandomNumber.text = RandomNumber.generateRandomNumber().toString()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}