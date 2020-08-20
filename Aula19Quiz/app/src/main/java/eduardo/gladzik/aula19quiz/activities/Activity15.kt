package eduardo.gladzik.aula19quiz.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import eduardo.gladzik.aula19quiz.R
import eduardo.gladzik.aula19quiz.extension.toast
import eduardo.gladzik.aula19quiz.model.Quiz
import kotlinx.android.synthetic.main.activity_15.*
import kotlinx.android.synthetic.main.activity_7.*

class Activity15 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_15)

        activity15ButtonNext.visibility = View.INVISIBLE

        Quiz.shuffleQuestions()
        val question = Quiz.questionsArray.get(0)

        getScore()

        activity15TextViewQuestion.text = question.questionDescription
        activity15RadioButtonA.text = question.option1
        activity15RadioButtonB.text = question.option2
        activity15RadioButtonC.text = question.option3
        activity15RadioButtonD.text = question.option4

        activity15ButtonConfirm.setOnClickListener {
            activity15ButtonNext.visibility = View.VISIBLE
            activity15ButtonConfirm.visibility = View.INVISIBLE

            val id = activity15RadioGroup.checkedRadioButtonId
            val radio: RadioButton = findViewById(id)

            if (Quiz.verifyTheCorrectAnswer(radio.text.toString())) {
                toast(R.string.toast_thats_correct)
            } else {
                toast(R.string.toast_thats_incorrect)
            }
        }

        activity15ButtonNext.setOnClickListener {
            startActivity(Intent(this@Activity15, Activity16::class.java))
            finish()
        }
    }

    fun getScore() {
        activity15TextViewScore.text = Quiz.score().toString()
    }
}