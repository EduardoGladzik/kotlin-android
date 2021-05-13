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
import kotlinx.android.synthetic.main.activity_7.*
import kotlinx.android.synthetic.main.activity_8.*

class Activity8 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_8)
        activity8ButtonNext.visibility = View.INVISIBLE

        Quiz.shuffleQuestions()
        val question = Quiz.questionsArray.get(0)

        getScore()

        activity8TextViewQuestion.text = question.questionDescription
        activity8RadioButtonA.text = question.option1
        activity8RadioButtonB.text = question.option2
        activity8RadioButtonC.text = question.option3
        activity8RadioButtonD.text = question.option4

        activity8ButtonConfirm.setOnClickListener {
            activity8ButtonNext.visibility = View.VISIBLE
            activity8ButtonConfirm.visibility = View.INVISIBLE

            val id = activity8RadioGroup.checkedRadioButtonId
            val radio: RadioButton = findViewById(id)

            if (Quiz.verifyTheCorrectAnswer(radio.text.toString())) {
                toast(R.string.toast_thats_correct)
            } else {
                toast(R.string.toast_thats_incorrect)
            }
        }

        activity8ButtonNext.setOnClickListener {
            vibrate()
            startActivity(Intent(this@Activity8, Activity9::class.java))
            finish()
        }

    }

    fun getScore() {
        activity8TextViewScore.text = Quiz.score().toString()
    }
}