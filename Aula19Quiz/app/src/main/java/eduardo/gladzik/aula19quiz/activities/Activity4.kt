package eduardo.gladzik.aula19quiz.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import eduardo.gladzik.aula19quiz.R
import eduardo.gladzik.aula19quiz.extension.toast
import eduardo.gladzik.aula19quiz.extension.vibrate
import eduardo.gladzik.aula19quiz.model.Quiz
import kotlinx.android.synthetic.main.activity_4.*

class Activity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_4)

        activity4ButtonNext.visibility = View.INVISIBLE

        Quiz.shuffleQuestions()
        val question = Quiz.questionsArray.get(0)

        getScore()

        activity4TextViewQuestion.text = question.questionDescription
        activity4RadioButtonA.text = question.option1
        activity4RadioButtonB.text = question.option2
        activity4RadioButtonC.text = question.option3
        activity4RadioButtonD.text = question.option4

        activity4ButtonConfirm.setOnClickListener {
            activity4ButtonNext.visibility = View.VISIBLE
            activity4ButtonConfirm.visibility = View.INVISIBLE

            val id = activity4RadioGroup.checkedRadioButtonId
            val radio: RadioButton = findViewById(id)

            if (Quiz.verifyTheCorrectAnswer(radio.text.toString())) {
                toast(R.string.toast_thats_correct)
            } else {
                toast(R.string.toast_thats_incorrect)
            }
        }

        activity4ButtonNext.setOnClickListener {
            vibrate()
            startActivity(Intent(this@Activity4, Activity5::class.java))
            finish()
        }

    }

    fun getScore() {
        activity4TextViewScore.text = Quiz.score().toString()
    }
}