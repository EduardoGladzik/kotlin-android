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
import kotlinx.android.synthetic.main.activity_14.*
import kotlinx.android.synthetic.main.activity_7.*

class Activity14 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_14)

        activity14ButtonNext.visibility = View.INVISIBLE

        Quiz.shuffleQuestions()
        val question = Quiz.questionsArray.get(0)

        getScore()

        activity14TextViewQuestion.text = question.questionDescription
        activity14RadioButtonA.text = question.option1
        activity14RadioButtonB.text = question.option2
        activity14RadioButtonC.text = question.option3
        activity14RadioButtonD.text = question.option4

        activity14ButtonConfirm.setOnClickListener {
            activity14ButtonNext.visibility = View.VISIBLE
            activity14ButtonConfirm.visibility = View.INVISIBLE

            val id = activity14RadioGroup.checkedRadioButtonId
            val radio: RadioButton = findViewById(id)

            if (Quiz.verifyTheCorrectAnswer(radio.text.toString())) {
                toast(R.string.toast_thats_correct)
            } else {
                toast(R.string.toast_thats_incorrect)
            }
        }

        activity14ButtonNext.setOnClickListener {
            vibrate()
            startActivity(Intent(this@Activity14, Activity15::class.java))
            finish()
        }
    }

    fun getScore() {
        activity14TextViewScore.text = Quiz.score().toString()
    }
}