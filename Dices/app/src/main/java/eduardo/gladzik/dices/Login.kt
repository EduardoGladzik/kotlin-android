package eduardo.gladzik.dices

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import eduardo.gladzik.dices.model.Character
import kotlinx.android.synthetic.main.activity_login.*

@Suppress("SENSELESS_COMPARISON")
class Login : AppCompatActivity() {

    private lateinit var buttonLogin: Button
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var soundButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initializer()

        play()

        soundButton.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.stop()
            } else {
                play()
            }
        }

        buttonLogin.setOnClickListener {

            val name = textName.text.toString()
            val age = textAge.text.toString().toInt()
            val character = Character(name, age)

            if(name == null || age == null) {
                println("invalid name or age")
            }

            Toast.makeText(baseContext, character.toString(), Toast.LENGTH_LONG).show()

            val intent = Intent(this@Login, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initializer() {
        buttonLogin = findViewById(R.id.button)
        soundButton = findViewById(R.id.soundButton)
    }

    private fun play() {
        mediaPlayer = MediaPlayer.create(this@Login, R.raw.music)
        mediaPlayer.start()
        mediaPlayer.isLooping
    }
}