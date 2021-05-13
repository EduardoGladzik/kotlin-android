package eduardo.gladzik.aula19quiz.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import eduardo.gladzik.aula19quiz.R
import eduardo.gladzik.aula19quiz.extension.play
import eduardo.gladzik.aula19quiz.extension.toast
import eduardo.gladzik.aula19quiz.extension.vibrate
import eduardo.gladzik.aula19quiz.model.Question
import eduardo.gladzik.aula19quiz.model.Quiz
import kotlinx.android.synthetic.main.activity_1.*

class Activity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)

        activity1ButtonNext.visibility = View.INVISIBLE

        Quiz.context = this@Activity1
        Quiz.generateQuestions()
        Quiz.shuffleQuestions()
        val question = Quiz.questionsArray.get(0)

        getScore()

        activity1TextViewQuestion.text = question.questionDescription
        activity1RadioButtonA.text = question.option1
        activity1RadioButtonB.text = question.option2
        activity1RadioButtonC.text = question.option3
        activity1RadioButtonD.text = question.option4

        activity1ButtonConfirm.setOnClickListener {
            activity1ButtonNext.visibility = View.VISIBLE
            activity1ButtonConfirm.visibility = View.INVISIBLE

            val id = activity1RadioGroup.checkedRadioButtonId
            val radio: RadioButton = findViewById(id)

            if (Quiz.verifyTheCorrectAnswer(radio.text.toString())) {
                toast(R.string.toast_thats_correct)
            } else {
                toast(R.string.toast_thats_incorrect)
            }
        }

        activity1ButtonNext.setOnClickListener {
            vibrate()
            startActivity(Intent(this@Activity1, Activity2::class.java))
            finish()
        }

    }

    fun getScore() {
        activity1TextViewScore.text = Quiz.score().toString()
    }
}