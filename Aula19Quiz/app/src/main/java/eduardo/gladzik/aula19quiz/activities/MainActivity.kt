package eduardo.gladzik.aula19quiz.activities

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import eduardo.gladzik.aula19quiz.R
import eduardo.gladzik.aula19quiz.extension.play
import eduardo.gladzik.aula19quiz.extension.vibrate
import eduardo.gladzik.aula19quiz.model.Quiz
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Quiz.context = this@MainActivity
        Quiz.clearAll()
        play(this@MainActivity, R.raw.sound)
        mainActivityButtonStart.setOnClickListener { startActivity(Intent(this@MainActivity, Activity1::class.java))
            vibrate()}
    }
}

