package eduardo.gladzik.dices

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.*

class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var buttonNext: Button
    private lateinit var buttonToastd20: Button
    private lateinit var buttonToastd12: Button
    private lateinit var buttonToastd10: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializer()

        val actionBar = supportActionBar
        actionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.title = "Rolling dices"
        }

        buttonNext.setOnClickListener {

            val intent = Intent(this@MainActivity, RollingDices::class.java)
            startActivity(intent)
        }

        buttonToastd20.setOnClickListener {
            val random = (1..20).random()

            val response = if (random >= 15) {
                                "Amazing, ${getText(R.string.you_threw)} $random ${getText(R.string.on_the_dices)}"
                            } else if (random >= 10) {
                                "Nice, ${getText(R.string.you_threw)} $random ${getText(R.string.on_the_dices)}"
                            } else {
                                "This is bad, ${getText(R.string.you_threw)} $random ${getText(R.string.on_the_dices)}"
                            }
            Toast.makeText(baseContext, response, Toast.LENGTH_LONG).show()
            play(R.raw.dices)
            vibrate()
        }

        buttonToastd12.setOnClickListener {
            val random = (1..12).random()

            val response = if (random >= 10) {
                                "Amazing, ${getText(R.string.you_threw)} $random ${getText(R.string.on_the_dices)}"
                            } else if (random >= 5) {
                                "Nice, ${getText(R.string.you_threw)} $random ${getText(R.string.on_the_dices)}"
                            } else {
                                "This is bad, ${getText(R.string.you_threw)} $random ${getText(R.string.on_the_dices)}"
                            }

            Toast.makeText(baseContext, response, Toast.LENGTH_LONG).show()
            play(R.raw.dices)
            vibrate()
        }

        buttonToastd10.setOnClickListener {
            val random = (1..10).random()

            val response = if (random >= 7) {
                                "Amazing, ${getText(R.string.you_threw)} $random ${getText(R.string.on_the_dices)}"
                            } else if (random >= 5) {
                                "Nice, ${getText(R.string.you_threw)} $random ${getText(R.string.on_the_dices)}"
                            } else {
                                "This is bad, ${getText(R.string.you_threw)} $random ${getText(R.string.on_the_dices)}"
                            }

            Toast.makeText(baseContext, response, Toast.LENGTH_LONG).show()
            play(R.raw.dices)
            vibrate()
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun initializer() {
        buttonNext = findViewById(R.id.button_next)
        buttonToastd20 = findViewById(R.id.button_d20)
        buttonToastd12 = findViewById(R.id.button_d12)
        buttonToastd10 = findViewById(R.id.button_d10)
    }

    private fun vibrate() {
        val pattern = longArrayOf(0, 300)

        val hardware = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        hardware?.let {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                hardware.vibrate(VibrationEffect.createWaveform(pattern, -1))
            }
        }
    }

    private fun play(sound: Int) {
        mediaPlayer = MediaPlayer.create( this@MainActivity, sound)
        mediaPlayer.start()
    }
}