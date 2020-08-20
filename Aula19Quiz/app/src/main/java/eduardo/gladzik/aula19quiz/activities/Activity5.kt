package eduardo.gladzik.aula19quiz.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import eduardo.gladzik.aula19quiz.R
import eduardo.gladzik.aula19quiz.extension.toast
import eduardo.gladzik.aula19quiz.model.Quiz
import kotlinx.android.synthetic.main.activity_4.*
import kotlinx.android.synthetic.main.activity_5.*

class Activity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_5)
        activity5ButtonNext.visibility = View.INVISIBLE

        Quiz.shuffleQuestions()
        val question = Quiz.questionsArray.get(0)

        getScore()

        activity5TextViewQuestion.text = question.questionDescription
        activity5RadioButtonA.text = question.option1
        activity5RadioButtonB.text = question.option2
        activity5RadioButtonC.text = question.option3
        activity5RadioButtonD.text = question.option4

        activity5ButtonConfirm.setOnClickListener {
            activity5ButtonNext.visibility = View.VISIBLE
            activity5ButtonConfirm.visibility = View.INVISIBLE

            val id = activity5RadioGroup.checkedRadioButtonId
            val radio: RadioButton = findViewById(id)

            if (Quiz.verifyTheCorrectAnswer(radio.text.toString())) {
                toast(R.string.toast_thats_correct)
            } else {
                toast(R.string.toast_thats_incorrect)
            }
        }

        activity5ButtonNext.setOnClickListener {
            startActivity(Intent(this@Activity5, Activity6::class.java))
            finish()
        }

    }

    fun getScore() {
        activity5TextViewScore.text = Quiz.score().toString()
    }
}