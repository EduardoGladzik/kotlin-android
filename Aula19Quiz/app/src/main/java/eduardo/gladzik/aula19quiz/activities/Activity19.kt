package eduardo.gladzik.aula19quiz.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import eduardo.gladzik.aula19quiz.R
import eduardo.gladzik.aula19quiz.extension.toast
import eduardo.gladzik.aula19quiz.model.Quiz
import kotlinx.android.synthetic.main.activity_19.*
import kotlinx.android.synthetic.main.activity_7.*

class Activity19 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_19)

        activity19ButtonNext.visibility = View.INVISIBLE

        Quiz.shuffleQuestions()
        val question = Quiz.questionsArray.get(0)

        getScore()

        activity19TextViewQuestion.text = question.questionDescription
        activity19RadioButtonA.text = question.option1
        activity19RadioButtonB.text = question.option2
        activity19RadioButtonC.text = question.option3
        activity19RadioButtonD.text = question.option4

        activity19ButtonConfirm.setOnClickListener {
            activity19ButtonNext.visibility = View.VISIBLE
            activity19ButtonConfirm.visibility = View.INVISIBLE

            val id = activity19RadioGroup.checkedRadioButtonId
            val radio: RadioButton = findViewById(id)

            if (Quiz.verifyTheCorrectAnswer(radio.text.toString())) {
                toast(R.string.toast_thats_correct)
            } else {
                toast(R.string.toast_thats_incorrect)
            }
        }

        activity19ButtonNext.setOnClickListener {
            startActivity(Intent(this@Activity19, Activity20::class.java))
            finish()
        }
    }

    fun getScore() {
        activity19TextViewScore.text = Quiz.score().toString()
    }
}