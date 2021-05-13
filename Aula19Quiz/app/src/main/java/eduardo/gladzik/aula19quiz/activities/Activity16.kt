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
import kotlinx.android.synthetic.main.activity_16.*
import kotlinx.android.synthetic.main.activity_7.*

class Activity16 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_16)

        activity16ButtonNext.visibility = View.INVISIBLE

        Quiz.shuffleQuestions()
        val question = Quiz.questionsArray.get(0)

        getScore()

        activity16TextViewQuestion.text = question.questionDescription
        activity16RadioButtonA.text = question.option1
        activity16RadioButtonB.text = question.option2
        activity16RadioButtonC.text = question.option3
        activity16RadioButtonD.text = question.option4

        activity16ButtonConfirm.setOnClickListener {
            activity16ButtonNext.visibility = View.VISIBLE
            activity16ButtonConfirm.visibility = View.INVISIBLE

            val id = activity16RadioGroup.checkedRadioButtonId
            val radio: RadioButton = findViewById(id)

            if (Quiz.verifyTheCorrectAnswer(radio.text.toString())) {
                toast(R.string.toast_thats_correct)
            } else {
                toast(R.string.toast_thats_incorrect)
            }
        }

        activity16ButtonNext.setOnClickListener {
            vibrate()
            startActivity(Intent(this@Activity16, Activity17::class.java))
            finish()
        }
    }

    fun getScore() {
        activity16TextViewScore.text = Quiz.score().toString()
    }
}