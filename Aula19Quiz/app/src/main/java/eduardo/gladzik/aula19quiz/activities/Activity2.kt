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
import kotlinx.android.synthetic.main.activity_1.*
import kotlinx.android.synthetic.main.activity_2.*

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        activity2ButtonNext.visibility = View.INVISIBLE

        Quiz.shuffleQuestions()
        val question = Quiz.questionsArray.get(0)

        getScore()

        activity2TextViewQuestion.text = question.questionDescription
        activity2RadioButtonA.text = question.option1
        activity2RadioButtonB.text = question.option2
        activity2RadioButtonC.text = question.option3
        activity2RadioButtonD.text = question.option4

        activity2ButtonConfirm.setOnClickListener {
            activity2ButtonNext.visibility = View.VISIBLE
            activity2ButtonConfirm.visibility = View.INVISIBLE

            val id = activity2RadioGroup.checkedRadioButtonId
            val radio: RadioButton = findViewById(id)

            if (Quiz.verifyTheCorrectAnswer(radio.text.toString())) {
                toast(R.string.toast_thats_correct)
            } else {
                toast(R.string.toast_thats_incorrect)
            }
        }

        activity2ButtonNext.setOnClickListener {
            vibrate()
            startActivity(Intent(this@Activity2, Activity3::class.java))
            finish()
        }

    }

    fun getScore() {
        activity2TextViewScore.text = Quiz.score().toString()
    }
}