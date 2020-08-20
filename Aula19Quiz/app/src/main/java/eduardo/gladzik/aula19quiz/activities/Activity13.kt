package eduardo.gladzik.aula19quiz.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import eduardo.gladzik.aula19quiz.R
import eduardo.gladzik.aula19quiz.extension.toast
import eduardo.gladzik.aula19quiz.model.Quiz
import kotlinx.android.synthetic.main.activity_13.*
import kotlinx.android.synthetic.main.activity_7.*

class Activity13 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_13)

        activity13ButtonNext.visibility = View.INVISIBLE

        Quiz.shuffleQuestions()
        val question = Quiz.questionsArray.get(0)

        getScore()

        activity13TextViewQuestion.text = question.questionDescription
        activity13RadioButtonA.text = question.option1
        activity13RadioButtonB.text = question.option2
        activity13RadioButtonC.text = question.option3
        activity13RadioButtonD.text = question.option4

        activity13ButtonConfirm.setOnClickListener {
            activity13ButtonNext.visibility = View.VISIBLE
            activity13ButtonConfirm.visibility = View.INVISIBLE

            val id = activity13RadioGroup.checkedRadioButtonId
            val radio: RadioButton = findViewById(id)

            if (Quiz.verifyTheCorrectAnswer(radio.text.toString())) {
                toast(R.string.toast_thats_correct)
            } else {
                toast(R.string.toast_thats_incorrect)
            }
        }

        activity13ButtonNext.setOnClickListener {
            startActivity(Intent(this@Activity13, Activity14::class.java))
            finish()
        }
    }

    fun getScore() {
        activity13TextViewScore.text = Quiz.score().toString()
    }
}