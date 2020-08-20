package eduardo.gladzik.dices

import android.content.Context
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.widget.Button
import android.widget.Toast

class RollingDices : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var buttonToastd8: Button
    private lateinit var buttonToastd6: Button
    private lateinit var buttonToastd4: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rolling_dices)

        initializer()

        val actionBar = supportActionBar
        actionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.title = "Rolling dices"
        }

        buttonToastd8.setOnClickListener {
            val random = (1..8).random()

            val response = if (random >= 7) {
                                "Amazing, ${getText(R.string.you_threw)} $random ${getText(R.string.on_the_dices)}"
                            } else if (random >= 4) {
                                "Nice, ${getText(R.string.you_threw)} $random ${getText(R.string.on_the_dices)}"
                            } else {
                                "This is bad, ${getText(R.string.you_threw)} $random ${getText(R.string.on_the_dices)}"
                            }
            Toast.makeText(baseContext, response, Toast.LENGTH_LONG).show()
            play(R.raw.dices)
            vibrate()
        }

        buttonToastd6.setOnClickListener {
            val random = (1..6).random()

            val response = if (random >= 5) {
                                "Amazing, ${getText(R.string.you_threw)} $random ${getText(R.string.on_the_dices)}"
                            } else if (random >= 3) {
                                "Nice, ${getText(R.string.you_threw)} $random ${getText(R.string.on_the_dices)}"
                            } else {
                                "This is bad, ${getText(R.string.you_threw)} $random ${getText(R.string.on_the_dices)}"
                            }
            Toast.makeText(baseContext, response, Toast.LENGTH_LONG).show()
            play(R.raw.dices)
            vibrate()
        }

        buttonToastd4.setOnClickListener {
            val random = (1..4).random()

            val response = if (random >= 3) {
                                "Amazing, ${getText(R.string.you_threw)} $random ${getText(R.string.on_the_dices)}"
                            } else if (random >= 2) {
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
        buttonToastd8 = findViewById(R.id.buttond8)
        buttonToastd6 = findViewById(R.id.buttond6)
        buttonToastd4 = findViewById(R.id.buttond4)
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
        mediaPlayer = MediaPlayer.create( this@RollingDices, sound)
        mediaPlayer.start()
    }
}