package eduardo.gladzik.aula19quiz.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import eduardo.gladzik.aula19quiz.R
import eduardo.gladzik.aula19quiz.extension.toast
import eduardo.gladzik.aula19quiz.model.Quiz
import kotlinx.android.synthetic.main.activity_5.*
import kotlinx.android.synthetic.main.activity_6.*

class Activity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_6)

        activity6ButtonNext.visibility = View.INVISIBLE

        Quiz.shuffleQuestions()
        val question = Quiz.questionsArray.get(0)

        getScore()

        activity6TextViewQuestion.text = question.questionDescription
        activity6RadioButtonA.text = question.option1
        activity6RadioButtonB.text = question.option2
        activity6RadioButtonC.text = question.option3
        activity6RadioButtonD.text = question.option4

        activity6ButtonConfirm.setOnClickListener {
            activity6ButtonNext.visibility = View.VISIBLE
            activity6ButtonConfirm.visibility = View.INVISIBLE

            val id = activity6RadioGroup.checkedRadioButtonId
            val radio: RadioButton = findViewById(id)

            if (Quiz.verifyTheCorrectAnswer(radio.text.toString())) {
                toast(R.string.toast_thats_correct)
            } else {
                toast(R.string.toast_thats_incorrect)
            }
        }

        activity6ButtonNext.setOnClickListener {
            startActivity(Intent(this@Activity6, Activity7::class.java))
            finish()
        }

    }

    fun getScore() {
        activity6TextViewScore.text = Quiz.score().toString()
    }
}