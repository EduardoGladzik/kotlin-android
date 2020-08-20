package eduardo.gladzik.aula19quiz.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import eduardo.gladzik.aula19quiz.R
import eduardo.gladzik.aula19quiz.extension.getScore
import eduardo.gladzik.aula19quiz.extension.vibrate
import eduardo.gladzik.aula19quiz.model.Quiz
import kotlinx.android.synthetic.main.activity_final.*

class FinalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        vibrate()
        finalImage()
        finalActivityTextViewFinalScore.text = getScore()
        finalActivityTextViewCorrectAnswers.text = "${getText(R.string.finalactivity_text_correct_answers)} ${Quiz.checkAvarageCorrectAnswers()}%"
        finalActivityTextViewFinalMessage.text = Quiz.finalMessage()

        finalActivityButtonPlayAgain.setOnClickListener {
            Quiz.clearAll()
            startActivity(Intent(this@FinalActivity, Activity1::class.java))
            finish()
        }
    }

    fun finalImage() {
        finalActivityImageView1.visibility = View.INVISIBLE
        finalActivityImageView2.visibility = View.INVISIBLE
        finalActivityImageView3.visibility = View.INVISIBLE
        finalActivityImageView4.visibility = View.INVISIBLE

        if(Quiz.checkAvarageCorrectAnswers() >= 100) {
            finalActivityImageView4.visibility = View.VISIBLE
        } else if(Quiz.checkAvarageCorrectAnswers() > 80) {
            finalActivityImageView3.visibility = View.VISIBLE
        } else if(Quiz.checkAvarageCorrectAnswers() > 50) {
            finalActivityImageView2.visibility = View.VISIBLE
        } else {
            finalActivityImageView1.visibility = View.VISIBLE
        }
    }
}
