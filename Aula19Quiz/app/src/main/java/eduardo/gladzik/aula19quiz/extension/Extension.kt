package eduardo.gladzik.aula19quiz.extension

import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.media.Image
import android.media.MediaPlayer
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.widget.Toast
import eduardo.gladzik.aula19quiz.R
import eduardo.gladzik.aula19quiz.model.Quiz

private lateinit var context: Context
private lateinit var mediaPlayer: MediaPlayer

fun Activity.toast(message: String) {
    Toast.makeText(baseContext, message, Toast.LENGTH_LONG).show()
}

fun Activity.toast(message: Int) {
    Toast.makeText(baseContext, getText(message), Toast.LENGTH_LONG).show()
}

fun Activity.vibrate() {
    val pattern = longArrayOf(0, 300)

    val hardware = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

    hardware?.let {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            hardware.vibrate(VibrationEffect.createWaveform(pattern, -1))
        }
    }
}

fun Activity.play(context: Context, sound: Int) {
    mediaPlayer = MediaPlayer.create(context, sound)
    mediaPlayer.start()
}

fun Activity.getScore(): String {
    return "${getText(R.string.finalactivity_text_final_score)} ${Quiz.score()}"
}