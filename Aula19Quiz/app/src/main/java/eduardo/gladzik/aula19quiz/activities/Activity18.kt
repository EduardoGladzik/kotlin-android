package eduardo.gladzik.aula19quiz.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import eduardo.gladzik.aula19quiz.R
import eduardo.gladzik.aula19quiz.extension.toast
import eduardo.gladzik.aula19quiz.model.Quiz
import kotlinx.android.synthetic.main.activity_18.*
import kotlinx.android.synthetic.main.activity_7.*

class Activity18 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_18)

        activity18ButtonNext.visibility = View.INVISIBLE

        Quiz.shuffleQuestions()
        val question = Quiz.questionsArray.get(0)

        getScore()

        activity18TextViewQuestion.text = question.questionDescription
        activity18RadioButtonA.text = question.option1
        activity18RadioButtonB.text = question.option2
        activity18RadioButtonC.text = question.option3
        activity18RadioButtonD.text = question.option4

        activity18ButtonConfirm.setOnClickListener {
            activity18ButtonNext.visibility = View.VISIBLE
            activity18ButtonConfirm.visibility = View.INVISIBLE

            val id = activity18RadioGroup.checkedRadioButtonId
            val radio: RadioButton = findViewById(id)

            if (Quiz.verifyTheCorrectAnswer(radio.text.toString())) {
                toast(R.string.toast_thats_correct)
            } else {
                toast(R.string.toast_thats_incorrect)
            }
        }

        activity18ButtonNext.setOnClickListener {
            startActivity(Intent(this@Activity18, Activity19::class.java))
            finish()
        }
    }

    fun getScore() {
        activity18TextViewScore.text = Quiz.score().toString()
    }
}